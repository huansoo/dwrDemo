package com.luo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luo.db.DaoTemplate;
import com.luo.model.User;

@Repository
public class UserDao {

	@Autowired
	public DaoTemplate daoTemplate;
	
	public void save(User user) {
		daoTemplate.save(user,"t_user");
	}

}
