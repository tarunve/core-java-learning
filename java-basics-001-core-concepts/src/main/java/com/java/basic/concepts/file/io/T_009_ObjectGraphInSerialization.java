package com.java.basic.concepts.file.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *	->	Whenever we are serializing an object, the set of all objects which are reachable from that
 *		object will be serialized automatically. This group of objects is nothing but object graph.
 *	->	In object graph, every object should be serializable. If at least one object is not Serializable,
 *		then we will get RE:NotSerializableException.
 */
public class T_009_ObjectGraphInSerialization {
	
	private static final String FILE_LOCATION = "abc.ser";

	public static class Dog implements Serializable {
		private static final long serialVersionUID = 1L;
		Cat c = new Cat();
	}
	
	public static class Cat implements Serializable {
		private static final long serialVersionUID = 1L;
		Rat r = new Rat();
	}

	public static class Rat implements Serializable {
		private static final long serialVersionUID = 1L;
		int j = 20;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Dog d = new Dog();
		FileOutputStream fos = new FileOutputStream(FILE_LOCATION);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(d);
		oos.close();

		FileInputStream fis = new FileInputStream(FILE_LOCATION);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Dog d2 = (Dog) ois.readObject();
		System.out.println(d2.c.r.j);  //20
		ois.close();
	}
}
