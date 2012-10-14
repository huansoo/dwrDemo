package com.luo.action.dispatcher;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
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

public class FilterDispatcher implements Filter{

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
		String requestPath = request.getRequestURI();// 			/plat_luo/saveUser.do
		String contextPath = request.getContextPath();// 			/plat_luo
		String str = requestPath.replace(contextPath+"/", "");//	saveUser.do
		if(!str.equals("")){
			String actionName = str.substring(0,str.lastIndexOf("."));
			if(requestPath.endsWith("do") || requestPath.endsWith("action")){
				if(ActionConfig.getActionMap().get(actionName) != null){
					String forward = this.executeSpringBean(request,response,actionName);
					response.sendRedirect(request.getContextPath()+forward);
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
	private String executeSpringBean(HttpServletRequest request,HttpServletResponse response, String actionName){
		
		String resultPath = null;
		ActionModel actionModel = ActionConfig.getActionMap().get(actionName);
		String clazz= actionModel.getActionClass();
		String method = actionModel.getActionMethod();
		try {
			String classPath = request.getRealPath("/WEB-INF/classes/com/luo/action/");
			String className = FileTool.getClassNameByClazz(classPath,clazz);
			Class<?> actionClass = Class.forName(className).newInstance().getClass();
			Method m = actionClass.getMethod(method);
			String returnStr = (String) m.invoke(actionClass.newInstance());
			if(returnStr != null){
				List list = actionModel.getMapList();
				for(int i=0;i<list.size();i++){
					Map<String,String> map = (Map<String,String>)list.get(i);
					if(map.containsKey(returnStr)){
						resultPath = map.get(returnStr);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultPath;
	}
	
	/** 
	 * 把所有xml中的所有action装配到一个map中
	 */
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
						map.put(ee.attributeValue("name"), ee.attributeValue("path"));
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
