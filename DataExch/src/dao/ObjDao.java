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
	 * 向目标表中增加列
	 */
	public void insertCol(ObjTab ot);
	
	/**
	 * 获取目标表中的列数信息
	 */
	public int getColNum();
	
	/**
	 * 向目标表中进行增加操作
	 */
	public void insertData(List<DynamicBean> list);
}
