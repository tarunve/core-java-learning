package com.java.enhancements.E003.small.enhancements;


import java.util.*;

/**
 *  Immutable Collections with Factory Methods in Java 9
 *  ===================================================
 *  1.  Create Immutable List:
 *      -   Use List.of() static factory methods to create immutable lists.
 *              static <E> List<E>  of()
 *              static <E> List<E>  of(E e1)
 *              static <E> List<E>  of(E e1, E e2)
 *              static <E> List<E>  of(E e1, E e2, E e3)
 *              static <E> List<E>  of(E e1, E e2, E e3, E e4)
 *              static <E> List<E>  of(E e1, E e2, E e3, E e4, E e5)
 *              static <E> List<E>  of(E e1, E e2, E e3, E e4, E e5, E e6)
 *              static <E> List<E>  of(E e1, E e2, E e3, E e4, E e5, E e6, E e7)
 *              static <E> List<E>  of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8)
 *              static <E> List<E>  of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9)
 *              static <E> List<E>  of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10)
 *              //varargs
 *              static <E> List<E>  of(E... elements)
 *      -   The List instances created by these methods have the following characteristics:
 *          1.  These lists are immutable. Elements cannot be added, removed, or replaced
 *              in these lists. Calling any mutator method (i.e. add, addAll, clear, remove,
 *              removeAll, replaceAll) will always cause UnsupportedOperationException
 *              to be thrown.
 *          2.  They do not allow null elements. Attempts to add null elements result in
 *              NullPointerException.
 *          3.  They are serializable if all elements are serializable.
 *          4.  The order of elements in the list is the same as the order of the provided
 *              arguments, or of the elements in the provided array.
 *
 *  2.  Create Immutable Set
 *      -   Set behave very similar to List with only few differences. e.g.
 *          1.  Set do not allow duplicate elements as well. Any duplicate element passed
 *              will result in IllegalArgumentException.
 *          2.  The iteration order of set elements is unspecified and is subject to change.
 *      -   All Set factory methods have the same signature as List.
 *
 *  3.  Create Immutable Map:
 *      -   Map factory methods are same as List or Set overloaded factory methods. Only
 *          difference is that the signatures of the of methods take alternating keys and
 *          values as arguments:
 *              static <K,V> Map<K,V>   of()
 *              static <K,V> Map<K,V>   of(K k1, V v1)
 *              static <K,V> Map<K,V>   of(K k1, V v1, K k2, V v2)
 *              ...
 *              static <K,V> Map<K,V>   ofEntries(Map.Entry<? extends K,? extends V>... entries)
 *              static <K,V> Map.Entry<K,V> entry(K k, V v)
 */

public class E001_CollectionFactoryMethods {

    public static void main(String[] args) {
        // Previous version:
        List<String> books = Arrays.asList("Java 9 Modularity");
        books = new ArrayList<>(){{ add(""); }};
        books = Collections.emptyList();

        // Java 9 - Immutable List
        List<Integer> ints = List.of(1, 2, 3);
        //ints.add(10); // Runtime error - UnsupportedOperation
        ints.getClass(); // ImmutableCollections$ListN class
        List.of(1).getClass(); // ImmutableCollections$List1 class - super-optimized version
                               // of List for one/two elems

        // Java 9 - Immutable Set
        Set<Integer> integerSet = Set.of(1,2 ,3 );
        //Set.of(null); // NullPointerException
        //Set.of("a", "a"); // IllegalArgumentException - duplicate element "a"

        // Java 9 - Immutable Map
        Map.of("key1", 2, "key2", 3);
        Map.ofEntries(Map.entry("key1", true)); // Entry Set
        Map.of("a", 1, "a", 2); // IllegalArgumentException - Duplicate Key
    }
}
