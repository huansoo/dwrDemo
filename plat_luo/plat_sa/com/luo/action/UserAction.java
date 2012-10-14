package com.luo.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.luo.model.User;
import com.luo.service.UserService;

@Controller
public class UserAction extends BaseAction{

	@Autowired
	public UserService userService;
	
	public String saLogin(){
		User user = new User();
		user.setUsername("tom");
		user.setPassword("123");
		userService.save(user);
		return "index";
	}
	public String saLogin2(){
		System.out.println("saAction2÷¥––¡À");
		return "index2";
	}

}
