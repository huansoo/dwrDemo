package com.luo.jbpm.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jbpm.api.ProcessInstance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/jbpm")
public class ProcessInstanceController extends BaseController{

	@RequestMapping(value="/startProcessInstance.do",method=RequestMethod.GET)
	public String startProcessInstance(){
		String processInstanceId = processInstanceService.startProcessInstanceByKey(LEAVE);
		return "redirect:/jbpm/processInstanceList.do";
	}
	
	@RequestMapping(value="/processInstanceList.do",method=RequestMethod.GET)
	public String processInstanceList(HttpServletRequest request){
		List<ProcessInstance>  list = processInstanceService.processInstanceList();
		request.setAttribute("instanceList", list);
		return "processInstanceList";
	}
}
