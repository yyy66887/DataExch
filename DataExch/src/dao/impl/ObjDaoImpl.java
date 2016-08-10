package dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import Utils.CfgDBCPUtils;
import dao.ObjDao;
import domain.ExchData;

public class ObjDaoImpl implements ObjDao{

	private QueryRunner qr = new QueryRunner(CfgDBCPUtils.getDataSource(),true);//oracle 
	@Override
	public void insertExchData(List<ExchData> list) {
		Object params[][] = new Object[list.size()][];
		for(ExchData ed : list){
//			qr.batch("insert into", params);
		}
	}

}
