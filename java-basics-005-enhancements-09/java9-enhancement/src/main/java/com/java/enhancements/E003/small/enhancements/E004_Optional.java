package com.java.enhancements.E003.small.enhancements;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  -   3 methods added in Java 9:
 *      1.  ifPresentOrElse()
 *              void ifPresentOrElse(Consumer<T> action, Runnable emptyAction)
 *      2.  or():
 *              Optional<T> or(Supplier<Optional<T>> supplier)
 *      3.  stream():
 *              Stream<T> stream()
 */
public class E004_Optional {
    public static void main(String[] args) {
        ifPresentOrElseExample();
        orExample();
        streamExample();
    }

    private static void ifPresentOrElseExample() {
        Optional<Book> full = Optional.of(Book.getBook());
        // Before ifPresentOrElse
        full.ifPresent(System.out::println);
        if (full.isPresent()) {
            System.out.println(full.get());
        } else {
            System.out.println("Nothing here");
        }

        // After ifPresentOrElse - for non-empty
        full.ifPresentOrElse(System.out::println, () -> System.out.println("Nothing here!"));
        // After ifPresentOrElse - for empty
        Optional.empty().ifPresentOrElse(System.out::println, () -> System.out.println("Nothing here!"));
    }

    private static void orExample() {
        Optional<Book> localFallback = Optional.of(Book.getBook());
        // Before Optional.or
        Book bestBookBefore = getBestOffer()
                .orElse(getExternalOffer().orElse(localFallback.get()));  // .get() is BAD!

        // After Optional.or
        Optional<Book> bestBook = getBestOffer()
                        .or(() -> getExternalOffer())
                        .or(() -> localFallback);
        System.out.println(bestBook);
    }

    private static void streamExample() {
        Stream<Optional<Integer>> optionals = Stream.of(Optional.of(1),
                                        Optional.empty(), Optional.of(2));
        Stream<Integer> ints = optionals.flatMap(Optional::stream);
        ints.forEach(System.out::println);

        // Find all first authors of the books
        Set<String> authors = Book.getBooks()
                .map(book -> book.authors.stream().findFirst())
                .flatMap(optAuthor -> optAuthor.stream())
                .collect(Collectors.toSet());
        System.out.println(authors);
    }

    static Optional<Book> getBestOffer() {
        return Optional.empty();
    }

    static Optional<Book> getExternalOffer() {
        return Optional.of(new Book("External Book", Set.of(), 11.99));
    }
}
