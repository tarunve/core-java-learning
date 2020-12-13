package interview.java.core.oops;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *  Java 7 enhancement:
 *  ==================
 *  -   We can write try block with resources.
 *  -   We won't need to close the resource as it will implement AutoClosable interface.
 *  -   If we don't write the catch block for handling the exception , it needs to be
 *      added to the method signature for checked exception.
 *
 *  Finally and catch blocks are quite different:
 *  --------------------------------------------
 *  -   Within the catch block you can respond to the thrown exception. This block is
 *      executed only if there is an unhandled exception and the type matches the one
 *      or is subclass of the one specified in the catch block's parameter.
 *  -   Finally will be always executed after try and catch blocks whether there is an
 *      exception raised or not.
 */
public class Q_004_TryWithoutCatch {

    public static class ResourceManagementInJava7 {
        public static void main(String[] args) throws IOException {
            try (BufferedReader br = new BufferedReader(new FileReader("file3.txt"))) {
                String sCurrentLine;
                while ((sCurrentLine = br.readLine()) != null) {
                    System.out.println(sCurrentLine);
                }
            } finally{
                System.out.println("finally block execution");
            }
        }
    }
}
