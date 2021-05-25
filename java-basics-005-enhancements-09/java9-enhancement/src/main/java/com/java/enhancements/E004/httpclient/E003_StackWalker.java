package com.java.enhancements.E004.httpclient;

import java.util.List;
import java.util.stream.Collectors;

public class E003_StackWalker {

    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        method2();
    }

    public static void method2() {
        method3();
    }

    public static void method3() {
        method4();
    }

    public static void method4() {
        StackWalker walker = StackWalker.getInstance();
        walker.forEach(System.out::println);
        List<Integer> lines = walker.walk(stackStream ->
                            stackStream.filter(f -> f.getMethodName().startsWith("m"))
                                        .map(StackWalker.StackFrame::getLineNumber)
                                        .collect(Collectors.toList())
        );

        lines.forEach(System.out::println);
    }
}
