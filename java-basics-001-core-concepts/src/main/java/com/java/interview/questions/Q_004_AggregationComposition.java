package com.java.interview.questions;

/*
 * 	->	Aggregation and composition are special type of association and differ only in weight of
 * 		relationship.
 * 	->	Composition is stronger form of "is part of" relationship compared to aggregation "has a".
 * 	->	In Composition, the member object can't exist outside the enclosing class while same is
 * 		not true for Aggregation.
 */
public class Q_004_AggregationComposition {

	public static class Address {
		public int apartmentNo;
		public String street;
		public String city;
		public String country;
		public int zipCode;
		
		public Address(int apartment, String street, String city, String country, int zipcode) {
			this.apartmentNo = apartment;
			this.street = street;
			this.city = city;
			this.country = country;
			this.zipCode = zipcode;
		}

		@Override
		public String toString() {
			return "[" + apartmentNo + ", " + street + ", " + city + ", " + country + ", " + zipCode + "]";
		}
	}
	
	public static class AggregationClass {
		
		public String empName;
		public Address address;
		
		public AggregationClass(String name, Address address) {
			this.address = address;
			this.empName = name;
		}

		@Override
		public String toString() {
			return empName + " - " + String.valueOf(address);
		}
	}

	public static class CompositionClass {
		
		public String empName;
		public Address address;
		
		public CompositionClass(String name) {
			this.address = new Address(1, "DefaultStreet", "DefaultCity", "DefaultCountry", 112);
			this.empName = name;
		}

		public Address getAddress() {
			return address;
		}
		
		@Override
		public String toString() {
			return empName + " - " + String.valueOf(address);
		}
	}

	@SuppressWarnings("null")
	public static void main(String[] args) {

		Address address = new Address(1003, "Magarpatta Road", "Pune", "MH", 411028);
		
		AggregationClass object1 = new AggregationClass("Emp1", address);
		System.out.println(object1);
		System.out.println(address);
		object1 = null;
		System.out.println(object1);
		System.out.println(address);
		
		CompositionClass object2 = new CompositionClass("Emp1");
		System.out.println(object2);
		System.out.println(object2.getAddress());
		object2 = null;
		System.out.println(object2);
		System.out.println(object2.getAddress());
	}

}
