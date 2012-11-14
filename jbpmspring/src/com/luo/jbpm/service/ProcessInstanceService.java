package com.luo.jbpm.service;

import java.util.List;
import java.util.Map;

import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;

@Service
public class ProcessInstanceService extends BaseService{

	public String startProcessInstanceById(String processdefinitionId,Map<String,Object> map) {
		return jbpmTemplate.startProcessInstanceById(processdefinitionId,map);
	}

	public List<ProcessInstance> processInstanceList() {
		return jbpmTemplate.getProcessInstanceList();
	}

	public ProcessInstance viewProcessInstance(String processInstanceId) {
		return jbpmTemplate.viewProcessInstance(processInstanceId);
	}

	public List<Task> findTaskListByUser(String username) {
		return jbpmTemplate.findTaskListByUser(username);
	}

	public void completeTask(String taskId, Map map) {
		jbpmTemplate.completeTask(taskId,map);
	}

	public String getMapById(String taskId, String key) {
		return jbpmTemplate.getMapById(taskId,key);
	}

}
