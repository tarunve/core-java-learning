package com.java.basic.concepts.file.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 	->	In Serialization, both sender and receiver need not be same, need not to use same machine and need
 * 		not to be from same location. The person may be different, machine may be different and locations
 * 		may be different.
 * 	->	In serialization, both sender and receiver should have .class file at the beginning only, just
 * 		state of the object is traveling from sender to receiver.
 * 	->	At the time of serialization, with every object, sender side JVM will save a unique identifier. JVM
 * 		is responsible to generate this unique identifier based on .class file.
 * 	->	At the time of de-serialization, receiver side JVM will compare the unique identifier associated
 * 		with the object with local class unique identifier. If both are matched then only, de-serialization
 * 		will be performed otherwise we will get RE: InvalidClassException.
 * 	->	This unique identifier is nothing but SerialVersionUID.
 *
 * 	Problems depending on default serialVersionUID
 * 	----------------------------------------------
 * 	->	Both sender and receiver should use the same JVM with respect to vendor and platform and version
 * 		otherwise receiver unable to de-serialize because of different serialVersionUID.
 * 	->	Both sender and receiver should use same .class versions. After serialization, if there is any
 * 		change in that .class file at receiver side then receiver unable to de-serialize.
 * 	->	To generate serialVersionUID, internally JVM may  use complex algorithm which may create
 * 		performance problems.
 * 	->	We can solve above problems by configuring our own serialVersionUID.
 * 			private static final long serialVersionUID = 1L;
 */
public class T_013_SerialVersionUID_ {

	public static class Dog implements Serializable {
		private static final long serialVersionUID = 1L;
		int i = 10;
		int j = 20;
	}
	
	public static class Sender {
		public static void main(String[] args) throws IOException {
			Dog d1 = new Dog();
			FileOutputStream fos = new FileOutputStream("abc.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(d1);
			oos.close();
		}
	}

	public static class Receiver {
		public static void main(String[] args) throws IOException, ClassNotFoundException {
			FileInputStream fos = new FileInputStream("abc.ser");
			ObjectInputStream oos = new ObjectInputStream(fos);
			Dog d2 = (Dog) oos.readObject();
			System.out.println(d2.i + "=========" + d2.j);
			oos.close();
		}
	}
}
