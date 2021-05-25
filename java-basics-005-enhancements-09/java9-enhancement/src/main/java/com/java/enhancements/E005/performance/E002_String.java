package com.java.enhancements.E005.performance;

/**
 *  1.  Compact String:
 *      -   Lower memory usage
 *      -   effective immediately without code changes.
 *      -   Till Java 8, String was build using char[] array and char is
 *          stored in UTF-16 encoding.
 *      -   In Java 9, String is modified using byte[] array and a 'coder'
 *          flag which decide if it would be UTF-16 (if value=1) otherwise
 *          it takes half of the memory String used to take earlier.
 *  2.  String Concatenation Changes:
 *      -   Change concatenation translation strategy
 *      -   Invoke dynamic bytecode
 *      -   ground work for future improvements
 */
public class E002_String {
}
