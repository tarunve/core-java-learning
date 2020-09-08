package com.java.interview.questions;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * 	->	When the state of an object can't be changed after its construction then the object is
 * 		called Immutable.
 *
 *  1) How to create a Immutable Class :
 *  	1. Make your class final .
 *  	2. Make all instance variables private & final so that they are initialized once inside
 *  	   constructor and never modified afterwards
 *  	3. Provide only getter methods , don't provide setter methods.
 *  	4. If your class holds mutable object , return a clone copy of field and never return the real
 *  	   object instance.
 *
 *  2) Do all properties of Immutable needs to be final ?
 *  	Yes, Once it is initialized in constructor . After that , nobody can change the value.
 */

public final class Q_002_Immutablity {

	private final String name;
	private final String lastName;
	private final int age;
	private final Date currDate;
	private final Set<String> set;

	public Q_002_Immutablity(String name, String lastName, int age, Set<String> set) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.currDate = new Date();
		this.set = set;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public Date getCurrDate() {
		return new Date(currDate.getTime());
	}

	public Set<String> getSet() {
		return new LinkedHashSet<>(set);
	}

	@Override
	public String toString() {
		return "Immutablity_Q_02 [name=" + name + ", lastName=" + lastName + ", age=" + age + ", currDate=" + currDate + ", set=" + set + "]";
	}

	public static void main(String[] args) {
		Set<String> skills = new HashSet<>();
		skills.add("Java");

		Q_002_Immutablity immutableObject = new Q_002_Immutablity("Tarun", "Verma", 26, skills);
		System.out.println(immutableObject);
		System.out.println(immutableObject.hashCode());

		immutableObject.getSet().add("Deepak");
		System.out.println(immutableObject);
		System.out.println(immutableObject.hashCode());

	}
}
