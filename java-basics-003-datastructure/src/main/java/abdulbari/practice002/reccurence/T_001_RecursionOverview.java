package abdulbari.practice002.reccurence;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Recursive Function:
 *  ------------------
 *  -   Function calling itself is called as Recursive function.
 *  -   Inside Recursive function , there must be some condition where it will end.
 *      Example:
 *              private void function(int n){
 *                  if(n>0){
 *                      System.out.println("n");
 *                      function(n-1);
 *                  }
 *              }
 *
 */
public class T_001_RecursionOverview {

    private static final Logger LOGGER = Logger.getLogger(T_001_RecursionOverview.class.getName());

    public static void main(String[] args) {
        int x=3;
        function1(x);
    }

    /**
     *  ->  Tail Recursion - function call is last line
     *  ->  Better to write loop instead of tail recursion as recursion uses stack for it
     *      and loop will be efficient in terms of space.
     *  ->  Linear Recursion as function is being called only once
     */
    //  T(n) = O(n) , S(n) = O(n)
    private static void function1(int n) {
        if(n>0){
            LOGGER.log(Level.SEVERE, String.valueOf(n));
            function1(n-1);
        }
    }
    //  T(n) = O(n) , S(n) = O(1)
    private static void function1Loop(int n) {
        while(n>0){
            LOGGER.log(Level.SEVERE, String.valueOf(n));
            n--;
        }
    }

    /**
     *  ->  Head recursion - function call is the first line
     *  ->  Better to write loop instead of head recursion as recursion uses stack for it
     *      and loop will be efficient in terms of space.
     *  ->  Linear Recursion as function is being called only once
     */
    // T(n) = O(n) , S(n) = O(n)
    private static void function2(int n) {
        if(n>0){
            function1(n-1);
            LOGGER.log(Level.SEVERE, String.valueOf(n));
        }
    }
    //  T(n) = O(n) , S(n) = O(2)
    private static void function2Loop(int n) {
        int i=1;
        while(i<=n){
            LOGGER.log(Level.SEVERE, String.valueOf(i));
            i++;
        }
    }

}
