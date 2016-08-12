package dao.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import Utils.CfgDBCPUtils;
import Utils.ObjDBCPUtils;
import dao.ObjDao;
import domain.DynamicBean;
import domain.ExchData;
import domain.ObjTab;

public class ObjDaoImpl implements ObjDao {

	private QueryRunner qr = new QueryRunner(ObjDBCPUtils.getDataSource(), true);// oracle

	

	@Override
	public List<ObjTab> getTableColss() {
		try {
			List<ObjTab> list = qr.query(
					"select * from OBJ_CONFIG t ",
					new BeanListHandler<ObjTab>(ObjTab.class));
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void insertCol(ObjTab ot) {
		try {
			qr.update("alter table OBJ_TRACING add(" + ot.getCol() + " "
					+ ot.getDb_type() + ")");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getColNum() {
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ObjDBCPUtils.getConnection();
			DatabaseMetaData dbmd = conn.getMetaData();
			rs = dbmd.getColumns("", ObjDBCPUtils.getUser().toUpperCase(),
					"OBJ_TRACING".toUpperCase(), "%");
			return rs.getFetchSize();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	@Override
	public void addTableCol(ObjTab ot) {
		try {
			qr.update(
					"insert into OBJ_CONFIG t (t.col,t.java_type,t.exp,t.db_type) values(?,?,?,?)",
					ot.getCol(), ot.getJava_type(), ot.getExp(), ot.getDb_type());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleCol(String col) {
		try {
			qr.update("alter table OBJ_TRACING drop column "+col);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void insertData(List<DynamicBean> list) {
		
	}

	@Override
	public void deleTableCol(String col) {
		try {
			qr.update("delete from Obj_Config t where t.col = ?", col);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Object> getBeanFields() {
		try {
			List<Object> list = qr.query("select * from OBJ_CONFIG t ",new ColumnListHandler("col"));
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
