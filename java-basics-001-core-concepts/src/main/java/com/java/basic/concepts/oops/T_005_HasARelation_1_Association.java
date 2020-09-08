package com.java.basic.concepts.oops;

/**
 * 	Association
 * 	===========
 * 	->	Association is relation between two separate classes which establishes through their Objects. 
 * 		Association can be one-to-one, one-to-many, many-to-one, many-to-many.
 * 	->	In Object-Oriented programming, an Object communicates to other Object to use functionality 
 * 		and services provided by that object. Composition and Aggregation are the two forms of association.
 * 
 * 	Aggregation v/s Composition
 * 	===========================
 * 	1.	Dependency: Aggregation implies a relationship where the child can exist independently of the 
 * 					parent. For example, Bank and Employee, delete the Bank and the Employee still 
 * 					exist. whereas Composition implies a relationship where the child cannot exist independent of 
 * 					the parent. Example: Human and heart, heart don’t exist separate to a Human.
 * 	2.	Type of Relationship: Aggregation relation is “has-a” and composition is “part-of” relation.
 * 	3.	Type of association: Composition is a strong Association whereas Aggregation is a weak Association.
 */
public class T_005_HasARelation_1_Association {
	
	static class Bank {
		private String name;
		
		Bank(String name) {
			this.name = name;
		}
		
		public String getBankName() {
			return this.name;
		}
	}
	
	static class Employee {
		private String name;
		
		Employee(String name) {
			this.name = name;
		}
		
		public String getEmployeeName() {
			return this.name;
		}
	}
	
	static class Association {
		public static void main(String[] args) {
			Bank bank = new Bank("Axis");
			Employee emp = new Employee("Neha");
			
			System.out.println(emp.getEmployeeName() + " is employee of " + bank.getBankName());
		}
	}
}
