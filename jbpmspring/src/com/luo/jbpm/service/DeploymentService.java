package com.luo.jbpm.service;

import java.util.List;

import org.jbpm.api.ProcessDefinition;
import org.springframework.stereotype.Service;

@Service
public class DeploymentService extends BaseService{

	public String startDeployment(String jpdlName){
		return jbpmTemplate.startDeployment(jpdlName);
	}

	public List<ProcessDefinition> processDefinitionList() {
		return jbpmTemplate.processDefinitionList();
	}
}
