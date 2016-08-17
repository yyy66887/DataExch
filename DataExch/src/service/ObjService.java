package service;

import java.util.List;

import domain.ObjTab;

public interface ObjService {
	/**
	 * �����ñ��Ŀ���������һ��
	 * 
	 * @param ot
	 *            ���ñ��װBean
	 */
	public void addCol(ObjTab ot);

	/**
	 * �����ñ��Ŀ�����ɾ��һ��
	 * 
	 * @param col
	 *            ����
	 */
	public void deleCol(String col);

	/**
	 * ��Ŀ�������������
	 * 
	 * @param line
	 *            һ������','�ż��
	 */
	public void insertData(List<String[]> str_ls);

	/**
	 * ��ȡĿ���ṹ��������
	 * 
	 * @return
	 */
	public List<ObjTab> getTableCols();
}
