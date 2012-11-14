package com.luo.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/jbpm/*")
public class JbpmController {

	@RequestMapping(value="/sendLeave.do",method=RequestMethod.GET)
	public String sendLeave(){
		return "sendLeave";
	}
}
