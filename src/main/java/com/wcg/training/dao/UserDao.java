package com.wcg.training.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.wcg.training.domain.User;

@Repository
public class UserDao extends GenericDao<User> {

	public UserDao() {
		super(User.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> searchUserByLoginName(String loginName) {
		Criteria search = this.getCurrentSession().createCriteria(User.class);
		
		search.add( Restrictions.like("loginName", loginName) );
		
		return (List<User>) search.list();
	}

}
