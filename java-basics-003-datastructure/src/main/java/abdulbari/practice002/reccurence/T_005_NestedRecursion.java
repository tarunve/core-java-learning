package abdulbari.practice002.reccurence;

/**
 *  ->  Recursive call is taking recursive call as parameter - Nested Recursion.
 */
public class T_005_NestedRecursion {

    public static void main(String[] args) {
        System.out.println(function(76));
    }

    private static int function(int n){
        System.out.println("Function Call with n : " + n);
        if(n>100) {
            return n - 10;
        }
        return function(function(n+11));
    }
}
