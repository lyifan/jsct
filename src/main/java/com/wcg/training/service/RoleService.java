package com.wcg.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wcg.training.dao.RoleDao;
import com.wcg.training.domain.Role;

public class RoleService {
	
	@Autowired
	private RoleDao _roleDao;
	
	public void saveUser(Role role) {
		_roleDao.save(role);
	}
	
	public List<Role> getAllRoles() {
		return _roleDao.getAll();
	}

}
