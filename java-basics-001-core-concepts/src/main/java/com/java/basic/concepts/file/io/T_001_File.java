package com.java.basic.concepts.file.io;

import java.io.File;
import java.io.IOException;

/**
 * 			File f = new File("abc.txt");
 * 	->	The above line won't create any physical file. First, it will check, if there is any file with name
 * 		"abc.txt" is available or not. If available , then refers that file. If not available, then we are
 * 		just creating java file object to represent name "abc.txt".
 * 	->	We can use java file object to represent directory also.
 * 	->	In Unix, everything is considered as file. Java file I/O concept is based on unix OS.
 *
 * 	Constructors:
 * 	------------
 * 	1.	File f = new File(String filename)
 * 	2.	File f = new File(String subDirectoryName, String filename)
 * 	3.	File f = new File(File subDirectory, String filename)
 *
 * 	Methods:
 * 	-------
 * 	1.	boolean exists()
 * 		->	return TRUE if the file or directory is already present.
 * 	2.	boolean createNewFile() throws IOException
 * 		->	If already present, it returns FALSE without creating any physical file. If file is not available,
 * 			then this method will create a new file and returns TRUE.
 * 	3.	boolean mkdir() throws IOException
 * 	4.	boolean isFile()
 * 	5.	boolean isDirectory()
 * 	6.	String[] list()
 * 	7.	long length()
 * 		-> returns number of characters in file.
 * 	8.	boolean delete()
 */
public class T_001_File {
	
	public static void main(String[] args) throws IOException {
		File f1 = new File("file1.txt");
		System.out.println("Is File present :: " + f1.exists());
		f1.createNewFile();
		System.out.println("f1 is file :: " + f1.isFile());
		System.out.println("f1 is Directory :: " + f1.isDirectory());
		File f2 = new File(".");
		String[] files = f2.list();
		for (String file : files) {
			System.out.println("\t" + file);
		}
		System.out.println(f1.length());
		System.out.println(f1.delete());
		System.out.println(f2.length());
	}
}
