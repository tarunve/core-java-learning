package abdulbari.practice002.reccurence;

/**
 *  Taylor's Series:
 *  ---------------
 *      e^x = 1 + x/1 + x^2/2! + x^3/3! + x^4/4! + .... +  n terms
 *          sum(n) = 1+2+3+4+...+n          =   sum(n-1)*n
 *          fact(n) = 1*2*3*4*...*n         =   fact(n-1)*n
 *          pow(x,n) = x*x*x*...*n times    =   pow(x, n-1)*n
 */
public class T_007_Problems_2 {

    public static void main(String[] args) {
        System.out.println(expRecursive(1,10));
        System.out.println(expHornerRule(1,10));
        System.out.println(expIterative(1,10));
    }

    // Using Recursion
    // T(n) = O(n^2)
    private static double expRecursive(int x, int n){
        double p=1, f=1, r;
        if(n == 0){
            return 1;
        } else {
            r = expRecursive(x, n-1);
            p = p*x;
            f = f*n;
            return r + p/f;
        }
    }

    //Using Horner's Rule
    // T(n) = O(n)
    private static double expHornerRule(int x, int n){
        double s=1;
        if(n == 0){
            return s;
        }
        s = 1+x*s/n;
        return expHornerRule(x, n-1);
    }

    private static double expIterative(int x, int n){
        double s=1;
        int i;
        double num=1;
        double dem=1;

        for (i=1; i<=n; i++){
            num *= x;
            dem *= i;
            s += num/dem;
        }

        return s;
    }
}
