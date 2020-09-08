package com.java.basic.concepts.file.io;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * 	-> 	The main advantage of externalization over Serialization is - everything taken care by programmer
 * 		and JVM doesn't have any control.
 * 	->	Based on our requirement, we can save either total object or part of the object which improves
 * 		performance of the system.
 * 	->	To provide externalizable ability to any Java object, compulsory corresponding class should
 * 		implement Externalizable interface.
 * 	->	Externalizable is child interface of Serializable and it defines 2 methods:
 * 		1.	public void writeExternal(ObjectOutput out) throws IOException
 * 			->	This method will be executed automatically at the time of serialization.
 * 			->	Within this method we have to write code to save required variables to the file.
 * 		2.	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
 * 			->	This method will be executed automatically at the time of de-serialization.
 * 			->	Within this method we have to write code to read required variables from the file
 * 				and assign to current object.
 * 			->	But strictly speaking, at the time of de-serialization, JVM will create a new object
 * 				by executing public no-arg constructor. On that object JVM will call readExternal method.
 * 			->	Hence, every externalizable implemented class should compulsory contain public no-arg
 * 				constructor otherwise we will get RE:InvalidClassException.
 *
 * 	->	In Serialization , transient keyword will play role but in externalization, transient keyword
 * 		won't play any role. Of course, transient keyword not required in externalization.
 *
 */
public class T_012_Externalization implements Externalizable {

	String s;
	int i, j;

	public T_012_Externalization() {
		System.out.println("public no-arg constructor");
	}

	public T_012_Externalization(String str, int i, int j) {
		this.s = str;
		this.i = i;
		this.j = j;
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(s);
		out.writeInt(i);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		s = String.valueOf(in.readObject());
		i = Integer.valueOf(in.readInt());
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		T_012_Externalization d = new T_012_Externalization("durga", 10, 20);
		FileOutputStream fos = new FileOutputStream("abc.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(d);
		oos.close();

		FileInputStream fis = new FileInputStream("abc.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		T_012_Externalization d2 = (T_012_Externalization) ois.readObject();
		System.out.println(d2.s + "===========" + d2.i + "=========" + d2.j);
		ois.close();
	}

}
