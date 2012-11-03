package com.luo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luo.dao.UserDao;
import com.luo.model.User;
import com.luo.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	public UserDao userDao;
	
	
	public void save(User user) {
		//user.setId(StringTool.createPK());
		userDao.save(user);
	}

	
	public List<User> findUserList() {
		userDao.findUserList();
		return null;
	}


	public User findUserById(int i) {
		return userDao.findUserById(i);
	}
}
