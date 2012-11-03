package com.luo.model;

import java.util.List;
import java.util.Map;

public class ActionModel {

	private String actionName;			//action/user/saLogin.do
	private String actionClass;			//userAction这个类约定必须在action/user这个包下
	private String actionMethod;		//saLogin
	private List<Map<String,String>> mapList;
	
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getActionClass() {
		return actionClass;
	}
	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}
	public String getActionMethod() {
		return actionMethod;
	}
	public void setActionMethod(String actionMethod) {
		this.actionMethod = actionMethod;
	}
	public List<Map<String, String>> getMapList() {
		return mapList;
	}
	public void setMapList(List<Map<String, String>> mapList) {
		this.mapList = mapList;
	}
}
