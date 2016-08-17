package service;

import java.util.Date;
import java.util.List;

import domain.State;


public interface CfgService {
	/**
	 *添加状态 
	 */
	public void addState(String sd,String ulid,String txtnm,String Path,int st,Date dt,long sz);
	/**
	 * 获取全部状态
	 * @return 状态列表
	 */
	public List<State> getStates();
}
