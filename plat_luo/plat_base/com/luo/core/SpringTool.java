package com.luo.core;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * @���� LuoHui
 * @�������� Nov 2, 2012
 * @�汾 V 1.0
 */
public class SpringTool {

	public static ServletContext servletContext;//��ϵͳ������ActionFilter�и�ֵ
	
	@SuppressWarnings("unchecked")
	public static <T> T getSpringBean(String beanName){
		if(servletContext==null){
			System.out.println("-----------");
		}
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		T bean = (T)context.getBean(beanName);
		return bean;
	}

	public static ServletContext getServletContext() {
		return servletContext;
	}

	public static void setServletContext(ServletContext servletContext) {
		SpringTool.servletContext = servletContext;
	}
	
	
	
}
