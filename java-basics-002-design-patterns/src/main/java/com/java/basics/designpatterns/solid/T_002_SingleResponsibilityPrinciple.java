package com.java.basics.designpatterns.solid;

/**
 * 	->	The Single Responsibility Principle is the first SOLID design principle, represented by the 
 * 		letter “S” and defined by Robert C Martin. It states that in a well-designed application, each 
 * 		class (microservice, code module) should have only one single responsibility. Responsibility 
 * 		is used in the sense of having only one reason to change.
 * 	->	When a class handles more than one responsibility, any changes made to the functionalities might 
 * 		affect others. This is bad enough if you have a smaller app but can become a nightmare when you 
 * 		work with complex, enterprise-level software. By making sure that each module encapsulates only 
 * 		one responsibility, you can save a lot of testing time and create a more maintainable architecture.
 * 
 * 	->	Example : log4j, slf4j -> serves only the logging functionality.
 */
public class T_002_SingleResponsibilityPrinciple {

	/*
	 * 	Below class is violating the SR principle because it is serving more than 1 purpose:
	 * 	1.	Calculate total invoice
	 * 	2.	Print Invoice
	 * 	3.	Save Invoice to DB
	 */
	static class WithoutSRPrinciple {
		static class Invoice {

			private final int price;
			private final int quantity;

			Invoice(int price, int quantity){
				this.price = price;
				this.quantity = quantity;
			}

			public int totalInvoice(){
				return price*quantity;
			}

			public void printInvoice() { }

			public void saveInvoice() { }
		}
	}

	/*
	 * In below class, all the purpose are segregated.
	 */
	static class WithSRPrinciple {
		static class Invoice {

			private final int price;
			private final int quantity;

			Invoice(int price, int quantity) {
				this.price = price;
				this.quantity = quantity;
			}

			public int totalInvoice() {
				return price * quantity;
			}
		}

		static class InvoicePrinter {
			Invoice invoice;

			InvoicePrinter(Invoice invoice) {
				this.invoice = invoice;
			}

			void printInvoice() {
				System.out.println("Print Invoice Implementation");
			}

		}

		static class InvoiceDao {
			Invoice invoice;

			InvoiceDao(Invoice invoice) {
				this.invoice = invoice;
			}

			void saveInvoice() {
				System.out.println("Save Invoice Implementation");
			}

		}
	}
}
