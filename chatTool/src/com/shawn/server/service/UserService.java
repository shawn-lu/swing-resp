package com.shawn.server.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.shawn.server.bean.User;


public class UserService {
	public boolean save(User u){
		Document document = DocumentHelper.createDocument();
		
		return true;
	}
	
	public User getUserByName(String name){
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(new File(System.getProperty("User.dir"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File dbxml = new File(p.getProperty("db_path"));
		SAXReader sr = new SAXReader();
		try {
			Document doc = sr.read(dbxml);
			List<Element> users = doc.getRootElement().elements();
			for(Iterator<Element> it = users.iterator();it.hasNext();){
				Element e = it.next();
				if(null!=e.element("name")
						&& e.element("name").equals(name)){
					User u = new User();
					u.setId(Integer.valueOf(e.element("id").getText()));
					u.setName(e.element("name").getText());
					u.setPassword(e.element("password").getText());
					return u;
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return null;
		}
	}
}
