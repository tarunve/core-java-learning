package com.java.basic.concepts.file.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 	->	Applicable only for variables but not for methods or classes.
 * 	->	At the time of Serialization, if we don't want to save the value of a particular variable
 * 		to meet security constraints, then we should declare that variable as transient.
 * 	->	While performing serialization, JVM ignores the original value of transient variable and
 * 		save the default value of that type. Hence, transient means not to serialize.
 *
 * 	transient v/s static
 * 	--------------------
 * 	->	static variable is not part of the object state. Hence, it won't participate in serialization.
 * 		Due to this, declaring static variable as transient, there is no use.
 *
 * 	transient v/s final
 * 	-------------------
 * 	->	final variables will be participated in serialization directly by the value (not as variable).
 * 		Hence, declaring a final variable as transient, there is no impact.
 *
 *	->	We can serialize any number of objects to file but in which order we serialized, in the same
 *		order only, we have to de-serialize i.e. order of objects is important in serialization.
 */
@SuppressWarnings("static-access")
public class T_008_Transient {
	private static final String FILE_LOCATION = "abc.ser";
	
	public static class TransientClass1 {

		public static class TestObject implements Serializable {

			private static final long serialVersionUID = 1L;
			int i = 10;
			int j = 20;
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
			System.out.println(d2.i + "=======" + d2.j);  //10==========20
			ois.close();
		}
	}

	public static class TransientClass2 {

		public static class TestObject implements Serializable {

			private static final long serialVersionUID = 1L;
			transient int i = 10;
			int j = 20;
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
			System.out.println(d2.i + "=======" + d2.j);  //0==========20
			ois.close();
		}
	}
	
	public static class TransientClass3 {
		
		public static class TestObject implements Serializable {

			private static final long serialVersionUID = 1L;
			transient static int i = 10;
			transient int j = 20;
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
			System.out.println(d2.i + "=======" + d2.j);    //10==========0
			ois.close();
		}
	}
	
	public static class TransientClass4 {
		
		public static class TestObject implements Serializable {

			private static final long serialVersionUID = 1L;
			transient int i = 10;
			transient final int j = 20;
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
			System.out.println(d2.i + "=======" + d2.j);  //0==========20
			ois.close();
		}
	}
	
	public static class TransientClass5 {
		
		public static class TestObject implements Serializable {

			private static final long serialVersionUID = 1L;
			transient static int i = 10;
			transient final int j = 20;
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
			System.out.println(d2.i + "=======" + d2.j);  //10==========20
			ois.close();
		}
	}
	
}
