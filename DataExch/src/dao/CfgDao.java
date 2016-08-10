package dao;

import java.util.List;

import domain.State;

public interface CfgDao {

	//TODO 将来设计分页
	/**
	 * 获取所有的状态
	 * @return 
	 */
	public List<State> getAllSate();
	/**
	 * 插入状态
	 */
	public void insertState(State s);
	/**
	 * 获取 全部rec状态
	 * @return
	 */
	public List<State> getState_rec();
		
}
