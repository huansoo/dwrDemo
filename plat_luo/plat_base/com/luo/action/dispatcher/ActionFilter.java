package com.luo.action.dispatcher;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;

import com.luo.model.ActionConfig;
import com.luo.model.ActionModel;
import com.luo.util.FileTool;
import com.luo.util.XMLTool;

public class ActionFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException{
		Map<String, ActionModel> map = ActionConfig.actionMap;
		for(Map.Entry<String, ActionModel> entry : map.entrySet()){
			System.out.println(entry.getKey() + "----" + entry.getValue()); 
		}
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String requestPath = request.getRequestURI();// 			/plat_luo/action/sa/saLogin.do
		String contextPath = request.getContextPath();// 			/plat_luo
		String actionName = requestPath.replace(contextPath+"/", "");
		
		if(!actionName.equals("")){
			if(actionName.endsWith("do") || actionName.endsWith("action")){
				ActionModel model = ActionConfig.getActionMap().get(actionName);
				if(model != null){
					Map<String,String> returnMap = this.executeSpringBean(request,response,actionName);
					String forward = returnMap.get("path");
					Boolean b = "true".equals(returnMap.get("redirect"))?true:false;
					if(b){
						String param = "";
						/*StringBuffer sb = new StringBuffer();
						sb.append("?");
						Enumeration  e = request.getParameterNames();
						while(e.hasMoreElements()){
							sb.append(e.nextElement()+"="+request.getParameter(e.nextElement().toString())+"&");
						}
						String param = sb.toString().substring(0, sb.lastIndexOf("&"));*/
						if(forward.startsWith("/action")){
							response.sendRedirect(request.getContextPath()+forward+param);//	1、如果重定向到一个action
						}else{
							response.sendRedirect(request.getContextPath()+forward+param);//	2、如果重定向到一个jsp
						};
					}else{
						if(forward.startsWith("/action")){
							request.getRequestDispatcher(forward).forward(request, response);//	3、如果请求转发到一个action
						}else{
							request.getRequestDispatcher(forward).forward(request, response);//	4、如果请求转发到一个jsp
						}
					}
				}
			}else{
				chain.doFilter(req, res);
			}
		}
	}

	/**根据反射，执行action对应的method
	 * @param request 
	 * @param actionName
	 */
	private Map<String,String> executeSpringBean(HttpServletRequest request,HttpServletResponse response, String actionName){
		Map<String,String> returnMap = new HashMap<String,String>();
		ActionModel actionModel = ActionConfig.getActionMap().get(actionName);
		String clazz= actionModel.getActionClass();
		String method = actionModel.getActionMethod();
		try {
			String classPath = request.getRealPath("/WEB-INF/classes/com/luo/action/");
			String className = FileTool.getClassNameByClazz(classPath,clazz);
			Object obj = Class.forName(className).newInstance();
			Class<?> actionClass = obj.getClass();
			Method m = actionClass.getMethod(method, new Class[] {});
			Method setRequest = actionClass.getMethod("setRequest",new Class[] { HttpServletRequest.class });
			Method setResponse = actionClass.getMethod("setResponse",new Class[] { HttpServletResponse.class });
			setRequest.invoke(obj, new Object[]{request});
			setResponse.invoke(obj, new Object[]{response});//把request、response等传递给每个Action
			String returnStr = (String) m.invoke(obj, new Object[] {});
			if(returnStr != null){
				List list = actionModel.getMapList();
				for(int i=0;i<list.size();i++){
					Map<String,String> map = (Map<String,String>)list.get(i);
					if(map.get("name").equals(returnStr)){
						returnMap.put("path", map.get("path"));
						returnMap.put("redirect", map.get("redirect"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnMap;
	}
	
	/** 
	 * 把所有xml中的所有action装配到一个map中
	 */
	@SuppressWarnings("unchecked")
	public void init(FilterConfig filterConfig) throws ServletException {
		String xmlPath = filterConfig.getServletContext().getRealPath("/WEB-INF/classes/action/");
		List<File> files = FileTool.getFileListByPath(xmlPath);
		
		for (File f : files) {
			if(f.getName().endsWith("xml")){
				Document doc = XMLTool.createDocument(f);
				List<Element> list = doc.selectNodes("/config/class/action");
				Map<String,ActionModel> actionMap = new HashMap<String, ActionModel>();
				for(Element e:list){
					ActionModel actionModel = new ActionModel();
					actionModel.setActionName(e.attributeValue("name"));
					actionModel.setActionMethod(e.attributeValue("method"));
					actionModel.setActionClass(e.getParent().attributeValue("name"));
					List<Map<String,String>> mapList = new ArrayList<Map<String,String>>();
					List l = e.elements("forward");
					for (Object o : l) {
						Element ee = (Element) o;
						Map<String,String> map = new HashMap<String, String>();
						map.put("name",ee.attributeValue("name"));
						map.put("path",ee.attributeValue("path"));
						map.put("redirect",ee.attributeValue("redirect"));
						mapList.add(map);
					}
					actionModel.setMapList(mapList);
					actionMap.put(e.attributeValue("name"), actionModel);
				}
				ActionConfig.actionMap = actionMap;
			}
		}
	}

}
