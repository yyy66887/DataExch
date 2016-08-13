package Utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class ObjDBCPUtils {
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private static DataSource ds;
	private static Properties pros;
	static {
		try {
			InputStream in = ObjDBCPUtils.class.getClassLoader()
					.getResourceAsStream("objdb.properties");
			pros = new Properties();
			pros.load(in);
			ds = BasicDataSourceFactory.createDataSource(pros);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getUser() {
		return pros.getProperty("username");
	}

	public static DataSource getDataSource() {
		return ds;
	}
	
	//����Ϊ�����������
	/**
	 * ����Ļ�ȡ����
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Connection conn = tl.get();
			if (conn == null) {
				conn = ds.getConnection();
				tl.set(conn);
			}
			return conn;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * ����Ŀ���
	 */
	public static void startTransaction() {
		try {
			Connection conn = tl.get();
			if (conn == null) {
				conn = getConnection();
			}
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ����Ļع�
	 */
	public static void rollback() {
		try {
			Connection conn = tl.get();
			if (conn == null) {
				conn = getConnection();
			}
			conn.rollback();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ������ύ
	 */
	public static void commit() {
		try {
			Connection conn = tl.get();
			if (conn == null) {
				conn = getConnection();
			}
			conn.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��Դ���ͷ�
	 */
	public static void relase() {
		try {
			Connection conn = tl.get();
			if (conn != null) {
				conn.close();
				tl.remove();
			}
		} catch (SQLException e) {
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
				tl.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

}
