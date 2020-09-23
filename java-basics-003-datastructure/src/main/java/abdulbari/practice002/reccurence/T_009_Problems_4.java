package abdulbari.practice002.reccurence;

/**
 *  Towers of Hanoi Problem
 */
public class T_009_Problems_4 {

    public static void main(String[] args) {
        towerOfHanoi(6, 1 , 2 ,3);
    }

    // T(n) = 2^(n) - 1 = O(2^n)
    private static void towerOfHanoi(int n, int a, int b , int c){
        if(n>0){
            towerOfHanoi(n-1, a, c, b);
            System.out.println(String.format("Move disk from %d to %d", a, c));
            towerOfHanoi(n-1, b, a, c);
        }
    }
}
