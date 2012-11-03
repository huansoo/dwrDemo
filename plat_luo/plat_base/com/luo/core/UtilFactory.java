package com.luo.core;

import com.luo.db.DaoTemplate;

/**
 * @作者 LuoHui
 * @创建日期 Nov 2, 2012
 * @版本 V 1.0
 */
public class UtilFactory {

	public static DaoTemplate getDaoTemplate(){
		DaoTemplate daoTemplate = SpringTool.getSpringBean("daoTemplate");
		return daoTemplate;
	}
}
