package com.luo.action;

import org.springframework.stereotype.Controller;

@Controller
public class SaAction extends BaseAction{

	public String saLogin(){
		System.out.println("saAction执行了"+request.getParameter("name"));
		return "index";
	}
	public String saLogin2(){
		System.out.println("saAction2执行了");
		return "index2";
	}
}
