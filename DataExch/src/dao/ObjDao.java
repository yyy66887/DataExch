package dao;

import java.util.List;

import domain.DynamicBean;
import domain.ExchData;
import domain.ObjTab;

public interface ObjDao {
	/**
	 * ��ȡĿ���ṹ��������
	 * 
	 * @return
	 */
	public List<ObjTab> getTableColss();

	/**
	 * ��Ŀ������ñ�������������
	 * 
	 * @param ot
	 */
	public void addTableCol(ObjTab ot);

	/**
	 * ��Ŀ������ñ��и�������ɾ��һ��������
	 * 
	 * @param col
	 */
	public void deleTableCol(String col);

	/**
	 * ��ȡ��̬���ñ���ֶ�
	 * 
	 * @return
	 */
	public List<Object> getBeanFields();

	/**
	 * ��Ŀ�����������
	 * 
	 * @param ������Bean
	 */
	public void insertCol(ObjTab ot);

	/**
	 * Ŀ�����ɾ����
	 * 
	 * @param
	 */
	public void deleCol(String col);


	/**
	 * ��Ŀ����н����������ݲ���
	 * 
	 * @param ��̬��װ���б�
	 *            �����ֶ�ͨ��getBeanFields��ȡ
	 */
	public void insertData(List<DynamicBean> list, List<Object> fields);
}
