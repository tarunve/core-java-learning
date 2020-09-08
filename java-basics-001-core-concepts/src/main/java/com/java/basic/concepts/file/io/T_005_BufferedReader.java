package com.java.basic.concepts.file.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 	->	We can use BufferedReader to read character data in file.
 *
 * 	Constructors:
 * 	------------
 * 	1.	BufferedReader fw = new BufferedReader(Reader r)
 * 	2.	BufferedReader fw = new BufferedReader(Reader r, int bufferSize)
 *
 *	->	BufferedReader can't communicate directly with file. It can communicate via some Reader object.
 * 	->	Whenever we are closing BufferedReader , automatically internal FileReader will be closed.
 *
 * 	Methods:
 * 	-------
 * 	1.	public void read(int c) throws IOException
 * 		->	It attempts to read next character from file and returns its unicode value.
 * 		->	If next character is not available, then this methods returns -1.
 * 		->	As this method returns unicode value(int), at the time of printing, we have to
 * 			perform type casting.
 * 	2.	public void read(char cbuf[]) throws IOException
 * 		->	It attempts to read enough characters from the file into char array and returns
 * 			number of characters copied.
 * 	3.	public void close() throws IOException
 * 	4.	public String readLine() throws IOException
 * 		-> 	->	It attempts to read next line from file and returns it. If not available, it returns null.
 */
public class T_005_BufferedReader {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("file1.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while (line != null) {
			System.out.println(line);
			line = br.readLine();
		}
		br.close();
	}
	
}
