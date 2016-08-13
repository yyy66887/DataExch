package dao;

import java.util.List;

import domain.DynamicBean;
import domain.ExchData;
import domain.ObjTab;

public interface ObjDao {
	/**
	 * 获取目标表结构的配置项
	 * 
	 * @return
	 */
	public List<ObjTab> getTableColss();

	/**
	 * 向目标表配置表中增加配置项
	 * 
	 * @param ot
	 */
	public void addTableCol(ObjTab ot);

	/**
	 * 向目标表配置表中根据列名删除一个配置项
	 * 
	 * @param col
	 */
	public void deleTableCol(String col);

	/**
	 * 获取动态配置表的字段
	 * 
	 * @return
	 */
	public List<Object> getBeanFields();

	/**
	 * 向目标表中增加列
	 * 
	 * @param 配置项Bean
	 */
	public void insertCol(ObjTab ot);

	/**
	 * 目标表中删除列
	 * 
	 * @param
	 */
	public void deleCol(String col);


	/**
	 * 向目标表中进行增加数据操作
	 * 
	 * @param 动态封装类列表
	 *            表中字段通过getBeanFields获取
	 */
	public void insertData(List<DynamicBean> list, List<Object> fields);
}
