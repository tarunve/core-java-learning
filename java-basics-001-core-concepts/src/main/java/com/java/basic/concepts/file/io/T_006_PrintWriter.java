package com.java.basic.concepts.file.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 	->	It is the most enhanced Writer to write char data to the file.
 * 	->	Main advantage of PrintWriter over FileWriter & BufferedWriter is, we can write any type
 * 		of primitive data directly to the file.
 *
 * 	Constructors:
 * 	------------
 * 	1.	PrintWriter fw = new PrintWriter(String fileName)
 * 	2.	PrintWriter fw = new PrintWriter(File f)
 * 	3.	PrintWriter fw = new PrintWriter(Writer w)
 *
 * 	->	PrintWriter can communicate directly with file and via some Writer object as well.
 *
 * 	Methods:
 * 	-------
 * 	1.	public void write(int c) throws IOException
 * 	2.	public void write(char cbuf[]) throws IOException
 * 	3.	public void write(String str) throws IOException
 * 	4.	public void flush() throws IOException
 * 		->	Total data including last character will be written to the file.
 * 	5.	public void close() throws IOException
 * 	6.	public void print(int c) throws IOException
 * 	7.	public void print(char ch) throws IOException
 * 	8.	public void print(String str) throws IOException
 * 	9.	public void print(double d) throws IOException
 * 	10.	public void print(boolean b) throws IOException
 * 	11.	public void println(int c) throws IOException
 * 	12.	public void println(char ch) throws IOException
 * 	13.	public void println(String str) throws IOException
 * 	14.	public void println(double d) throws IOException
 * 	15.	public void println(boolean b) throws IOException
 */
public class T_006_PrintWriter {
	
	public static class PrintWriterClass1 {
		/*
		 * Difference between write(100) , print(100)
		 * 	write(100) -> d
		 * 	print(100) -> 100
		 */

		public static void main(String[] args) throws IOException {
			FileWriter fw = new FileWriter("file1.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.write(100);
			pw.println(100);
			pw.println(true);
			pw.println('c');
			pw.println("durga");
			pw.flush();
			pw.close();
		}
	}
	
	/*
	 * Write a program to merge from 2 files into 3rd file.
	 */
	public static class PrintWriterClass2 {

		public static void main(String[] args) throws IOException {
			PrintWriter pw = new PrintWriter("file3.txt");
			BufferedReader br = new BufferedReader(new FileReader("file1.txt"));
			String line = br.readLine();
			while (line != null) {
				pw.println(line);
				line = br.readLine();
			}
			br.close();
			br = new BufferedReader(new FileReader("file2.txt"));
			String line1 = br.readLine();
			while (line1 != null) {
				pw.println(line1);
				line1 = br.readLine();
			}
			pw.flush();
			br.close();
			pw.close();
		}
	}

	/*
	 * Write a program to merge from 2 files into 3rd file where merging should be done alteratively.
	 */
	public static class PrintWriterClass3 {

		public static void main(String[] args) throws IOException {
			PrintWriter pw = new PrintWriter("file3.txt");
			BufferedReader br1 = new BufferedReader(new FileReader("file1.txt"));
			BufferedReader br2 = new BufferedReader(new FileReader("file2.txt"));
			String line1 = br1.readLine();
			String line2 = br2.readLine();
			while (line1 != null || line2 != null) {
				if (line1 != null) {
					pw.println(line1);
					line1 = br1.readLine();
				}
				if (line2 != null) {
					pw.println(line2);
					line2 = br2.readLine();
				}
			}
			pw.flush();
			br1.close();
			br2.close();
			pw.close();
			BufferedReader br3 = new BufferedReader(new FileReader("file3.txt"));
			String line3 = br3.readLine();
			while (line3 != null) {
				System.out.println(line3);
				line3 = br3.readLine();
			}
			br3.close();
		}
	}

	/*
	 * Write a program to perform file extraction operation.
	 */
	public static class PrintWriterClass4 {

		public static void main(String[] args) throws IOException {
			PrintWriter pw = new PrintWriter("file3.txt");
			BufferedReader br1 = new BufferedReader(new FileReader("file1.txt"));
			String line1 = br1.readLine();
			BufferedReader br2 = null;
			while (line1 != null) {
				boolean available = false;
				br2 = new BufferedReader(new FileReader("file2.txt"));
				String line2 = br2.readLine();
				while (line2 != null) {
					if (line1.equals(line2)) {
						available = true;
						break;
					}
					line2 = br2.readLine();
				}
				if (!available) {
					pw.println(line1);
				}
				line1 = br1.readLine();
			}
			pw.flush();
			br1.close();
			br2.close();
			pw.close();
			BufferedReader br3 = new BufferedReader(new FileReader("file3.txt"));
			String line3 = br3.readLine();
			while (line3 != null) {
				System.out.println(line3);
				line3 = br3.readLine();
			}
			br3.close();
		}
	}

	/*
	 * Write a program to remove duplicates from a file.
	 */
	public static class PrintWriterClass5 {

		public static void main(String[] args) throws IOException {
			PrintWriter pw = new PrintWriter("file3.txt");
			BufferedReader br1 = new BufferedReader(new FileReader("file1.txt"));
			String line1 = br1.readLine();
			BufferedReader br2 = null;
			while (line1 != null) {
				boolean available = false;
				br2 = new BufferedReader(new FileReader("file3.txt"));
				String line2 = br2.readLine();
				while (line2 != null) {
					if (line1.equals(line2)) {
						available = true;
						break;
					}
					line2 = br2.readLine();
				}
				if (!available) {
					pw.println(line1);
					pw.flush();
				}
				line1 = br1.readLine();
			}
			pw.flush();
			br1.close();
			br2.close();
			pw.close();
			BufferedReader br3 = new BufferedReader(new FileReader("file3.txt"));
			String line3 = br3.readLine();
			while (line3 != null) {
				System.out.println(line3);
				line3 = br3.readLine();
			}
			br3.close();
		}
	}
}
