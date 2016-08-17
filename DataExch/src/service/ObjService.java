package service;

import java.util.List;

import domain.ObjTab;

public interface ObjService {
	/**
	 * 向配置表和目标表中增加一列
	 * 
	 * @param ot
	 *            配置表封装Bean
	 */
	public void addCol(ObjTab ot);

	/**
	 * 向配置表和目标表中删除一列
	 * 
	 * @param col
	 *            列名
	 */
	public void deleCol(String col);

	/**
	 * 向目标表中增加数据
	 * 
	 * @param line
	 *            一行数据','号间隔
	 */
	public void insertData(List<String[]> str_ls);

	/**
	 * 获取目标表结构的配置项
	 * 
	 * @return
	 */
	public List<ObjTab> getTableCols();
}
