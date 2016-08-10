package test;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.junit.Test;

import domain.DynamicBean;

public class DynamicTest {

	@Test
	public void test() throws Exception {
		HashMap propertyMap = new HashMap();

		propertyMap.put("id", Integer.class);

		propertyMap.put("name", String.class);

		propertyMap.put("address", String.class);

		// ���ɶ�̬ Bean
		DynamicBean bean = new DynamicBean(propertyMap);

		// �� Bean ����ֵ
		bean.setValue("id", new Integer(123));

		bean.setValue("name", "454");

		bean.setValue("address", "789");

		System.out.println("  >> id      = " + bean.getValue("id"));

		System.out.println("  >> name    = " + bean.getValue("name"));

		System.out.println("  >> address = " + bean.getValue("address"));
		Object object = bean.getObject();
		
		// ͨ������鿴���з�����
		Class clazz = object.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i].getName());
		}
	}

}
