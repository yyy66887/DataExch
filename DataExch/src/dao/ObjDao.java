package dao;

import java.util.List;

import domain.DynamicBean;
import domain.ExchData;
import domain.ObjTab;

public interface ObjDao {
	/**
	 * ��ȡĿ���ṹ��������
	 * @return
	 */
	public List<ObjTab> getTableColss();
	/**
	 * ��Ŀ������ñ�������������
	 * @param ot
	 */
	public void addTableCol(ObjTab ot);
	/**
	 * ��Ŀ������ñ��и�������ɾ��һ�������� 
	 * @param col
	 */
	public void deleTableCol(String col);
	/**
	 * ��ȡ��̬���ñ���ֶ�
	 * @return
	 */
	public List<Object> getBeanFields();
	
	
	
	/**
	 * ��Ŀ�����������
	 */
	public void insertCol(ObjTab ot);
	
	/**
	 * @param
	 */
	public void deleCol(String col);
	
	/**
	 * ��ȡĿ����е�������Ϣ
	 */
	public int getColNum();
	
	/**
	 * ��Ŀ����н����������ݲ���
	 */
	public void insertData(List<DynamicBean> list);
}
