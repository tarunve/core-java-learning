package com.learning;

import javax.xml.bind.DatatypeConverter;

/**
 *  Compile:
 *      javac --module-path lib --add-modules java.xml.bind
 *      classpath-problems/src/com/learning/P002_NonDefaultJavaSEModule.java
 */
public class P002_NonDefaultJavaSEModule {

    public static void main(String[] args) {
        DatatypeConverter.parseBase64Binary("SGVsbG8gd29ybGQh");
    }
}
