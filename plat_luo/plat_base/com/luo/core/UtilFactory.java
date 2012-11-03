package com.luo.core;

import com.luo.db.DaoTemplate;

/**
 * @���� LuoHui
 * @�������� Nov 2, 2012
 * @�汾 V 1.0
 */
public class UtilFactory {

	public static DaoTemplate getDaoTemplate(){
		DaoTemplate daoTemplate = SpringTool.getSpringBean("daoTemplate");
		return daoTemplate;
	}
}
