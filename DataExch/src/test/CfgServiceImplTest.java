package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import domain.State;
import service.CfgService;
import service.impl.CfgServiceImpl;

public class CfgServiceImplTest {

	private CfgService cs = new CfgServiceImpl();
	@Test
	public void testAddState() {
		cs.addState("3", "4", "5", "6", 7,new Date());
	}

	@Test
	public void testGetStates() {
		List<State> list = cs.getStates();
		for(State s:list){
			System.out.println(s);
		}
	}

}
