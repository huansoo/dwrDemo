package com.luo.action;

import org.springframework.stereotype.Controller;

@Controller
public class SaAction extends BaseAction{

	public String saLogin(){
		System.out.println("saActionִ����"+request.getParameter("name"));
		return "index";
	}
	public String saLogin2(){
		System.out.println("saAction2ִ����");
		return "index2";
	}
}
