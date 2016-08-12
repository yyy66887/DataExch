package test;

import java.rmi.server.ObjID;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import Utils.ObjDBCPUtils;
import dao.ObjDao;
import dao.impl.ObjDaoImpl;
import domain.ObjTab;

public class ObjDaoTest {

	private ObjDao od = new ObjDaoImpl();
	
	@Test
	public void testInsertExchData() {
	}

	@Test
	public void testGetTableColss() {
		List<ObjTab> list = od.getTableColss();
		for(ObjTab ot:list){
			System.out.println(ot);
		}
	}
	@Test
	public void testInsertCol() {
		ObjTab ot = new ObjTab();
		ot.setCol("vol");
		ot.setDb_type("NUMBER");
		ot.setExp("��ѹ");
		ot.setJava_type("java.lang.Float");
		od.insertCol(ot);
	}
	@Test
	public void testGetColNum() {
		System.out.println(od.getColNum());
	}

}
