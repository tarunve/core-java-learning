package abdulbari.practice002.reccurence;

public class T_008_Problems_3 {

    private static int f[] = new int[11];

    public static void main(String[] args) {
        System.out.print("Fibonicci Sum :: ");
        System.out.print(fibRecursive(10) + " ");
        System.out.print(fibIterative(10) + " ");
        for(int i=0; i<11 ; i++){
            f[i] = -1;
        }
        System.out.println(fibMemoization(10) + " ");

        System.out.print("Combination :: ");
        System.out.print(combFormulae(4, 2) + " ");
        System.out.println(combRecursive(4, 2) + " ");
    }

    /**
     *  Fibonicci Series:
     *      1 1 2 3 5 8 13 .... n terms
     *      f(n) =  0                       ,   n=0
     *           =  1                       ,   n=1
     *           =  fib(n-1) + fib(n-2)     ,   n>1
     *
     *  ->  Memoization : Store the variable value so that next call is not made if value is known.
     */
    // T(n) = 2^n
    public static int fibRecursive(int n) {
        if(n<=1){
            return n;
        }
        return fibRecursive(n-1) + fibRecursive(n-2);
    }
    // T(n) = 4n => O(n)
    public static int fibIterative(int n) {
        int i , s=0;
        int t0 = 0;
        int t1 = 1;
        if(n<=1){
            return n;
        }
        for(i=2; i<=n ; i++){
            s = t0 + t1;
            t0 = t1;
            t1 = s;
        }
        return s;
    }
    // T(n) = O(n)
    public static int fibMemoization(int n) {
        if(n<=1){
            f[n] = n;
            return n;
        } else {
            if(f[n-2] == -1) {
                f[n - 2] = fibMemoization(n - 2);
            }
            if(f[n-1] == -1) {
                f[n - 1] = fibMemoization(n - 1);
            }
            return f[n-2] + f[n-1];
        }
    }

    /*
     *  Combination :
     *      nCr = n! / r! * (n-r)!
     */
    private static int fact(int n){
        if(n==0) {
            return 1;
        }
        return fact(n-1)*n;
    }

    private static  int combFormulae(int n , int r){
        int num, dem;
        num = fact(n);
        dem = fact(r) * fact(n-r);
        return num/dem;
    }

    private static  int combRecursive(int n , int r){
        if( r==0 || n==r){
            return 1;
        } else {
            return combRecursive(n-1, r-1) + combRecursive(n-1 , r);
        }
    }
}
