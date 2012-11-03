package com.luo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luo.model.User;

@Service
public interface UserService {

	public void save(User user);

	/** 
	* @Title: findUserList 
	* @Description: 查找所有的用户
	* @param @return 
	* @return List<User>
	* @throws 
	*/
	public List<User> findUserList();

	/** 
	* @Title: findUserById 
	* @Description: TODO
	* @param @param i
	* @param @return 
	* @return User
	* @throws 
	*/
	public User findUserById(int i);

	public int queryUsersCount();
}
