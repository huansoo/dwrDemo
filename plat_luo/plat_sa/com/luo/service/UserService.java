package com.luo.service;

import org.springframework.stereotype.Service;

import com.luo.model.User;

@Service
public interface UserService {

	public void save(User user);

	
}
