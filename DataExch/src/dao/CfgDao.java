package dao;

import java.util.List;

import domain.State;

public interface CfgDao {

	//TODO ������Ʒ�ҳ
	/**
	 * ��ȡ���е�״̬
	 * @return 
	 */
	public List<State> getAllSate();
	/**
	 * ����״̬
	 */
	public void insertState(State s);
	/**
	 * ��ȡ ȫ��rec״̬
	 * @return
	 */
	public List<State> getState_rec();
		
}