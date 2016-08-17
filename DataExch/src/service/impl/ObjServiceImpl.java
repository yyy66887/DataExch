package service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import service.ObjService;
import Utils.ObjDBCPUtils;
import dao.ObjDao;
import dao.impl.ObjDaoImpl;
import domain.DynamicBean;
import domain.ObjTab;

public class ObjServiceImpl implements ObjService {

	private ObjDao od = new ObjDaoImpl();

	@Override
	public void addCol(ObjTab ot) {
		try {
			ObjDBCPUtils.startTransaction();
			od.addTableCol(ot);
			od.insertCol(ot);
		} catch (Exception e) {
			ObjDBCPUtils.rollback();
			e.printStackTrace();
		} finally {
			ObjDBCPUtils.commit();
			ObjDBCPUtils.relase();
		}
	}

	@Override
	public void deleCol(String col) {
		try {
			ObjDBCPUtils.startTransaction();
			od.deleTableCol(col);
			od.deleCol(col);
		} catch (Exception e) {
			ObjDBCPUtils.rollback();
			e.printStackTrace();
		} finally {
			ObjDBCPUtils.commit();
			ObjDBCPUtils.relase();
		}
	}

//	@Override
//	public void insertData(List<Object[]> obj_ls) {
//		try {
//			// bean字段和方法构造
//			List<ObjTab> ls = od.getTableColss();
//			HashMap propertyMap = new HashMap();
//			for (ObjTab ot : ls) {
//				propertyMap.put(ot.getCol(), Class.forName(ot.getJava_type()));
//			}
//
//			List<DynamicBean> list = new ArrayList<>();
//			for (Object[] obj : obj_ls) {
//				DynamicBean bean = new DynamicBean(propertyMap);
//				int q = 0;
//				for (ObjTab ot : ls) {
//					bean.setValue(ot.getCol(), obj[q]);
//					q++;
//				}
//				list.add(bean);
//			}
//			od.insertData(list, od.getBeanFields());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public void insertData(List<String[]> str_ls) {
		try {
			// bean字段和方法构造
			List<ObjTab> ls = od.getTableColss();
			HashMap propertyMap = new HashMap();
			for (ObjTab ot : ls) {
				propertyMap.put(ot.getCol(), Class.forName(ot.getJava_type()));
			}

			List<DynamicBean> list = new ArrayList<>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			for (String[] str : str_ls) {
				DynamicBean bean = new DynamicBean(propertyMap);
				int q = 0;
				for (ObjTab ot : ls) {
					String col = ot.getCol();
					if(ot.getJava_type().equals("java.sql.Timestamp")){
						bean.setValue(col, new Timestamp(sdf.parse(str[q]).getTime()));
					}else if(ot.getJava_type().equals("java.lang.Float")){
						bean.setValue(col,Float.parseFloat(str[q]) );
					}else{						
						bean.setValue(col, str[q]);
					}
					q++;
				}
				list.add(bean);
			}
			od.insertData(list, od.getBeanFields());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ObjTab> getTableCols() {
		return od.getTableColss();
	}

}
