package com.java.basic.concepts.oops;

/*
    * Also known as Inheritance.
    * Can be achieved by 'extends' keyword.
    * Total Java API is implemented based on Inheritance concept. Ex. Java Objects are defined in Object class
    * 	and hence acts as root class for all Java Classes.
    * Multiple inheritance is not allowed due to ambiguity problem. MultiLevel is possible.
    * Multiple inheritance possible only in case of interfaces.
    * Cyclic inheritance is not allowed in Java. Of course, it is not required even.
    * 		Ex. A extends A , A extends B and B extends A . It will give CE:Cyclic inheritance not allowed.
 */

public class T_004_IsARelationship {
	
	static class Parent_IsA {
		public void m1() {
			System.out.println("Parent Class...");
		}
	}
	
	static class Child_IsA extends Parent_IsA {
		public void m2() {
			System.out.println("Child Class...");
		}
	}
	
	public static void main(String[] args) {
		//Parent reference - Parent Object
		Parent_IsA parent = new Parent_IsA();
		parent.m1();
		//parent.m2();
		
		//Child reference - Child Object
		Child_IsA child = new Child_IsA();
		child.m1();
		child.m2();
		
		//Parent reference - Child Object
		Parent_IsA parent1 = new Child_IsA();
		parent1.m1();
		//parent1.m2();
	}
}
