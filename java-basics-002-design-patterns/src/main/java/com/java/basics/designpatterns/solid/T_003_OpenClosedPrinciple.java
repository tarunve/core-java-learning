package com.java.basics.designpatterns.solid;

import lombok.Data;

/**
 * 	->	The Open/Closed Principle is the “O” of SOLID’s five software design principles. It was Bertrand Meyer 
 * 		who coined the term in his book “Object-Oriented Software Construction”. 
 * 	->	The Open/Closed Principle states that classes, modules, microservices, and other code units should be 
 * 		open for extension but closed for modification.
 * 	->	So, you should be able to extend your existing code using OOP features like inheritance via subclasses 
 * 		and interfaces. However, you should never modify classes, interfaces, and other code units that already 
 * 		exist (especially if you use them in production), as it can lead to unexpected behavior. If you add a 
 * 		new feature by extending your code rather than modifying it, you minimize the risk of failure as much 
 * 		as possible. Besides, you also don’t have to unit test existing functionalities.
 * 	->	For example, spring framework has class DispatcherServlet. This class acts as front controller for 
 * 					 String based web applications. To use this class, we are not required to modify this class. 
 * 		All we need is to pass initialization parameters and we can extend it’s functionality the way we want.
 */
public class T_003_OpenClosedPrinciple {

	/*
	 * 	To add the new feature, we created a new saveInvoiceToMongoDB() method and updated
	 * 	the InvoiceDao class which violated the OC principle.
	 */
	@Data
	static class Invoice {

		private final int price;
		private final int quantity;

		Invoice(int price, int quantity) {
			this.price = price;
			this.quantity = quantity;
		}
	}

	static class WithoutOCPrinciple {

		static class InvoiceDao {
			Invoice invoice;

			InvoiceDao(Invoice invoice) {
				this.invoice = invoice;
			}

			void saveInvoiceToFile() {
				System.out.println("Save Invoice to Local Disk");
			}

			void saveInvoiceToOracleDB() {
				System.out.println("Save Invoice to Oracle DB");
			}

			void saveInvoiceToMongoDB(){ }
		}
	}
	
	/*
	 * Using Interface, we can solve this problem.
	 */


	static class WithOCPrinciple{

		interface InvoiceDao {
			void save(Invoice invoice);
		}

		static class InvoiceLocalDao implements InvoiceDao {
			@Override
			public void save(Invoice invoice) {
				System.out.println("Save Invoice to Local Disk");
			}
		}

		static class InvoiceOracleDao implements InvoiceDao {
			@Override
			public void save(Invoice invoice) {
				System.out.println("Save Invoice to Oracle DB");
			}
		}
		
		static class InvoiceMongoDao implements  InvoiceDao {
			@Override
			public void save(Invoice invoice) {
				System.out.println("Save Invoice to Mongo DB");
			}
		}
	}
}
