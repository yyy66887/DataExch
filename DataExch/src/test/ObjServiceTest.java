package test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import service.ObjService;
import service.impl.ObjServiceImpl;
import dao.ObjDao;
import dao.impl.ObjDaoImpl;
import domain.DynamicBean;
import domain.ObjTab;

public class ObjServiceTest {
	private ObjService os = new ObjServiceImpl();

	@Test
	public void testAddCol() {
		ObjTab ot = new ObjTab();
		ot.setCol("vo23");
		ot.setDb_type("NUMBER");
		ot.setExp("µÁ—π");
		ot.setJava_type("java.lang.Float");
		ot.setDt(new Date());
		os.addCol(ot);
	}

	@Test
	public void testDeleCol() {
		os.deleCol("vo23");
	}

	@Test
	public void testInsertData(){
//		Object[] obj1 = new Object[] { "111", new Timestamp(new Date().getTime()), (float) 220.5,
//				(float) 39, (float) 60.2, "1" };
//		Object[] obj2 = new Object[] { "123", new Timestamp(new Date().getTime()), (float) 21.5,
//				(float) 395, (float) 47, "2" };
//		Object[] obj3 = new Object[] { "253", new Timestamp(new Date().getTime()), (float) 89.3,
//				(float) 512.87, (float) 23.3, "1" };
//		
//		List<Object[]> list = new ArrayList<>();
//		list.add(obj1);
//		list.add(obj2);
//		list.add(obj3);
//		os.insertData(list);
		
		List<String[]> list = new ArrayList<>();		
		String str1[] = "11145456564,2015-3-15,62,69,35,6".split(",");
		String str2[] = "15656,2016-3-24,62.6,69,35.7,6".split(",");
		String str3[] = "11856,2016-3-20,62,69.3,35,6".split(",");
		list.add(str1);
		list.add(str2);
		list.add(str3);

		
		os.insertData(list);

		
	}

	@Test
	public void testGetTableCols() {
		List<ObjTab> list = os.getTableCols();
		for (ObjTab ot : list) {
			System.out.println(ot);
		}
	}

}
