package com.java.basics.designpatterns.solid;

import lombok.Data;

/**
 *	->	The Liskov Substitution Principle is the third principle of SOLID, represented by the letter “L”. 
 *		It was Barbara Liskov who introduced the principle in 1987 in her conference keynote talk 
 *		“Data Abstraction”. The original phrasing of the Liskov Substitution Principle is a bit complicated, 
 *		as it asserts that:
 *		->	“In a computer program, if S is a subtype of T, then objects of type T may be replaced with objects 
 *			of type S (i.e., objects of type S may substitute objects of type T) without altering any of the 
 *			desirable properties of that program (correctness, task performed, etc.).”
 *	->	In layman’s terms, it states that an object of a superclass should be replaceable by objects of its 
 *		subclasses without causing issues in the application. So, a child class should never change the 
 *		characteristics of its parent class (such as the argument list and return types). You can implement 	
 *		the Liskov Substitution Principle by paying attention to the correct inheritance hierarchy.
 *	->	Spring can register one property editor for one data type and it is required to follow the constraint 
 *		mandated by base class PropertyEditorSupport. So is any class extend PropertyEditorSupport class, then 
 *		it can be substituted by everywhere base class is required.
 *
 *	->	Conclusion from Polymorphism : Object Oriented languages such as Java are very powerful and offer you 
 *			as a developer a tremendous amount of flexibility. You can misuse or abuse any language. In the 
 *		Polymorphism , If you’re writing objects which extend classes, but fails the ‘Is-A’ test, you’re likely 
 *		violating the Liskov Substitution Principle.
 */
public class T_004_LiskovSubstitutionPrinciple {

	/*
	 * To add a new delivery functionality AudiobookDelivery to the application, it is realized the it can't be
	 * delivered to physical locations i.e. overriding getDeliveryMethod is not possible.	
	 */
	static class WithoutLSPrinciple{
		@Data
		static class BookDelivery {
			String titles;
			int userID;

			void getDeliveryLocations() {}
		}
		
		static class HardcoverDelivery extends BookDelivery {
			@Override
			void getDeliveryLocations() {}
		}
		
		static class AudiobookDelivery extends BookDelivery {
			@Override
			void getDeliveryLocations() {/* can't be implemented */}
		}
	}
	
	/*
	 * we can fix the inheritance hierarchy to solve it as below.
	 */
	static class WithLSPrinciple{
		@Data
		static class BookDelivery {
			String title;
			int userID;
		}

		static class OfflineDelivery extends BookDelivery {
			void getDeliveryLocations() {}
		}

		static class OnlineDelivery extends BookDelivery {
			void getSoftwareOptions() {}
		}
		
		static class HardcoverDelivery extends OfflineDelivery {
			@Override
			void getDeliveryLocations() {}
		}

		static class AudiobookDelivery extends OnlineDelivery {
			@Override
			void getSoftwareOptions() {}
		}
	}
}
