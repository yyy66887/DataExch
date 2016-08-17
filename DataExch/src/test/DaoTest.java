package test;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import Utils.CfgDBCPUtils;
import Utils.Log4jUtils;

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
	@Test
	public void test3() throws Exception {
		for(int i =0;i<50;i++){			
			Log4jUtils.getLog(String.class, "收到货刚收到交换机和克里斯放公会珊姐发过来可视电话");
		}
	}
}
