package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.UUID;

import Utils.Md5Utils;
import dao.CfgDao;
import dao.impl.CfgDaoImpl;
import domain.FilePro;
import domain.State;
import domain.StateStatus;

public class FileRecSer {
	/**
	 * 需要传入配置的输出文件路径
	 * @param parph
	 */
	public void fileRec(String parph) {
		ServerSocket ss = null;
		// TODO 线程池来做
		try {
			ss = new ServerSocket(10086);
			while (true) {

				new Thread(new MuFilRecSer(ss.accept(), parph)).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private class MuFilRecSer implements Runnable {

		private Socket s;
		private FileOutputStream fout;
		private String parpth;// 保存到的父级目录
		
		public MuFilRecSer(Socket s, String parth) {
			this.s = s;
			this.parpth = parth;
		}

		@Override
		public void run() {
			State ste =null;
			//入库
			CfgDao cd = new CfgDaoImpl();
			try {
				//服务端接收 流
				InputStream in = s.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(in);
				FilePro fp = (FilePro) ois.readObject();//接收对象流
				String pardir = parpth + "/"
						+ s.getInetAddress().getHostAddress();// 父级文件夹
				File file = new File(pardir);
				if (!file.exists()) {
					file.mkdirs();
				}
				String path = pardir + "/" + fp.getFilenm();
				fout = new FileOutputStream(path);
				//写文件
				int len = -1;
				byte[] buf = new byte[1024];
				while ((len = in.read(buf)) != -1) {
					fout.write(buf, 0, len);
				}
				//封装
				ste = new State();
				ste.setSd(UUID.randomUUID().toString());
				ste.setUldid(s.getInetAddress().getHostAddress());
				ste.setTxtnm(fp.getFilenm());
				ste.setPath(path);
				ste.setSt(StateStatus.rec);
				ste.setDt(new Date());
				ste.setSz(fp.getSz());
				
				// 通知客户端，文件上传的成功与否
				String check = Md5Utils.encoding(new File(path));
				OutputStream out = s.getOutputStream();
				if (check.equals(fp.getMd5()))
					out.write("ok".getBytes());
				else
					out.write("wrong".getBytes());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("上传失败,文件位置错误，请重新配置");
			} catch (IOException e) {
				throw new RuntimeException("上传失败，文件读写错误，请重新配置");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				cd.insertState(ste);
				if (s != null) {
					try {
						s.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (fout != null) {
					try {
						fout.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

}
