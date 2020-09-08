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
	 * 	Below class is violating the SR principle because it is serving 2 purposes:
	 * 	1.	Get/Set data.
	 * 	2.	Search Book
	 */
	static class WithoutSRPrinciple {
		class Book {

			String title;
			String author;

			String getTitle() {
				return title;
			}

			void setTitle(String title) {
				this.title = title;
			}

			String getAuthor() {
				return author;
			}

			void setAuthor(String author) {
				this.author = author;
			}

			void searchBook() {

			}
		}
	}

	/*
	 * In below class, both the purpose are segregating.
	 */
	static class WithSRPrinciple {
		class Book {

			String title;
			String author;

			String getTitle() {
				return title;
			}

			void setTitle(String title) {
				this.title = title;
			}

			String getAuthor() {
				return author;
			}

			void setAuthor(String author) {
				this.author = author;
			}

		}

		class InventoryView {

			Book book;

			InventoryView(Book book) {
				this.book = book;
			}

			void searchBook() {

			}

		}
	}
}
