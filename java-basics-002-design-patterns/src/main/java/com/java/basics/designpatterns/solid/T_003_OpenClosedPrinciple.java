package com.java.basics.designpatterns.solid;

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
	 * To add the new feature, we created a new BiographyDiscount class and updated the DiscountManager class
	 * which violated the OC principle.
	 */
	class WithoutOCPrinciple {
		class CookbookDiscount {
			String getCookbookDiscount() {
				String discount = "30% between Dec 1 and 24.";
				return discount;
			}
		}

		class DiscountManager {
			void processCookbookDiscount(CookbookDiscount discount) {}
			void processBiographyDiscount(BiographyDiscount discount) {}
		}
		
		class BiographyDiscount {
			String getBiographyDiscount() {
				String discount = "50% on the subject's birthday.";		
				return discount;
			}
		}
	}
	
	/*
	 * Using Interface, we can solve this problem.
	 */
	interface BookDiscount {
		String getBookDiscount();
	}

	class WithOCPrinciple{
		class CookbookDiscount implements BookDiscount {
			@Override
			public String getBookDiscount() {
				String discount = "30% between Dec 1 and 24.";
				return discount;
			}
		}

		class BiographyDiscount implements BookDiscount {
			@Override
			public String getBookDiscount() {
				String discount = "50% on the subject's birthday.";
				return discount;
			}
		}
		
		class DiscountManager {
			void processBookDiscount(BookDiscount discount) {}
		}
	}
}
