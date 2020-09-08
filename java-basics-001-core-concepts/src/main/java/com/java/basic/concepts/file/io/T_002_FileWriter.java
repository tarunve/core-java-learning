package com.java.basic.concepts.file.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 	->	We can use FileWriter to write character data in file.
 *
 * 	Constructors:
 * 	------------
 * 	1.	FileWriter fw = new FileWriter(String fileName)
 * 	2.	FileWriter fw = new FileWriter(File f)
 * 		-> These 2 meant for overriding
 * 	3.	FileWriter fw = new FileWriter(String fileName, boolean append)
 * 	4.	FileWriter fw = new FileWriter(File f, boolean append)
 * 		->	These 2 are meant for append.
 *
 * 	->	If the specified file is not already present , then all the above constructors will create file.
 *
 * 	Methods:
 * 	-------
 * 	1.	public void write(int c) throws IOException
 * 	2.	public void write(char cbuf[]) throws IOException
 * 	3.	public void write(String str) throws IOException
 * 	4.	public void flush() throws IOException
 * 		->	Total data including last character will be written to the file.
 * 	5.	public void close() throws IOException
 *
 * 	Limitation:
 * 	----------
 * 	1.	While writing data using FileWriter, we have to insert line separator manually(\n) which
 * 		is varied from system to system.
 */
public class T_002_FileWriter {
	
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("file1.txt");
		fw.write(100);
		fw.write("urga\nSoftware Solutions");
		fw.write("\n");
		char[] ch = { 'a', 'b', 'c' };
		fw.write(ch);
		fw.flush();
		fw.close();
	}
}
