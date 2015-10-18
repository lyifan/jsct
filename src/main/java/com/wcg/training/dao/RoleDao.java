package com.wcg.training.dao;

import org.springframework.stereotype.Repository;

import com.wcg.training.domain.Role;

@Repository
public class RoleDao extends GenericDao<Role> {

	public RoleDao() {
		super(Role.class);
	}

}
