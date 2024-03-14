package com.java.basic.concepts.collection;

import java.io.*;
import java.util.Objects;
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
		BufferedReader br = new BufferedReader(new FileReader(getResourceFiles("prop.txt")));
		properties.load(br);
		System.out.println(properties);
		
		String user = properties.getProperty("user");
		System.out.println(user);
		properties.setProperty("email", "tarun@gmail.com");
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(getResourceFiles("prop.txt")));
		properties.store(bw, "updated by Tarun");

		br.close();
		bw.close();

		System.out.println(properties);
	}

	public static String getResourceFiles(String name){
		return Objects.requireNonNull(T_025_Map_Properties.class.getClassLoader().getResource(name)).getFile();
	}
}
