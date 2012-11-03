package com.luo.core;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * @作者 LuoHui
 * @创建日期 Nov 2, 2012
 * @版本 V 1.0
 */
public class SpringTool {

	public static ServletContext servletContext;//在系统启动的ActionFilter中赋值
	
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
