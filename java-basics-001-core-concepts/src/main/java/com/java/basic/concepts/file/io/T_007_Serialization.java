package com.java.basic.concepts.file.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 	Serialization:
 * 	=============
 * 	->	Process of writing state of an object to a file is called serialization. But strictly
 * 		speaking, it is the process of converting an object from Java supported form into either
 * 		file supported form or network supported form.
 * 	->	By using FileOutputStream and ObjectOutputStream classes, we can implement Serialization.
 *
 * 	De-Serialization:
 * 	================
 * 	->	Process of reading state of an object from a file is called de-serialization. But strictly
 * 		speaking, it is the process of converting an object from either file supported form or
 * 		network supported form into Java supported form.
 * 	->	By using FileInputStream and ObjectInputStream classes, we can implement De-Serialization.
 *
 * 	->	We can serialize on Serializable Objects.
 * 	->	An object is said to be Serializable if and only if the corresponding object implements
 * 		Serializable interface.
 * 	->	Serializable interface is present in java.io package and it doesn't contain any methods.
 * 		It is marker interface i.e. everything taken care by JVM.
 * 	->	If we try to serialize a non-serializable object then we will get RE:NotSerializableException.
 */
public class T_007_Serialization {
	
	public static class Dog implements Serializable {
		private static final long serialVersionUID = 8736389L;
		int i = 10;
		int j = 20;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Dog d = new Dog();
		FileOutputStream fos = new FileOutputStream("abc.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(d);
		oos.close();
		
		FileInputStream fis = new FileInputStream("abc.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Dog d2 = (Dog) ois.readObject();
		System.out.println(d2.i + "=======" + d2.j);
		ois.close();
	}
	
}
