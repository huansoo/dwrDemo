package com.luo.jbpm.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jbpm.api.ProcessDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/jbpm")
public class DeploymentController extends BaseController{

	
	@RequestMapping(value="/startDeployment.do",method=RequestMethod.GET)
	public String startDeployment(){
		deploymentService.startDeployment("leave.jpdl.xml");
		return "redirect:/jbpm/definitionList.do";
	}

	@RequestMapping("/definitionList.do")
	public String deploymentList(HttpServletRequest request){
		List<ProcessDefinition> list = deploymentService.processDefinitionList();
		request.setAttribute("definitionList", list);
		return "definitionList";
	}

}
