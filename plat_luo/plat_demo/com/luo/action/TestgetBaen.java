package com.luo.action;

import org.junit.Test;

import com.luo.core.SpringTool;

/**
 * @���� LuoHui
 * @�������� Nov 2, 2012
 * @�汾 V 1.0
 */
public class TestgetBaen {

	public static void main(String[] args) {
		DemoAction demoAction = SpringTool.getSpringBean("demoAction");
		System.out.println(demoAction.getName());
	}
}
