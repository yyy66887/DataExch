package service;

import java.util.Date;
import java.util.List;

import domain.State;


public interface CfgService {
	/**
	 *���״̬ 
	 */
	public void addState(String sd,String ulid,String txtnm,String Path,int st,Date dt,long sz);
	/**
	 * ��ȡȫ��״̬
	 * @return ״̬�б�
	 */
	public List<State> getStates();
}
