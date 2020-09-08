package com.java.basic.concepts.file.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 	->	During default serialization, there may be a chance of lost of information because of
 * 		transient object. To recover this loss, we should go for customized serialization.
 * 	->	We can implement customized serialization by using the following 2 methods :
 * 		1.	private void writeObject(ObjectOutputStream oos) throws Exception
 * 			->	This method will be executed automatically at the time of serialization. Hence,
 *				at the time of serialization, if we want to perform any activity, we have to
 *				define that in this method only.
 *		2.	private void readObject(ObjectInputStream ois) throws Exception
 *			->	This method will be executed automatically at the time of de-serialization. Hence,
 *				at the time of de-serialization, if we want to perform any activity, we have to
 *				define that in this method only.
 *		->	The above methods are callback methods because these are executed by JVM automatically.
 *		->	While performing which object serialization, we have to do extra work, in the corresponding
 *			class we have to define these methods.
 *		->	Programmers can't call private methods from outside but JVM can.
 */
public class T_010_CustomizedSerialization {

	private static final String FILE_LOCATION = "abc.ser";
	
	public static class WithoutCustomizedSerialization {
		
		static class TestObject implements Serializable {
			private static final long serialVersionUID = 1L;
			String user = "abc";
			transient String pass = "abc";
		}
		
		public static void main(String[] args) throws IOException, ClassNotFoundException {
			TestObject d = new TestObject();
			FileOutputStream fos = new FileOutputStream(FILE_LOCATION);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(d);
			oos.close();

			FileInputStream fis = new FileInputStream(FILE_LOCATION);
			ObjectInputStream ois = new ObjectInputStream(fis);
			TestObject d2 = (TestObject) ois.readObject();
			System.out.println(d2.user + "=======" + d2.pass);
			ois.close();
		}
	}

	public static class WithCustomizedSerialization {
		
		static class TestObject implements Serializable {
			private static final long serialVersionUID = 1L;
			String user = "abc";
			transient String pass = "akljjsdmsdoks";

			private void writeObject(ObjectOutputStream oos) throws Exception {
				oos.defaultWriteObject();
				String epass = "123" + pass;
				oos.writeObject(epass);
			}
			
			private void readObject(ObjectInputStream ois) throws Exception {
				ois.defaultReadObject();
				String epass = String.valueOf(ois.readObject());
				pass = epass.substring(3);
			}
		}
		
		public static void main(String[] args) throws IOException, ClassNotFoundException {
			TestObject d = new TestObject();
			FileOutputStream fos = new FileOutputStream(FILE_LOCATION);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(d);
			oos.close();

			FileInputStream fis = new FileInputStream(FILE_LOCATION);
			ObjectInputStream ois = new ObjectInputStream(fis);
			TestObject d2 = (TestObject) ois.readObject();
			System.out.println(d2.user + "=======" + d2.pass);
			ois.close();
		}
	}
}
