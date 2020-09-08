package com.java.enhancements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *	->	Java 7 has brought some very good features for lazy java developers. Try-with-resources is one of such feature 
 *		which cuts line of code and also make the code more robust.
 *
 *	How actually it works?
 *	======================
 *	->	In java 7, we have a new super interface java.lang.AutoCloseable. This interface have one method:
 *			void close() throws Exception;
 *	->	Java docs recommend this interface to be implemented on any resource that must be closed when it is no longer needed.
 *	->	When we open any such AutoCloseable resource in special try-with-resource block, immediately after finishing the try 
 *		block, JVM calls this close() method on all resources initialized in “try()” block.
 *	->	For example, BufferedReader has implemented close() method file this:
 *			public void close() throws IOException {
 *			    synchronized (lock) {
 *			        if (in == null)
 *			            return;
 *			        in.close();
 *			        in = null;
 *			        cb = null;
 *			    }
 *			}
 *	->	Due to above method definition, any underlying stream or IO resource is closed when this method is invoked by JVM.
 *	->	We can use it also to your custom resources by extending this interface.
 */
public class E_003_TryWithResource {

	public static class ResourceManagementBeforeJava7 {
		public static void main(String[] args) {
			BufferedReader br = null;
			try {
				String sCurrentLine;
				br = new BufferedReader(new FileReader("test.txt"));
				while ((sCurrentLine = br.readLine()) != null) {
					System.out.println(sCurrentLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public static class ResourceManagementInJava7 {
		public static void main(String[] args) {
			try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
				String sCurrentLine;
				while ((sCurrentLine = br.readLine()) != null) {
					System.out.println(sCurrentLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static class CustomResource implements AutoCloseable {
		public void accessResource() {
			System.out.println("Accessing the resource");
		}

		@Override
		public void close() throws Exception {
			System.out.println("CustomResource closed automatically");
		}
	}

	public static class TryWithCustomResource {
		public static void main(String[] args) {
			try (CustomResource cr = new CustomResource()) {
				cr.accessResource();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
