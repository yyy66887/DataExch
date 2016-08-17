package test;

import java.rmi.server.ObjID;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import Utils.ObjDBCPUtils;
import dao.ObjDao;
import dao.impl.ObjDaoImpl;
import domain.DynamicBean;
import domain.ObjTab;

public class ObjDaoTest {

	private ObjDao od = new ObjDaoImpl();

	@Test
	public void testGetTableColss() {
		List<ObjTab> list = od.getTableColss();
		for (ObjTab ot : list) {
			System.out.println(ot);
		}
	}

	@Test
	public void testAddTableCol() {
		ObjTab ot = new ObjTab();
		ot.setCol("vo23");
		ot.setDb_type("NUMBER");
		ot.setExp("电压");
		ot.setJava_type("java.lang.Float");
		ot.setDt(new Date());
		od.addTableCol(ot);
	}

	@Test
	public void testDeleTableCol() {
		od.deleTableCol("vo23");
	}

	@Test
	public void testGetBeanFields() {
		List<Object> list = od.getBeanFields();
		for (Object o : list) {
			System.out.println(o.toString());
		}
	}

	@Test
	public void testGetJavaType() {
		List<Object> list = od.getJavaType();
		for (Object o : list) {
			System.out.println(o.toString());
		}
	}

	@Test
	public void testInsertCol() {
		// ObjTab ot = new ObjTab();
		// ot.setCol("vol");
		// ot.setDb_type("NUMBER");
		// ot.setExp("电压");
		// ot.setJava_type("java.lang.Float");
		// od.insertCol(ot);
		List<ObjTab> list = od.getTableColss();
		for (ObjTab ot : list) {
			if (ot.getCol().equals("src")) {
				od.insertCol(ot);
			}

		}
	}

	@Test
	public void testDeleCol() {
		od.deleCol("src");
	}

	@Test
	public void testInsertData() throws Exception {
		// bean内容生成
		List<ObjTab> ls = od.getTableColss();
		HashMap propertyMap = new HashMap();
		for (ObjTab ot : ls) {
			propertyMap.put(ot.getCol(), Class.forName(ot.getJava_type()));
		}

		// 25,new Date(),20.5,30.5,60.5,0
		Object[] obj = new Object[] { "25",
				new Timestamp(new Date().getTime()), (float) 20.5,
				(float) 30.5, (float) 60.5, "sd" };
		List<DynamicBean> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			DynamicBean bean = new DynamicBean(propertyMap);
			int q = 0;
			for (ObjTab ot : ls) {
				bean.setValue(ot.getCol(), obj[q]);
				q++;
			}
			list.add(bean);
		}
		// 验证回滚！
		// Object[] o = new Object[] { "25", new Timestamp(new
		// Date().getTime()), (float) 20.5,
		// (float) 30.5, (float) 60.5,
		// "qwertyuiop[]asdfk;jfhkdf;gjhkgjdjdkjl;kdjhasdf" };
		// DynamicBean bean = new DynamicBean(propertyMap);
		// int q = 0;
		// for (ObjTab ot : ls) {
		// bean.setValue(ot.getCol(), o[q]);
		// q++;
		// }
		// list.add(bean);

		od.insertData(list, od.getBeanFields());
	}

}
