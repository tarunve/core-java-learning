package com.java.basic.concepts.oops;

/**
 * 	Composition:
 * 	===========
 * 	->	Composition is a restricted form of Aggregation in which two entities are highly dependent on each other.
 * 	->	It represents part-of relationship.
 * 	->	In composition, both the entities are dependent on each other.
 * 	->	When there is a composition between two entities, the composed object cannot exist without the other entity.
 */
import java.util.ArrayList;
import java.util.List;

public class T_005_HasARelation_3_Composition {
	static class Book {
		public String title;
		public String author;
		
		Book(String title, String author) {
			this.title = title;
			this.author = author;
		}
	}
	
	static class Library {
		private final List<Book> books;
		
		Library(List<Book> books) {
			this.books = books;
		}
		
		public List<Book> getTotalBooksInLibrary() {
			return books;
		}
	}
	
	public static void main(String[] args) {
		Book b1 = new Book("EffectiveJ Java", "Joshua Bloch");
		Book b2 = new Book("Thinking in Java", "Bruce Eckel");
		Book b3 = new Book("Java: The Complete Reference", "Herbert Schildt");
		
		List<Book> books = new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		
		Library library = new Library(books);
		
		List<Book> bks = library.getTotalBooksInLibrary();
		for (Book bk : bks) {
			System.out.println("Title : " + bk.title + " and Author : " + bk.author);
		}
	}
}
