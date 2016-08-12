package dao;

import java.util.List;

import domain.DynamicBean;
import domain.ExchData;
import domain.ObjTab;

public interface ObjDao {
	/**
	 * 获取目标表结构的配置项
	 * @return
	 */
	public List<ObjTab> getTableColss();
	/**
	 * 向目标表配置表中增加配置项
	 * @param ot
	 */
	public void addTableCol(ObjTab ot);
	/**
	 * 向目标表配置表中根据列名删除一个配置项 
	 * @param col
	 */
	public void deleTableCol(String col);
	/**
	 * 获取动态配置表的字段
	 * @return
	 */
	public List<Object> getBeanFields();
	
	
	
	/**
	 * 向目标表中增加列
	 */
	public void insertCol(ObjTab ot);
	
	/**
	 * @param
	 */
	public void deleCol(String col);
	
	/**
	 * 获取目标表中的列数信息
	 */
	public int getColNum();
	
	/**
	 * 向目标表中进行增加数据操作
	 */
	public void insertData(List<DynamicBean> list);
}
