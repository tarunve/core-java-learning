package com.java.enhancements.E003.small.enhancements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 *  Language Enhancements:
 *  1.  Diamond Operator:
 *      -   Before Java 9 , We can couldn't create anonymous classes with diamond operator.
 *  2.  Try With Resource:
 *      -   Before Java 9, we couldn't use outside resource in the try() for auto closure.
 *  3.  Private methods in interface are allowed for helping methods.
 *  4.  Underscore as variable name is not allowed anymore :
 *          String _ = "underscore";
 *  5.  dateUntil() in Date/Time API:
 */
public class E005_LanguageImprovements {
    public static void main(String[] args) throws IOException {
        diamondOperatorExample();
        tryWithResourceExample();
        dateUntilExample();
    }

    private static void dateUntilExample() {
        LocalDate start = LocalDate.of(2017, 12, 1);
        Stream<LocalDate> dates = start.datesUntil(start.plusDays(3));
        dates.forEach(System.out::println);

        LocalDate birthday = LocalDate.of(1992, 10, 27);
        long leapYears = birthday
                .datesUntil(LocalDate.now(), Period.ofYears(1))
                .map(d -> Year.of(d.getYear()))
                .filter(Year::isLeap)
                .count();
        System.out.printf("%d leap years since Tarun was born on %s", leapYears, birthday);
    }

    private static void diamondOperatorExample() {
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>() {
            @Override
            public boolean add(String s) {
                System.out.println("Adding " + s);
                return super.add(s);
            }
        };
    }

    private static void tryWithResourceExample() throws IOException {
        // Java 7/8
        try (FileInputStream fis = new FileInputStream("/Users/tarun/.zshrc")) {
            fis.read();
        }

        // Java 7/8
        // fis = null; // Re-assignment makes fis not 'effectively final'
        FileInputStream fis1= null;
        try (FileInputStream fis2 = fis1) {
            fis2.read();
        }

        // Java 9
        FileInputStream fis2= null;
        // Only if fis is 'effectively final', can this form be used
        try (fis2) {
            fis2.read();
        }
    }
}

interface PricedObject {
    // Private fields are not allowed
    // private double TAX = 1.21;

    double getPrice();

    default double getPriceWithTax() {
        return getTaxedPriceInternal();
    }

    default double getOfferPrice(double discount) {
        return getTaxedPriceInternal() * discount;
    }
    // Allowed in Java 9
    private double getTaxedPriceInternal() {
        return getPrice() * getTax();
    }

    private static double getTax() {
        return 1.21;
    }

    /* Before private interface methods, shared logic could not be extracted into a
       new method (at least not without it becoming part of the public API).
    default double getPriceWithTax() {
        return getPrice() * 1.21;
    }
    default double getOfferPrice(double discount) {
        return getPrice() * 1.21 * discount;
    }
    */
}