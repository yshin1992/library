package com.library.dao.impl;

import java.io.Serializable;

import com.library.dao.ManagerDao;
import com.library.domain.Manager;
import com.library.util.DBTemplate;

public class ManagerDaoImpl implements ManagerDao<Manager> {

	private static final String QUERY_MANAGER = "select managerID,username,sex,telephone,email,isAdmin from manager where managerID=? and password=? and status=0";

	private static final String DELETE_MANAGER = "update manager set status=1 where managerID=?";

	private static final String UPDATE_MANAGER = "update manager set username=?,sex=?,telephone=?,email=? where managerID=?";

	private static final String INSERT_MANAGER = "insert into manager(managerID,username,password,sex,telephone,email) values(?,?,?,?,?,?)";

	@Override
	public Integer addModel(Manager t) {
		Object[] params = { t.getManagerID(), t.getUsername(), t.getPassword(), t.getSex(), t.getTelephone(),
				t.getEmail() };
		return DBTemplate.executeUpdate(INSERT_MANAGER, params);
	}

	@Override
	public Integer deleteModel(Manager t) {
		Object[] params = { t.getManagerID() };
		return DBTemplate.executeUpdate(DELETE_MANAGER, params);
	}

	@Override
	public Integer updateModel(Manager t) {
		Object[] params = { t.getUsername(), t.getSex(), t.getTelephone(), t.getEmail(), t.getManagerID() };
		return DBTemplate.executeUpdate(UPDATE_MANAGER, params);
	}

	public Manager getModel2(Manager t) {
		Object[] params = { t.getManagerID(), t.getPassword() };
		return (Manager) DBTemplate.queryForObject(QUERY_MANAGER, params, Manager.class);
	}

	@Override
	public Manager getModel(Serializable t) {
		if (t instanceof Manager) {
			Manager manager = (Manager) t;
			Object[] params = { manager.getManagerID(), manager.getPassword() };
			return (Manager) DBTemplate.queryForObject(QUERY_MANAGER, params, Manager.class);
		}
		return null;
	}
}
