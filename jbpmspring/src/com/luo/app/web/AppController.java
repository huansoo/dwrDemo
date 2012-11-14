package com.luo.app.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luo.jbpm.pojo.User;

@Controller
public class AppController {

	@RequestMapping(value="/index.do",method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/logout.do",method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "index";
	}
	
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(User user,HttpSession session){
		if(user.getUsername().equals(user.getPassword())){
			session.setAttribute("user", user);
			return "main";
		}else{
			return "index";
		}
	}
	
	@RequestMapping(value="/frame_{t}.do",method=RequestMethod.GET)
	public String frame(@PathVariable String t){
		return "frame_"+t;
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("username");
		return "index";
	}
}
