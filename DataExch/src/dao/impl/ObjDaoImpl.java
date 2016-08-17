package dao.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

	private QueryRunner qr_ds = new QueryRunner(ObjDBCPUtils.getDataSource(),
			true);// 不做事务控制的qr
	private QueryRunner qr_nl = new QueryRunner(true);// 事务控制的qr

	@Override
	public List<ObjTab> getTableColss() {
		try {
			List<ObjTab> list = qr_ds.query(
					"select * from OBJ_CONFIG t order by t.dt ",
					new BeanListHandler<ObjTab>(ObjTab.class));
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void addTableCol(ObjTab ot) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
			qr_nl.update(
					ObjDBCPUtils.getConnection(),
					"insert into OBJ_CONFIG t (t.col,t.java_type,t.exp,t.db_type,t.dt) values(?,?,?,?,to_date(?,'yyyy-MM-dd hh24:mi:ss'))",
					ot.getCol(), ot.getJava_type(), ot.getExp(),
					ot.getDb_type(), format.format(ot.getDt()));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleTableCol(String col) {
		try {
			qr_nl.update(ObjDBCPUtils.getConnection(),
					"delete from Obj_Config t where t.col = ?", col);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Object> getBeanFields() {
		try {
			List<Object> list = qr_ds.query(
					"select * from OBJ_CONFIG t order by t.dt",
					new ColumnListHandler("col"));
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Object> getJavaType() {
		try {
			List<Object> list = qr_ds.query(
					"select * from OBJ_CONFIG t order by t.dt",
					new ColumnListHandler("java_type"));
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void insertCol(ObjTab ot) {
		try {
			qr_nl.update(
					ObjDBCPUtils.getConnection(),
					"alter table OBJ_TRACING add(" + ot.getCol() + " "
							+ ot.getDb_type() + ")");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleCol(String col) {
		try {
			qr_nl.update(ObjDBCPUtils.getConnection(),
					"alter table OBJ_TRACING drop column " + col);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void insertData(List<DynamicBean> list, List<Object> fields) {
		Object[][] params = new Object[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			DynamicBean db = list.get(i);
			List<Object> values = new ArrayList<>();
			for (Object o : fields) {
				values.add(db.getValue(o.toString()));
			}
			params[i] = values.toArray();
		}
		String sql_fields = "";
		String sql_values = "";
		for (int i = 0; i < fields.size(); i++) {
			if (i != (fields.size() - 1)) {
				sql_fields = sql_fields + fields.get(i) + ",";
				sql_values = sql_values + "?,";
			} else {
				sql_fields = sql_fields + fields.get(i);
				sql_values = sql_values + "?";
			}
		}
		String sql = "insert into Obj_tracing (" + sql_fields + ") values ("
				+ sql_values + ")";
		// System.out.println(sql);
		try {
			qr_ds.batch(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
