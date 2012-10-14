package com.luo.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.luo.db.SaveModel;
import com.luo.model.User;

public class ReflectTool {

	public static SaveModel convertObjToModel(Object obj){
		SaveModel model = new SaveModel();
		Field[] fileds = obj.getClass().getDeclaredFields();
		Object[] args = new Object[fileds.length];
		List<String> filedList = new ArrayList<String>();
		for (int i = 0; i < args.length; i++) {
			String filedName = fileds[i].getName();
			String getter = "get"+filedName.substring(0, 1).toUpperCase()+filedName.substring(1);
			filedList.add(filedName);
			try {
				args[i] = obj.getClass().getDeclaredMethod(getter, new Class[]{}).invoke(obj, new Object[]{});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		model.setFiledList(filedList);
		model.setArgs(args);
		return model;
	}
	
	public static void main(String[] args) {
		User user = new User();
		user.setUsername("tom");
		user.setPassword("123");
		
		SaveModel model = ReflectTool.convertObjToModel(user);
		List<String> l = model.getFiledList();
		Object[] ss = model.getArgs();
		for (int i = 0; i < ss.length; i++) {
			System.out.println(l.get(i)+":"+ss[i]);
		}
		
	}

}
