package com.java.enhancements.E003.small.enhancements;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

/**
 *  -   Two new advance collectors have been added:
 *      1.  filtering:
 *              public static <..> Collector<..> filtering(Predicate<..> p, Collector<..> downstream)
 *      2.  flatMapping:
 *              public static <..> Collector<..> flatMapping(Function<..> mapper, Collector<..> downstream)
 */
public class E003_Collectors {
    public static void main(String[] args) {
        Stream<Book> books = Book.getBooks();
        // Collect all books costing more than 10, grouped by author(s)
        Map<Set<String>, Set<Book>> booksByAuthors = books.collect(
                        groupingBy(Book::getAuthors, filtering(b -> b.getPrice() > 10, toSet())));
        System.out.println(booksByAuthors);

        books = Book.getBooks();
        // Collect all authors that sell books at a given price
        Map<Double, Set<String>> authorsSellingForPrice = books.collect(
                        groupingBy(Book::getPrice,flatMapping(b -> b.getAuthors().stream(),toSet())));
        System.out.println(authorsSellingForPrice);
    }
}
