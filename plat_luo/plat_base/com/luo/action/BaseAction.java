package com.luo.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**ÿ��action�̳���baseAction�󣬾ͻ��ڷ������ܻ�ȡ��setRequest��setResponse��method
 * @author Administrator
 *
 */
public class BaseAction{

	public static final String SUCCESS="success";
	public HttpServletRequest request;
	public HttpServletResponse response;
	public HttpSession session;
	public ServletContext application;//����ԭ����һ����˼
	
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
		this.application = request.getSession().getServletContext();
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
}
