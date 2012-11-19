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
		WebContext context = WebContextFactory.get();//��ȡweb������
		String curPage = context.getCurrentPage();//�������Ļ�ȡ��ǰҳ
		Collection scriptSessions = context.getScriptSessionsByPage(curPage);//���ݵ�ǰҳ��ȡҳ�������е�session
		Util utilAll = new Util(scriptSessions);//util�Ƿ����ģ��ͻ���
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
			System.out.println("�����ʱ�䣺"+System.currentTimeMillis());
		}
	}
}
