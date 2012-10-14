package com.luo.util;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XMLTool {

	public static Document createDocument(File f) {
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			 doc = reader.read(f);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return doc;
	}

	public static void main(String[] args) throws Exception {
		String path = "D:\\ProgramFiles\\apache-tomcat-5\\webapps\\plat_luo\\WEB-INF\\classes\\action";
		File file = new File(path);
		File[] files = file.listFiles();
		for (File f : files) {
			if(f.getName().endsWith("xml")){
				SAXReader reader = new SAXReader();
				Document doc = reader.read(f);
				List<Element> list = doc.selectNodes("/config/class/action");
				for(Element e:list){
					
					System.out.println(e.attributeValue("name"));
					System.out.println(e.attributeValue("method"));
					System.out.println(e.getParent().attributeValue("name"));
					System.out.println(e.element("forward").attributeValue("name"));
					System.out.println(e.element("forward").attributeValue("path"));

				}
			}
		}
	}
	
}
