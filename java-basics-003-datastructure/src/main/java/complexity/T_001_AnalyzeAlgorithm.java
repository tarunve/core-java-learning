package complexity;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Two main criteria for analyzing algorithms:
 *  ------------------------------------------
 *  1.  Time
 *  2.  Space
 *  3.  N/W - Data Transfer can also be a criteria (considering cloud etc.)
 *  4.  Power Consumption
 *  5.  CPU Registers Consumption
 *
 */
public class T_001_AnalyzeAlgorithm {

    private static final Logger LOGGER = Logger.getLogger(T_001_AnalyzeAlgorithm.class.getName());

    // f(n) = 3 (constant)
    // S(n) = 3 (constant)
    public static void swapFunction(int a, int b){
        int temp = a;
        a = b;
        b = temp;
        LOGGER.log(Level.SEVERE, String.format("a : %d , b : %d", a, b));
    }

    // f(n) = 2n+3 = O(n)
    // S(n) = n+3 = O(n)
    public static void sumCalculation(int[] a, int n){
        int sum = 0;
        for (int i=0; i<n; i++){
            sum += a[i];
        }
        LOGGER.log(Level.SEVERE, "Sum : {} " , sum);
    }

    // f(n) = (n+1)+ n*(n+1) + n*n = 2n^2 + 2n + 1 = O(n^2)
    // S(n) = 3n^2+ 2 = O(n^2)
    public static void sumCalculation(int[][] a, int[][] b){
        int[][] c = new int[a.length][b.length];
        for (int i=0; i< a.length; i++){
            for (int j=0; j<b.length; j++) {
                c[i][j]= a[i][j] + b[i][j];
            }
        }
        LOGGER.log(Level.SEVERE, "Result Array : {} " , c);
    }

    // f(n) = 2n^3 + 3n^2 + 2n + 1 = O(n^3)
    // S(n) = 3n^2+ 4 = O(n^2)
    public static void multiply(int[][] a, int[][] b, int[][] c, int n){
        for (int i=0; i< n; i++){
            for (int j=0; j<n; j++) {
                c[i][j] = 0;
                for (int k=0; k<n; k++) {
                    c[i][j] = c[i][j] + a[i][j]*b[i][j];
                }
            }
        }
        LOGGER.log(Level.SEVERE, "Result Array : {} " , c);
    }

    // f(n) = (n+1) + n/2 = O(n)
    // S(n) = 2
    public static void logTime(int n){
        for (int i=0; i<n; i=i+2){
            LOGGER.log(Level.SEVERE, String.valueOf(i));
        }
    }

    // f(n) = (n+1) + (0+1+2+3+....+n) = (n^2+3n+2)/2 = O(n^2)
    // S(n) = 3
    public static void logTimeNew(int n){
        for (int i=0; i<n; i++){
            for (int j=0; j<i; j++) {
                LOGGER.log(Level.SEVERE, String.valueOf(i));
            }
        }
    }

    /**
     *  Assume p>n (for loop to be end)
     *      i.e p = k(k+1)/2
     *          k(k+1)/2 > n
     *          k^2 > n
     *          k > root(n)
     *  T(n) = O(root(n))
     */
    public static void rootNTime(int n){
        int p = 0;
        for (int i=0; i<n; i++){
            p = p+i;
        }
    }

    /**
     *  For n=8, log8 = 3
     *      n=10, log10 = 3.2
     *
     *  T(n) = ceil(logn) => upper bound
     */
    public static void ceil(int n){
        int p = 0;
        for (int i=0; i<n; i=i*2){
            p = p+i;
        }
    }

    /**
     *  Assume i<1 (for loop to be end)
     *          and i = n/2^k
     *          n/2^k < 1
     *          n/2^k = 1
     *          n = 2^k
     *          k = logn (base 2)
     *   T(n) = O(logn)
     */
    public static void divideLogN(int n){
        int p = 0;
        for (int i=n; i>=1; i=i/2){
            p = p+i;
        }
    }

    /**
     *  Assume i*i >= n (for loop to be end)
     *      i^2 = n
     *      i = root(n)
     *   T(n) = O(root(n))
     */
    public static void floor(int n){
        for (int i=0; i*i < n; i++){
            LOGGER.log(Level.SEVERE, String.valueOf(i));
        }
    }
}
