package com.luo.jbpm.dao;

import java.util.List;
import java.util.Map;

import org.jbpm.api.ExecutionService;
import org.jbpm.api.HistoryService;
import org.jbpm.api.ManagementService;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;

public class JbpmTemplate {
	
	private ProcessEngine processEngine;
	private RepositoryService repositoryService = null;
	private ExecutionService executionService = null;
	private TaskService taskService = null;
	private HistoryService historyService = null;
	private ManagementService managementService = null;
	
	
	public JbpmTemplate() {
		
	}
	public void Jbpmtemplate(ProcessEngine processEngine) {
		this.processEngine = processEngine;
		this.repositoryService = processEngine.getRepositoryService();
		this.executionService = processEngine.getExecutionService();
		this.taskService = processEngine.getTaskService();
		this.historyService = processEngine.getHistoryService();
		this.managementService = processEngine.getManagementService();
	}
	
	/**�������̵����ݿ�
	 * @param map 
	 * @return
	 */
	public String startDeployment(String jpdlName){
		String deploymentId = repositoryService.createDeployment().addResourceFromClasspath(jpdlName).deploy();
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deploymentId).uniqueResult();
		String processDefinitionId = processDefinition.getId();
		System.out.println("����ID��"+deploymentId);
		System.out.println("������һ��ID��"+processDefinitionId+",Name:"+processDefinition.getName()+",key:"+processDefinition.getKey()+"�����̶���");
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
	public String startProcessInstanceById(String processdefinitionId,Map map){
		ProcessInstance processInstance = executionService.startProcessInstanceById(processdefinitionId,map);
		System.out.println("������һ��ID��"+processInstance+"Name:"+processInstance.getName()+"key:"+processInstance.getKey()+"������ʵ��");
		return processInstance.getId();
	}
	
	/**�������е�����ʵ��
	 * @return
	 */
	public List<ProcessInstance> getProcessInstanceList(){
		return executionService.createProcessInstanceQuery().list();
	}
	
	/**�鿴����ʵ��
	 * @param processInstanceId
	 * @return
	 */
	public ProcessInstance viewProcessInstance(String processInstanceId) {
		return this.executionService.findProcessInstanceById(processInstanceId);
	}
	/**ȡ��ĳ�˵Ĵ��������б�
	 * @param username
	 * @return
	 */
	public List<Task> findTaskListByUser(String username) {
		return this.taskService.findPersonalTasks(username);
	}
	/**ɾ�����̶���
	 * @param processDefinitionId
	 */
	public void deleteProcessDeployment(String deployId) {
		this.repositoryService.deleteDeploymentCascade(deployId);
	}
	/**�ύ����
	 * @param taskId
	 * @param map
	 */
	public void completeTask(String taskId, Map map) {
		this.taskService.completeTask(taskId, map);
	}
	
	/**����taskID��map��key��ȡvalue
	 * @param taskId
	 * @param key
	 * @return
	 */
	public String getMapById(String taskId, String key) {
		return (String) taskService.getVariable(taskId, key);
	}
	
	
	//get set
	public ProcessEngine getProcessEngine() {
		return processEngine;
	}
	public void setProcessEngine(ProcessEngine processEngine) {
		this.processEngine = processEngine;
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
