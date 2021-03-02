package abdulbari.practice005.matrix;

/**
 *  ->  Diagonal Matrix is defined as below :
 *          M[i,j]=0 where i!=j
 *      i.e. when only diagonal elements are non-zero elements.
 */

public class T_001_DiagonalMatrix {
    private final int n;
    private final int[] array;
    
    public T_001_DiagonalMatrix(int n){
        this.n = n;
        array = new int[n];
    }
    
    public void setValue(int i, int j, int value){
        if( i == j ){
            array[i-1] = value;
        }
    }
    
    public int getValue(int i, int j){
        if(i == j){
            return array[i-1];
        }
        return 0;
    }
    
    public void display(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    System.out.print(array[i]+" ");
                } else {
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        T_001_DiagonalMatrix s  = new T_001_DiagonalMatrix(4);
        s.setValue(1,1,3);
        s.setValue(2,2,3);
        s.setValue(3,3,3);
        s.setValue(4,4,3);
        s.display();
        System.out.println(s.getValue(2,2));
    }
}