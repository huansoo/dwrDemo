package com.luo.jbpm.web;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/jbpm")
public class ProcessInstanceController extends BaseController{

	@RequestMapping(value="/startProcessInstance.do",method=RequestMethod.GET)
	public String startProcessInstance(HttpServletRequest request){
		String processdefinitionId = request.getParameter("pd");
		Map map = new HashMap();
		map.put("owner", request.getSession().getAttribute("username"));
		String processInstanceId = processInstanceService.startProcessInstanceById(processdefinitionId,map);
		return "redirect:/jbpm/processInstanceList.do";
	}
	
	@RequestMapping(value="/processInstanceList.do",method=RequestMethod.GET)
	public String processInstanceList(HttpServletRequest request){
		List<ProcessInstance>  list = processInstanceService.processInstanceList();
		request.setAttribute("instanceList", list);
		return "processInstanceList";
	}
	@RequestMapping(value="/viewProcessInstance.do",method=RequestMethod.GET)
	public String viewProcessInstance(HttpServletRequest request){
		ProcessInstance processInstance = processInstanceService.viewProcessInstance(request.getParameter("pi"));
		request.setAttribute("processInstance", processInstance);
		return "processInstance";
	}
	@RequestMapping(value="/taskList.do",method=RequestMethod.GET)
	public String taskList(HttpServletRequest request){
		List<Task> taskList = processInstanceService.findTaskListByUser(request.getSession().getAttribute("username").toString());
		request.setAttribute("taskList", taskList);
		return "taskList";
	}
	@RequestMapping(value="/postRequestWorker.do",method=RequestMethod.GET)
	public String postRequestWorker(HttpServletRequest request){
		return "requestWorker";
	}
	@RequestMapping(value="/postRequestManager.do",method=RequestMethod.GET)
	public String postRequestManager(HttpServletRequest request) throws UnsupportedEncodingException{
		String taskId = request.getParameter("id");
		String owner = processInstanceService.getMapById(taskId,"owner");
		String day = processInstanceService.getMapById(taskId,"day");
		String reason = processInstanceService.getMapById(taskId,"reason");
		//reason = new String(reason.getBytes("iso8859-1"),"utf-8");
		request.setAttribute("owner", owner);
		request.setAttribute("day", day);
		request.setAttribute("reason", reason);
		request.setAttribute("taskId", taskId);
		return "requestManager";
	}
	@RequestMapping(value="/postRequestBoss.do",method=RequestMethod.GET)
	public String postRequestBoss(HttpServletRequest request){
		return "requestBoss";
	}
	@RequestMapping(value="/submitRequest.do",method=RequestMethod.POST)
	public String submitRequest(HttpServletRequest request){
		String taskId = request.getParameter("taskId");
		String owner = request.getParameter("owner");
		String day = request.getParameter("day");
		String reason = request.getParameter("reason");
		
		Map map = new HashMap();
		map.put("day", day);
		map.put("reason", reason);
		processInstanceService.completeTask(taskId,map);
		return "redirect:/jbpm/taskList.do";
	}
}
