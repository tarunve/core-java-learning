package interview.java.core.oops;

import interview.questions.Q_002_Immutablity;
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
public class Q_004_ImmutableClass {

    public static class Age{
        private int day;
        private int month;
        private int year;

        public Age(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }
    }

    public static class Student{
        private final int id;
        private final String name;
        private final Age age;

        public Student(int id, String name, Age age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Age getAge() {
            return new Age(age.getDay(), age.getMonth(), age.getYear());
        }
    }

    public static void main(String[] args) {
        Age age = new Age(1,1,1992);
        Student student = new Student(1,"Alex", age);
        System.out.println("Alex birth year before modification = " + student.getAge().getYear());
        student.getAge().setYear(1993);
        System.out.println("Alex birth year after modification = " + student.getAge().getYear());
    }
}
