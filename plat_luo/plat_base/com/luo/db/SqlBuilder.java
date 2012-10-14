package com.luo.db;

import com.luo.util.ReflectTool;


public class SqlBuilder {

	public static SaveModel buildSaveSQL(Object obj,String tableName){
		SaveModel model = ReflectTool.convertObjToModel(obj);
		int size = model.getFiledList().size();
		StringBuffer sb = new StringBuffer();
		sb.append("insert into ");
		sb.append(tableName);
		sb.append("(");
		for (int i = 0; i < size; i++) {
			sb.append(model.getFiledList().get(i)+",");
		}
		
		StringBuffer s = new StringBuffer();
		s.append(sb.toString().substring(0, sb.toString().lastIndexOf(",")));
		s.append(")values(");
		for (int i = 0; i < size; i++) {
			s.append("?,");
		}
		model.setSql(s.toString().substring(0, s.toString().lastIndexOf(","))+")");
		return model;
	}
	
}
