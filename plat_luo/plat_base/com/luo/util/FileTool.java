package com.luo.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTool {

	public static List<File> getFileListByPath(String xmlPath) {
		File xmlDirectry = new File(xmlPath);
		File[] files = xmlDirectry.listFiles();
		List<File> fileList = new ArrayList<File>();
		for (File file : files) {
			fileList.add(file);
		}
		return fileList;
	}

	public static String getClassNameByClazz(String classPath, String clazz) {
		List<File> files = FileTool.getFileListByPath(classPath);
		String className = null;
		for (File f : files) {
			if(f.getName().endsWith("class")){
				if((clazz+".class").equalsIgnoreCase(f.getName())){
					className = f.getPath().substring(f.getPath().indexOf("classes")+8,f.getPath().lastIndexOf(".")).replaceAll("\\\\", ".");
					break;
				}
			}
		}
		
		return className;
	}

	public static void main(String[] args) {
		String s = "action/sa/saLogin.do";
		System.out.println(s.substring(s.indexOf('/')+1, s.lastIndexOf('/')));
		System.out.println(s.substring(s.lastIndexOf('/')+1,s.indexOf('.')));
	}
}
