package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import dao.CfgDao;
import dao.impl.CfgDaoImpl;
import domain.ExchData;
import domain.State;

public class FileAnal {
	/**
	 * @param 传当前的状态
	 */
	public List<String[]> getEtnd(State s){
		try {
			CfgDao cd = new  CfgDaoImpl();
			String path = s.getPath();
			State ls = cd.getLastSecondState(path);
			RandomAccessFile raf = new RandomAccessFile(path, "r");
			if(ls==null||s.getSz()<ls.getSz())
				raf.seek(0);
			else
				raf.seek(ls.getSz()+2);//+2是因为换行符
			List<String[]> list = new ArrayList<>();
			String str = "";
			while((str=raf.readLine())!=null){
				list.add(str.split(","));
				System.out.println(str);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 解析文本文件 
	 * @param file
	 * @return 返回ExchData的列表
	 */
	public List<ExchData> analysis(File file) {
		BufferedReader br = null;
		List<ExchData> list = null;
		try {
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = null;
			list = new ArrayList<ExchData>();
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				String[] strs = line.split(",");
				ExchData ed = new ExchData();
				ed.setYear(Integer.parseInt(strs[0]));
				ed.setDay(Integer.parseInt(strs[1]));
				ed.setFlow(Float.parseFloat(strs[2]));
				ed.setRainfall(Float.parseFloat(strs[3]));
				ed.setVoltage(Float.parseFloat(strs[4]));
				list.add(ed);
			}
			return list;
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
