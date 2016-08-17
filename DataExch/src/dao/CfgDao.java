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
	/**
	 * 获取 path的倒数第二条数据 可能会出现空的，如果为空证明初始位置为0
	 * @param path
	 * @return
	 */
	public State getLastSecondState(String path);
		
}
