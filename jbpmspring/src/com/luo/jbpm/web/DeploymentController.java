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
		String jpdlPath = "com/luo/jbpm/jpdl/leave.jpdl.xml";
		deploymentService.startDeployment(jpdlPath);
		return "redirect:/jbpm/definitionList.do";
	}

	@RequestMapping("/definitionList.do")
	public String definitionList(HttpServletRequest request){
		List<ProcessDefinition> list = deploymentService.processDefinitionList();
		request.setAttribute("definitionList", list);
		return "definitionList";
	}
	@RequestMapping("/deleteProcessDeployment.do")
	public String deleteProcessDeployment(HttpServletRequest request){
		deploymentService.deleteProcessDeployment(request.getParameter("pd"));
		return "redirect:/jbpm/definitionList.do";
	}

}
