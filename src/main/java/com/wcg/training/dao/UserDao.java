package com.wcg.training.dao;

import com.wcg.training.domain.User;

public class UserDao extends GenericDao<User> {

	public UserDao() {
		super(User.class);
	}

}
