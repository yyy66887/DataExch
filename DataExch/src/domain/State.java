package domain;

import java.util.Date;

public class State {
	/*
	 * 服务器中接收的文件的状态封装
	 */
	private String sd;// 流水号
	private String uldid;// 源IP
	private String txtnm;// 传递过来的文件名
	private String path;// 文件所保存到的地址
	private int st;// 文件的状态
	private Date dt;

	public State() {

	}

	public State(String sd, String uldid, String txtnm, String path, int st,Date dt) {
		super();
		this.sd = sd;
		this.uldid = uldid;
		this.txtnm = txtnm;
		this.path = path;
		this.st = st;
		this.dt = dt;
	}

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public int getSt() {
		return st;
	}

	public void setSt(int st) {
		this.st = st;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSd() {
		return sd;
	}

	public void setSd(String sd) {
		this.sd = sd;
	}

	public String getUldid() {
		return uldid;
	}

	public void setUldid(String uldid) {
		this.uldid = uldid;
	}

	public String getTxtnm() {
		return txtnm;
	}

	public void setTxtnm(String txtnm) {
		this.txtnm = txtnm;
	}

	@Override
	public String toString() {
		return "State [sd=" + sd + ", uldid=" + uldid + ", txtnm=" + txtnm
				+ ", path=" + path + ", st=" + st + ", dt=" + dt + "]";
	}


}
