package com.luo.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.luo.db.SaveModel;
import com.luo.model.User;

public class ReflectTool {

	public static <T> T convertSQLMapToObject(Map<String,Object> map,Class<?> clazz){
		Class<?>[] autoTypes={String.class,Integer.class,int.class,Long.class,long.class,Float.class,float.class,Double.class,double.class,Date.class};
		Object obj = null;
		try {
			obj = clazz.newInstance();
		}catch (Exception e) {
			new Exception("sqlMap转换成对象时出错");
			e.printStackTrace();
		}
		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			String attName = f.getName();//获得其所以属性id,username,password，在此我先简单的约定属性名必须和字段名一样
			if(ReflectTool.isInArray(clazz,autoTypes)){
				ReflectTool.setAttribute(obj,attName,map.get(attName));
			}
		}
		return (T)obj;
	}
	
	private static boolean isInArray(Class<?> clazz, Class<?>[] autoTypes) {
		boolean flag = false;
		for (int i = 0; i < autoTypes.length; i++) {
			if(clazz.equals(autoTypes[i])){
				flag = true;
			}
		}
		return flag;
	}

	private static void setAttribute(Object obj, String attName, Object object) {
		//Field field = obj.getClass().getDeclaredField(attName);
	}

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
