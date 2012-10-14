package com.luo.db;

import java.util.ArrayList;
import java.util.List;

public class SaveModel {

	private String sql;
	private Object[] args;
	private List<String> filedList = new ArrayList<String>();
	
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public Object[] getArgs() {
		return args;
	}
	public void setArgs(Object[] args) {
		this.args = args;
	}
	public List<String> getFiledList() {
		return filedList;
	}
	public void setFiledList(List<String> filedList) {
		this.filedList = filedList;
	}
}
