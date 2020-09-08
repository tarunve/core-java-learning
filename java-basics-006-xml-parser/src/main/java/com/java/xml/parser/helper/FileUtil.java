package com.java.xml.parser.helper;

public final class FileUtil {
	
	public static String getFilePath(String fileName){
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		String file = classLoader.getResource(fileName).getFile();
		return file;
	}
			
}
