package dao;

import java.util.List;

import domain.ExchData;

public interface ObjDao {
	/**
	 * 向目标数据库中进行增加操作
	 */
	public void insertExchData(List<ExchData> list);
}
