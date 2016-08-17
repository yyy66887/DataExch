package test;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

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

	@Test
	public void test2() throws Exception {
		RandomAccessFile file = new RandomAccessFile("C:/Users/charmyyy/Desktop/test.txt", "r");
		System.out.println(file.length());
		file.seek(182);
		System.out.println(file.readLine());
	}
}
