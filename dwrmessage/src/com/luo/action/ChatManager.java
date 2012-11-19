package com.luo.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;
import com.luo.model.User;

public class ChatManager {

public static List<User> list = new ArrayList<User>();
private String curpage = ""; 

public String updateUsersList(String username, boolean flag, HttpServletRequest request) {
	User user = null;
	if (flag) {	
		// 这里取会话(HttpSession)的id为用户id 
		user = new User(request.getSession().getId(), username);
		//保存用户到列表
		list.add(user);	
		//将用户id和页面脚本session绑定
		this.setScriptSessionFlag(user.getUserId());
	}
	//获得DWR上下文
	//ServletContext sc = request.getSession().getServletContext();
	//ServerContext sctx = ServerContextFactory.get(sc);
	//获得当前浏览 index.jsp 页面的所有脚本session
	
	
	
	WebContext context=WebContextFactory.get();
	curpage = context.getCurrentPage();
	Collection<ScriptSession> sessions = context.getScriptSessionsByPage(curpage);
	System.out.println(sessions.size());
	Util util = new Util(sessions);
	//处理这些页面中的一些元素
	util.removeAllOptions("users");
	util.addOptions("users", list, "username");
	util.removeAllOptions("receiver");
	util.addOptions("receiver", list,"userId","username");
	if(!flag){
		return null;
	}
	return user.getUserId();
}


public void send(String sender,String receiverid,String message,HttpServletRequest request){
	ScriptSession scriptSession = this.getScriptSession(receiverid,request);
	Util util = new Util(scriptSession);
	util.setStyle("showMessage", "display", "");
	util.setValue("sender", sender);
	util.setValue("msg", message);
}


/**
 * 将用户id和页面脚本session绑定
 * @param userid
 */
public void setScriptSessionFlag(String userId) {
	WebContextFactory.get().getScriptSession().setAttribute("userId", userId);
}

private ScriptSession getScriptSession(String receiverid,HttpServletRequest request) {
	ScriptSession scriptSession = null;
	WebContext context=WebContextFactory.get();
	Collection<ScriptSession> sessions = ServerContextFactory.get(request.getSession().getServletContext()).getScriptSessionsByPage(context.getCurrentPage());
	for (ScriptSession ss : sessions) {
		String id = (String) ss.getAttribute("userId");
		if(receiverid.equals(id)){
			scriptSession = ss;
		}
	}
	return scriptSession;
}


}
