package Utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class CfgDBCPUtils {
	private static DataSource ds;
	static {
		try {
			InputStream in = CfgDBCPUtils.class.getClassLoader()
					.getResourceAsStream("cfgdb.properties");
			Properties pros = new Properties();
			pros.load(in);
			ds = BasicDataSourceFactory.createDataSource(pros);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource(){
		return ds;
	}
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void release(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

}
