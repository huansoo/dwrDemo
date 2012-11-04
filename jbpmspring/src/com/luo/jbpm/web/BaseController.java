package com.luo.jbpm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luo.jbpm.service.DeploymentService;
import com.luo.jbpm.service.ProcessInstanceService;

@Component
public class BaseController {

	protected final String LEAVE = "leave";
	@Autowired
	public DeploymentService deploymentService;
	@Autowired
	public ProcessInstanceService processInstanceService;
}
