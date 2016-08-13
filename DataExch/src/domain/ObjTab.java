package domain;

import java.util.Date;

public class ObjTab {
	/*
	 * 对目标表的动态配置 利用DynamicBean进行封装
	 */
	private String col;// 生成表的列名
	private String java_type;// 列名封装后对应的java类型
	private String exp;// 对列名的解释
	private String db_type;// 对应表的列的类型
	private Date dt;// 创建字段的时间，方便排序

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
