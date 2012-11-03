package com.luo.action;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luo.model.User;
import com.luo.service.UserService;

@Repository
public class UserAction extends BaseAction{

	@Autowired
	public UserService userService;
	
	public String save(){
		User user = new User();
		user.setId(1);
		user.setUsername("tom");
		user.setPassword("123");
		userService.save(user);
		return SUCCESS;
	}
	
	
	public String userList(){
		List<User> userList = userService.findUserList();
		request.setAttribute("userList", userList);
		return SUCCESS;
	}

	public User findUserById(){
		return userService.findUserById(1);
	}
	
	public String queryUsersCount(){
		int n = userService.queryUsersCount();
		request.setAttribute("n", n);
		return SUCCESS;
	}
}
