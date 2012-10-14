package com.luo.model;

import java.util.Map;

public class ActionConfig {

	public static Map<String,ActionModel> actionMap;

	public static Map<String, ActionModel> getActionMap() {
		return actionMap;
	}

	public static void setActionMap(Map<String, ActionModel> actionMap) {
		ActionConfig.actionMap = actionMap;
	}

	
}
