package domain;

import java.util.Date;

public class ObjTab {
	/*
	 * ��Ŀ���Ķ�̬���� ����DynamicBean���з�װ
	 */
	private String col;// ���ɱ������
	private String java_type;// ������װ���Ӧ��java����
	private String exp;// �������Ľ���
	private String db_type;// ��Ӧ����е�����
	private Date dt;// �����ֶε�ʱ�䣬��������

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public String getDb_type() {
		return db_type;
	}

	public void setDb_type(String db_type) {
		this.db_type = db_type;
	}

	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public String getJava_type() {
		return java_type;
	}

	public void setJava_type(String java_type) {
		this.java_type = java_type;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "ObjTab [col=" + col + ", java_type=" + java_type + ", exp="
				+ exp + ", db_type=" + db_type + ", dt=" + dt + "]";
	}



}
