package com.learning;


import java.io.IOException;

/**
 *  Compile:
 *  -------
 *      javac --add-exports java.base/sun.security.x509=ALL-UNNAMED
 *      classpath-problems/src/com/learning/P001_EncapsulatedTypes.java
 *
 *  Internal Info:
 *  -------------
 *  jdeps -jdkinternals classpath-problems/src/com/learning/P001_EncapsulatedTypes.class
 */
public class P001_EncapsulatedTypes {
    public static void main(String[] args) throws IOException {
        //sun.security.x509.X500Name name = new sun.security.x509.X500Name("CN=user");
    }
}
