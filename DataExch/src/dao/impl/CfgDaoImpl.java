package dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import Utils.CfgDBCPUtils;
import dao.CfgDao;
import domain.State;
import domain.StateStatus;

public class CfgDaoImpl implements CfgDao {
	private QueryRunner qr = new QueryRunner(CfgDBCPUtils.getDataSource(),true);//oracle 
	@Override
	public List<State> getAllSate() {
		try {
			List<State> list = qr.query("select * from CONFIG t", new BeanListHandler<State>(State.class));
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void insertState(State s) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
			qr.update("insert into CONFIG t (t.sd,t.uldid,t.txtnm,t.path,t.st,t.dt) values (?,?,?,?,?,to_date(?,'yyyy-MM-dd hh24:mi:ss'))", s.getSd(),s.getUldid(),s.getTxtnm(),s.getPath(),s.getSt(),format.format(s.getDt()));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<State> getState_rec() {
		List<State> list;
		try {
			list = qr.query("select * from CONFIG t where t.st = ? order by t.dt", new BeanListHandler<State>(State.class),StateStatus.rec);
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
