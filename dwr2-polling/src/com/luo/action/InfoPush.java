package com.luo.action;

import java.util.Collection;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

public class InfoPush {

	private boolean closeMarket = false;
	public void beginShow(){
		closeMarket = false;
	}
	public void endShow(){
		closeMarket = true;
	}
	public void sendInfo(){
		WebContext context = WebContextFactory.get();//获取web上下文
		String curPage = context.getCurrentPage();//从上下文获取当前页
		Collection scriptSessions = context.getScriptSessionsByPage(curPage);//根据当前页获取页面上所有的session
		Util utilAll = new Util(scriptSessions);//util是服务端模拟客户端
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(closeMarket){
				break;
			}
			utilAll.setValue("timezone", System.currentTimeMillis());
			System.out.println("输出了时间："+System.currentTimeMillis());
		}
	}
}
