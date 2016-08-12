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
	 * ��Ŀ�����������
	 */
	public void insertCol(ObjTab ot);
	
	/**
	 * ��ȡĿ����е�������Ϣ
	 */
	public int getColNum();
	
	/**
	 * ��Ŀ����н������Ӳ���
	 */
	public void insertData(List<DynamicBean> list);
}
