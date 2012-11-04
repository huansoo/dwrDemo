package com.luo.jbpm.service;

import java.util.List;

import org.jbpm.api.ProcessInstance;
import org.springframework.stereotype.Service;

@Service
public class ProcessInstanceService extends BaseService{

	public String startProcessInstanceByKey(String LEAVE) {
		return jbpmTemplate.startProcessInstance(LEAVE);
	}

	public List<ProcessInstance> processInstanceList() {
		return jbpmTemplate.getProcessInstanceList();
	}

}
