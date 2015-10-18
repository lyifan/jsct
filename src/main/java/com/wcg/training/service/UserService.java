package com.wcg.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wcg.training.dao.UserDao;
import com.wcg.training.domain.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao _userDao;
	
	public void saveUser(User user) {
		_userDao.save(user);
	}
	
	public List<User> getAllUsers() {
		return _userDao.getAll();
	}
	
	public List<User> findUsers(String loginName) {
		return _userDao.searchUserByLoginName(loginName);
	}
	
	public User findUser(String loginName, String password) {
		
		User target = null;
		
		List<User> users = this.findUsers(loginName);
		
		for(User user : users) {
			// refactor to use a PasswordMatcher
			// which compares hash instead of plain text
			if(user.getPassword().equals(password)) {
				target = user;
				break;
			}
		}
		
		return target;
	}
}
