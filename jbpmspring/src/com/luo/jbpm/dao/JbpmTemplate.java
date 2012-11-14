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
	
	/**部署流程到数据库
	 * @param map 
	 * @return
	 */
	public String startDeployment(String jpdlName){
		String deploymentId = repositoryService.createDeployment().addResourceFromClasspath(jpdlName).deploy();
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deploymentId).uniqueResult();
		String processDefinitionId = processDefinition.getId();
		System.out.println("部署ID："+deploymentId);
		System.out.println("部署了一个ID："+processDefinitionId+",Name:"+processDefinition.getName()+",key:"+processDefinition.getKey()+"的流程定义");
		return processDefinitionId;
	}
	
	/**查看所有流程定义列表
	 * @return
	 */
	public List<ProcessDefinition> processDefinitionList(){
		return repositoryService.createProcessDefinitionQuery().list();
	}
	/**删除一个流程部署
	 * @param deploymentId
	 */
	public void deleteDeployment(String deploymentId){
		repositoryService.deleteDeploymentCascade(deploymentId);
	}
	
	/**发起一个新的流程实例
	 * @param key
	 * @return
	 */
	public String startProcessInstanceById(String processdefinitionId,Map map){
		ProcessInstance processInstance = executionService.startProcessInstanceById(processdefinitionId,map);
		System.out.println("发起了一个ID："+processInstance+"Name:"+processInstance.getName()+"key:"+processInstance.getKey()+"的流程实例");
		return processInstance.getId();
	}
	
	/**查找所有的流程实例
	 * @return
	 */
	public List<ProcessInstance> getProcessInstanceList(){
		return executionService.createProcessInstanceQuery().list();
	}
	
	/**查看流程实例
	 * @param processInstanceId
	 * @return
	 */
	public ProcessInstance viewProcessInstance(String processInstanceId) {
		return this.executionService.findProcessInstanceById(processInstanceId);
	}
	/**取得某人的代办任务列表
	 * @param username
	 * @return
	 */
	public List<Task> findTaskListByUser(String username) {
		return this.taskService.findPersonalTasks(username);
	}
	/**删除流程定义
	 * @param processDefinitionId
	 */
	public void deleteProcessDeployment(String deployId) {
		this.repositoryService.deleteDeploymentCascade(deployId);
	}
	/**提交任务
	 * @param taskId
	 * @param map
	 */
	public void completeTask(String taskId, Map map) {
		this.taskService.completeTask(taskId, map);
	}
	
	/**根据taskID和map的key获取value
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
