package abdulbari.practice002.reccurence;

public class T_006_Problems_1 {

    public static void main(String[] args) {
        System.out.print("Sum from all three ways :: ");
        System.out.print(sumNaturalNumbersRecursive(5) + " ");
        System.out.print(sumNaturalNumbersIterative(5) + " ");
        System.out.println(sumNaturalNumbersFormulae(5));

        System.out.print("Factorial from recursive and iterative method :: ");
        System.out.print(factorialNaturalNumbersRecursive(16) + " ");
        System.out.println(factorialNaturalNumbersIterative(15) + " ");

        System.out.print("Power from recursive and iterative method :: ");
        System.out.print(powerRecursive(2,9) + " ");
        System.out.print(powerRecursiveFaster(2,9) + " ");
        System.out.println(powerIterative(2,9) + " ");

    }

    /*
     *  ->  Sum of first N natural numbers
     *  ->  Recursion - T(n) , S(n)
     *      Iterative - T(n) , S(1)
     *      Formulae  - T(1) , S(1)
     */
    private static int sumNaturalNumbersRecursive(int n){
        if(n==0){
            return 0;
        } else {
            return sumNaturalNumbersRecursive(n-1) + n;
        }
    }

    private static int sumNaturalNumbersIterative(int n){
        int i, s=0;
        for(i=1; i<=n; i++){
            s = s+i;
        }
        return s;
    }

    private static int sumNaturalNumbersFormulae(int n){
        return n*(n+1)/2;
    }

    /*
     *  ->  Factorial of first N natural numbers
     *  ->  Recursion - T(n) , S(n)
     *      Iterative - T(n) , S(1)
     */
    private static int factorialNaturalNumbersRecursive(int n){
        if(n==0){
            return 1;
        }
        return factorialNaturalNumbersRecursive(n-1) * n;
    }

    private static int factorialNaturalNumbersIterative(int n){
        int i;
        int f=1;
        for(i=1; i<=n; i++){
            f = f*i;
        }
        return f;
    }

    /*
     *  ->  Exponent of m^n
     *  ->  Recursion - T(n) , S(n)
     *      Iterative - T(n) , S(1)
     */
    private static int powerRecursive(int m, int n){
        if(n==0){
            return 1;
        }
        return powerRecursive(m,n-1) * m;
    }

    private static int powerRecursiveFaster(int m, int n){
        if(n==0){
            return 1;
        }
        if(n%2 == 0){
            return powerRecursiveFaster(m*m, n/2);
        } else {
            return m*powerRecursiveFaster(m*m, (n-1)/2);
        }
    }

    private static int powerIterative(int m, int n){
        int i;
        int r=1;
        for(i=1; i<=n; i++){
            r = r*m;
        }
        return r;
    }
}
