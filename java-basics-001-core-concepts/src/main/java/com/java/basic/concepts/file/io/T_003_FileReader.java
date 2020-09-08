package com.java.basic.concepts.file.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 	->	We can use FileReader to read character data in file.
 *
 * 	Constructors:
 * 	------------
 * 	1.	FileReader fw = new FileReader(String fileName)
 * 	2.	FileReader fw = new FileReader(File f)
 *
 * 	Methods:
 * 	-------
 * 	1.	public int read() throws IOException
 * 		->	It attempts to read next character from file and returns its unicode value.
 * 		->	If next character is not available, then this methods returns -1.
 * 		->	As this method returns unicode value(int), at the time of printing, we have to
 * 			perform type casting.
 * 	2.	public void read(char cbuf[]) throws IOException
 * 		->	It attempts to read enough characters from the file into char array and returns
 * 			number of characters copied.
 * 	3.	public void close() throws IOException
 *
 * 	Limitation:
 * 	----------
 * 	1.	By using FileReader, we can read data char by char, which is not convenient to programmer.
 */
public class T_003_FileReader {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("file1.txt");
		int i = fr.read();
		while (i != -1) {
			System.out.print((char) i);
			i = fr.read();
		}
		fr.close();
		System.out.println();;
		System.out.println("===========================");
		File f = new File("file1.txt");
		char[] ch = new char[(int) f.length()];
		FileReader fr1 = new FileReader(f);
		fr1.read(ch);
		for (char c : ch) {
			System.out.print(c);
		}
		fr1.close();
	}

}
