package domain;

import java.util.Date;

public class State {
	/*
	 * �������н��յ��ļ���״̬��װ
	 */
	private String sd;// ��ˮ��
	private String uldid;// ԴIP
	private String txtnm;// ���ݹ������ļ���
	private String path;// �ļ������浽�ĵ�ַ
	private int st;// �ļ���״̬
	private Date dt;// �ϴ�������
	private Long sz;//�ļ���С �����������ݵĻ�ȡ

	public State() {

	}

	public State(String sd, String uldid, String txtnm, String path, int st,
			Date dt, Long sz) {
		super();
		this.sd = sd;
		this.uldid = uldid;
		this.txtnm = txtnm;
		this.path = path;
		this.st = st;
		this.dt = dt;
		this.sz = sz;
	}

	public Long getSz() {
		return sz;
	}

	public void setSz(Long sz) {
		this.sz = sz;
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
				+ ", path=" + path + ", st=" + st + ", dt=" + dt + ", sz=" + sz
				+ "]";
	}

}
