package com.luo.jbpm.dao;

import java.util.List;

import org.jbpm.api.Configuration;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.HistoryService;
import org.jbpm.api.ManagementService;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.springframework.stereotype.Repository;

@Repository
public class JbpmTemplate {
	private ProcessEngine processEngine;
	private RepositoryService repositoryService = null;
	private ExecutionService executionService = null;
	private TaskService taskService = null;
	private HistoryService historyService = null;
	private ManagementService managementService = null;
	
	/**�������̵����ݿ�
	 * @return
	 */
	public String startDeployment(String jpdlName){
		String deploymentId = repositoryService.createDeployment().addResourceFromClasspath(jpdlName).deploy();
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deploymentId).uniqueResult();
		String processDefinitionId = processDefinition.getId();
		System.out.println("����ID��"+deploymentId);
		System.out.println("������һ��ID��"+processDefinitionId+"Name:"+processDefinition.getName()+"key:"+processDefinition.getKey()+"�����̶���");
		return processDefinitionId;
	}
	
	/**�鿴�������̶����б�
	 * @return
	 */
	public List<ProcessDefinition> processDefinitionList(){
		return repositoryService.createProcessDefinitionQuery().list();
	}
	/**ɾ��һ�����̲���
	 * @param deploymentId
	 */
	public void deleteDeployment(String deploymentId){
		repositoryService.deleteDeploymentCascade(deploymentId);
	}
	
	/**����һ���µ�����ʵ��
	 * @param key
	 * @return
	 */
	public String startProcessInstance(String key){
		ProcessInstance processInstance = executionService.startProcessInstanceByKey(key);
		System.out.println("������һ��ID��"+processInstance+"Name:"+processInstance.getName()+"key:"+processInstance.getKey()+"������ʵ��");
		return processInstance.getId();
	}
	
	/**�������е�����ʵ��
	 * @return
	 */
	public List<ProcessInstance> getProcessInstanceList(){
		return executionService.createProcessInstanceQuery().list();
	}
	
	
	
	
	public JbpmTemplate() {
		
	}
	public void Jbpmtemplate() {
		this.processEngine = Configuration.getProcessEngine();
		this.repositoryService = processEngine.getRepositoryService();
		this.executionService = processEngine.getExecutionService();
		this.taskService = processEngine.getTaskService();
		this.historyService = processEngine.getHistoryService();
		this.managementService = processEngine.getManagementService();
	}
	public ProcessEngine getProcessEngine() {
		return processEngine;
	}
	public void setProcessEngine(ProcessEngine processEngine) {
		this.processEngine = Configuration.getProcessEngine();
		this.repositoryService = processEngine.getRepositoryService();
		this.executionService = processEngine.getExecutionService();
		this.taskService = processEngine.getTaskService();
		this.historyService = processEngine.getHistoryService();
		this.managementService = processEngine.getManagementService();
	}
	public RepositoryService getRepositoryService() {
		return repositoryService;
	}
	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}
	public ExecutionService getExecutionService() {
		return executionService;
	}
	public void setExecutionService(ExecutionService executionService) {
		this.executionService = executionService;
	}
	public TaskService getTaskService() {
		return taskService;
	}
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
	public HistoryService getHistoryService() {
		return historyService;
	}
	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}
	public ManagementService getManagementService() {
		return managementService;
	}
	public void setManagementService(ManagementService managementService) {
		this.managementService = managementService;
	}
}
