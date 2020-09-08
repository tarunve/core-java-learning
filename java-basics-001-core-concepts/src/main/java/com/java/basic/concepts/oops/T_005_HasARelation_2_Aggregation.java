package com.java.basic.concepts.oops;

/**
 * 	Aggregation:
 * 	===========
 * 	->	It is a special form of Association where:
 * 		->	It represents Has-A relationship.
 * 		->	It is a unidirectional association i.e. a one way relationship. For example, department 
 * 			can have students but vice versa is not possible and thus unidirectional in nature.
 * 		->	In Aggregation, both the entries can survive individually which means ending one entity 
 * 			will not effect the other entity
 * 	->	Code reuse is best achieved by aggregation.
 */
import java.util.ArrayList;
import java.util.List;

public class T_005_HasARelation_2_Aggregation {
	/*
	 * Department class contains list of student Objects. It is associated with student class through its Object(s).
	*/
	static class Department {
		
		String name;
		private final List<Student> students;
		
		Department(String name, List<Student> students) {
			this.name = name;
			this.students = students;
		}
		
		public List<Student> getStudents() {
			return students;
		}
	}
	
	static class Student {
		String name;
		int id;
		String dept;
		
		Student(String name, int id, String dept) {
			this.name = name;
			this.id = id;
			this.dept = dept;
		}
	}
	
	/*
	    Institute class contains list of Department Objects. It is associated with Department class through its Object(s).
	*/
	static class Institute {
		String instituteName;
		private final List<Department> departments;
		
		Institute(String instituteName, List<Department> departments) {
			this.instituteName = instituteName;
			this.departments = departments;
		}
		
		// count total students of all departments in a given institute
		public int getTotalStudentsInInstitute() {
			int noOfStudents = 0;
			List<Student> students;
			for (Department dept : departments) {
				students = dept.getStudents();
				for (int i = 0; i < students.size(); i++) {
					noOfStudents++;
				}
			}
			return noOfStudents;
		}
		
	}
	
	public static void main(String[] args) {
		Student s1 = new Student("Mia", 1, "CSE");
		Student s2 = new Student("Priya", 2, "CSE");
		Student s3 = new Student("John", 1, "EE");
		Student s4 = new Student("Rahul", 2, "EE");
		
		// making a List of CSE Students.
		List<Student> cse_students = new ArrayList<Student>();
		cse_students.add(s1);
		cse_students.add(s2);
		
		// making a List of EE Students
		List<Student> ee_students = new ArrayList<Student>();
		ee_students.add(s3);
		ee_students.add(s4);
		
		Department CSE = new Department("CSE", cse_students);
		Department EE = new Department("EE", ee_students);
		
		List<Department> departments = new ArrayList<Department>();
		departments.add(CSE);
		departments.add(EE);
		
		// creating an instance of Institute.
		Institute institute = new Institute("BITS", departments);
		
		System.out.print("Total students in institute: " + institute.getTotalStudentsInInstitute());
	}
}
