package com.java.enhancements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 	->	Comparator is used when we want to sort a collection of objects which can be compared with each other. 
 * 		This comparison can be done using Comparable interface as well, but it restrict you compare these objects 
 * 		in a single particular way only. If you want to sort this collection, based on multiple criterias/fields, 
 * 		then you have to use Comparator only.
 */
public class E_011_Comparator {

	public static class Employee {
		private Integer id;
		private String firstName;
		private String lastName;
		private Integer age;

		public Employee(Integer id, String firstName, String lastName, Integer age) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "\n\t[" + this.id + "," + this.firstName + "," + this.lastName + "," + this.age + "]";
		}
	}

	private static List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(6, "Yash", "Chopra", 25));
		employees.add(new Employee(2, "Aman", "Sharma", 28));
		employees.add(new Employee(3, "Aakash", "Yaadav", 52));
		employees.add(new Employee(5, "David", "Kameron", 19));
		employees.add(new Employee(4, "James", "Hedge", 72));
		employees.add(new Employee(8, "Balaji", "Subbu", 88));
		employees.add(new Employee(7, "Karan", "Johar", 59));
		employees.add(new Employee(1, "Lokesh", "Gupta", 32));
		employees.add(new Employee(9, "Vishu", "Bissi", 33));
		employees.add(new Employee(10, "Lokesh", "Ramachandran", 60));
		return employees;
	}

	public static void main(String[] args) {
		/*
		 * Sort by first name
		 */
		List<Employee> employees = getEmployees();
		employees.sort(Comparator.comparing(e -> e.getFirstName()));
		employees.sort(Comparator.comparing(Employee::getFirstName));
		System.out.println(employees);

		/*
		 * Sort by first name – ‘reverse order’
		 */
		List<Employee> employeesList = getEmployees();
		Comparator<Employee> comparator = Comparator.comparing(e -> e.getFirstName());
		employeesList.sort(comparator.reversed());
		System.out.println(employeesList);

		/*
		 * Sort on multiple fields – thenComparing()
		 */
		List<Employee> empList = getEmployees();
		Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);
		empList.sort(groupByComparator);
		System.out.println(empList);
		
		/*
		 * Parallel sort (with multiple threads)
		 */
		Employee[] employeesArray = employees.toArray(new Employee[employees.size()]);
		Arrays.parallelSort(employeesArray, groupByComparator);
		System.out.println(Arrays.toString(employeesArray));
	}

}
