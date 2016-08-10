package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.CfgDao;
import dao.impl.CfgDaoImpl;
import domain.State;

public class CfgDaoImplTest {
	private CfgDao cd = new CfgDaoImpl();

	@Test
	public void testGetAllSate() {
		List<State> list = cd.getAllSate();
		for (State s : list) {
			System.out.println(s);
		}
	}

	@Test
	public void testInsertState() {
		State s = new State();
		s.setSd("20");
		s.setUldid("4");
		s.setTxtnm("3");
		s.setPath("2");
		s.setSt(1);
		s.setDt(new Date());

		cd.insertState(s);
	}

	@Test
	public void testState_rec() {
		List<State> list = cd.getState_rec();
		for (State s : list) {
			System.out.println(s);
		}
	}

}
