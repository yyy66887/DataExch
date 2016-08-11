package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

import org.junit.Test;

import domain.State;
import Utils.CfgDBCPUtils;

public class DaoTest {

	@Test
	public void test() {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = CfgDBCPUtils.getConnection();
			System.out.println(conn);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			CfgDBCPUtils.release(null, stmt, conn);
		}
	}

}
