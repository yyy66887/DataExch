package domain;

public interface StateStatus {
	/*
	 * 接口 封装接收文件的处理状态
	 */
	//出错状态 考虑下
	public static final int rec =0;//已接收状态
	public static final int handling = 1; //
	public static final int handled = 2;//处理完成状态
}
