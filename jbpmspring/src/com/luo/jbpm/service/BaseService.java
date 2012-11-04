package com.luo.jbpm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luo.jbpm.dao.JbpmTemplate;
@Service
public class BaseService {

	@Autowired
	public JbpmTemplate jbpmTemplate;
}
