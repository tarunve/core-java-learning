package com.java.basic.concepts.collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ->	Child class of Hashtable.
 * ->	In our program , if anything changed frequently (like user,password etc) are not recommended to
 * 		hard code. We can store in a property file and read from there.
 * ->	Keys and Value should be String Object.
 * ->	Introduced in 1.0 version.
 *
 * 	Constructor:
 * 	===========
 * 	1.	Properties p = new Properties();
 *
 *	Methods:
 *	=======
 *	1.	String getProperty(String propertyName)
 *	2.	String setProperty(String propName, String Value)
 *	3.	Enumeration propertyNames()
 *	4.	load(InputStream is)
 *	5.	store(OuputStream os, String comment)
 *
 * 	Advantage:
 * 	=========
 * 	We just need the re-deployment to reflect the change.
 */
public class T_025_Map_Properties {
	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("C:\\eclipse_workspace\\Phase3\\CRM\\TestPrograms\\src\\test.properties");
		properties.load(fis);
		System.out.println(properties);
		
		String user = properties.getProperty("user");
		System.out.println(user);
		properties.setProperty("email", "tarun.verma@amdocs.com");
		
		FileOutputStream fos = new FileOutputStream("C:\\eclipse_workspace\\Phase3\\CRM\\TestPrograms\\src\\test.properties");
		properties.store(fos, "updated by Traun");

		System.out.println(properties);
	}
}
