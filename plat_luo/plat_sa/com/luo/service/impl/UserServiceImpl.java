package com.luo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luo.dao.UserDao;
import com.luo.model.User;
import com.luo.service.UserService;
import com.luo.util.StringTool;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	public UserDao userDao;
	
	
	public void save(User user) {
		user.setId(StringTool.createPK());
		userDao.save(user);
	}

}
