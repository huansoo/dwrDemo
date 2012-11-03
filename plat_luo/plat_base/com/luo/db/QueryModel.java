package com.luo.db;

import java.util.HashMap;
import java.util.Map;

/**
 * @作者 LuoHui
 * @创建日期 Nov 3, 2012
 * @版本 V 1.0
 */
public class QueryModel {

	private String sql;
	private Class<?> targetClass;
	private String tableName;
	public static Map<String,Object> paramMap = new HashMap<String, Object>();
	
	
	
	public void putParamInMap(String key,Object value){
		QueryModel.paramMap.put(key, value);
	}
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Class<?> getTargetClass() {
		return targetClass;
	}

	public void setTargetClass(Class<?> targetClass) {
		this.targetClass = targetClass;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
