package com.java.enhancements.E003.small.enhancements;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *  Added Methods:
 *  1.  takeWhile:
 *          Stream<T> takeWhile(Predicate<? super T> predicate)
 *  2.  dropWhile:
 *          Stream<T> dropWhile(Predicate<? super T> predicate)
 *  3.  ofNullable:
 *          static Stream<T> ofNullable(T t)
 *  4.  iterate:
 *          static Stream<T> iterate(T seed, Predicate<? super T) hasNext, UnaryOperator<T> next)
 *
 *  Limiting Stream with takeWhile() and dropWhile() methods
 *  --------------------------------------------------------
 *  -   The new methods takeWhile and dropWhile allow you to get portions of a stream based
 *      on a predicate. Here a stream can be either ordered or unordered, so :
 *      1.  On an ordered stream, takeWhile returns the “longest prefix” of elements taken
 *          from the stream that match the given predicate, starting at the beginning of
 *          the stream.
 *      2.  On an un-ordered stream, takeWhile returns a subset of the stream’s elements
 *          that match the given predicate (but not all), starting at the beginning of the
 *          stream.
 *  -   The dropWhile method does the opposite of takeWhile method.
 *      1.  On an ordered stream, dropWhile returns remaining items after the “longest prefix”
 *          that match the given predicate.
 *      2.  On an un-ordered stream, dropWhile returns remaining stream elements after
 *          dropping subset of elements that match the given predicate.
 *
 *  Overloaded Stream iterate method
 *  --------------------------------
 *  -   iterate() methods used for creating a stream which starts with a single element
 *      (the seed), and subsequent elements are produced by successively applying the
 *      unary operator. The result is an infinite stream. To terminate the stream, a
 *      limit or some other short-circuiting function, like findFirst or findAny is used.
 *      -   Java 8 iterate method :
 *              static Stream iterate(final T seed, final UnaryOperator f)
 *      -   Java 9 overloaded iterate method:
 *              static Stream iterate(T seed, Predicate hasNext, UnaryOperator next)
 *
 *  New Stream ofNullable() method
 *  ------------------------------
 *  -   Until Java 8, you cannot have null value in a stream. It would have caused NPE.
 *  -   In Java 9, the ofNullable method lets you create a single-element stream which
 *      wraps a value if not null, or is an empty stream otherwise.
 */
public class E002_Stream {

    public static void main(String[] args) {
        takeWhileExample();
        dropWhileExample();
        iterateExample();
        ofNullableExample();
    }

    private static void takeWhileExample() {
        // Before takeWhile
        IntStream.range(1, 100).filter(i -> i < 4) // applied to all elements
                .forEach(System.out::println);

        // With takeWhile, only the first 4 elements are
        // evaluated against the predicate.
        IntStream.range(1, 100).takeWhile(i -> i < 4) // short-circuits on element '4'
                .forEach(System.out::println);
    }

    private static void dropWhileExample() {
        // Before dropWhile
        IntStream.range(1, 10).filter(i -> i >= 4)
                .forEach(System.out::println);

        // With dropWhile (only works if Stream is sorted!)
        IntStream.range(1, 10).dropWhile(i -> i < 4)
                .forEach(System.out::println);
    }

    private static void iterateExample() {
        // Java 8 iterate method
        List<Integer> numbers = Stream.iterate(1, i -> i+1)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(numbers);

        // Java 9 iterate method
        List<Integer> nums = Stream.iterate(1, i -> i <= 10 ,i -> i+1)
                .collect(Collectors.toList());
        System.out.println(nums);
    }

    private static void ofNullableExample() {
        long zero = Stream.ofNullable(null).count();
        long one = Stream.ofNullable(Book.getBook()).count();

        System.out.printf("zero: %d, one: %d", zero, one);

        // Before ofNullable
        Book book = getPossiblyNull(true);
        Stream<String> authors = book == null ? Stream.empty() : book.authors.stream();
        authors.forEach(System.out::println);

        // With ofNullable
        Stream.ofNullable(getPossiblyNull(false))
                .flatMap(b -> b.authors.stream())
                .forEach(System.out::println);
    }

    private static Book getPossiblyNull(boolean isNull) {
        return isNull ? null : Book.getBook();
    }
}
