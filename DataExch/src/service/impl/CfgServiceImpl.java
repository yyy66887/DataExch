package service.impl;

import java.util.Date;
import java.util.List;

import service.CfgService;
import dao.CfgDao;
import dao.impl.CfgDaoImpl;
import domain.State;

public class CfgServiceImpl implements CfgService {
	private CfgDao cd = new CfgDaoImpl();
	@Override
	public void addState(String sd, String ulid, String txtnm, String path,
			int st,Date dt) {
		State s = new State(sd,ulid,txtnm,path,st,dt);
		cd.insertState(s);
	}

	@Override
	public List<State> getStates() {
		return cd.getAllSate();
	}

}
