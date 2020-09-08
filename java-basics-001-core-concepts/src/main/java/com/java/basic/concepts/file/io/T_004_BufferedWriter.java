package com.java.basic.concepts.file.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 	->	We can use BufferedWriter to write character data in file.
 *
 * 	Constructors:
 * 	------------
 * 	1.	BufferedWriter fw = new BufferedWriter(Writer w)
 * 	2.	BufferedWriter fw = new BufferedWriter(Writer w, int bufferSize)
 *
 * 	->	BufferedWriter can't communicate directly with file. It can communicate via some Writer object.
 * 	->	Whenever we are closing BufferedWriter , automatically internal FileWriter will be closed.
 *
 * 	Methods:
 * 	-------
 * 	1.	public void write(int c) throws IOException
 * 	2.	public void write(char cbuf[]) throws IOException
 * 	3.	public void write(String str) throws IOException
 * 	4.	public void flush() throws IOException
 * 		->	Total data including last character will be written to the file.
 * 	5.	public void close() throws IOException
 * 	6.	public void newLine() throws IOException
 * 		->	To insert a line separator.
 *
 */
public class T_004_BufferedWriter {
	
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("file1.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(100);
		bw.newLine();
		char[] ch = { 'a', 'b', 'c' };
		bw.write(ch);
		bw.newLine();
		bw.write("durga");
		bw.newLine();
		bw.flush();
		bw.close();
	}
}
