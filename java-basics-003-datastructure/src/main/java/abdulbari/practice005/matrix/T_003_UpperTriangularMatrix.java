package abdulbari.practice005.matrix;

import java.util.*;

 /**
  * Upper Triangular Matrix:
  * -----------------------
  * ->  Upper Triangular Matrix is defined as below:
  *		    M[i,j]=0 where i>j
  *		i.e. only upper triangular elements are non-zero.
  *	->	How many non zero elements :
  * 		1+2+3+....+n = n(n+1)/2
  * ->	How many zero elements :
  * 		n^2 - n(n+1)/2 = n(n-1)/2
  *
  *	Row Major Mapping:
  *	-----------------
  *		Index(A[i][j]) = [n + (n-1) + (n-2) + ... + n-(i-2)] + (j-i)
  *					   = [n(i-1) - (i-2)(i-1)/2] + (j-i)
  *
  *	Column Major Mapping:
  *	--------------------
  *		Index(A[i][j]) = [j*(j-1)/2] + (i-1)
  */
public class T_003_UpperTriangularMatrix{
	private final int n;
    private final int[] array;
    
    public T_003_UpperTriangularMatrix(int n){
        this.n = n;
        array = new int[n*(n+1)/2];
    }
    
    public void setValue(int i, int j, int value){
        if( i >= j ){
            array[i*(i-1)/2 + (j-1)] = value;
        }
    }
    
    public int getValue(int i, int j){
        if(i == j){
            return array[i*(i-1)/2 + (j-1)];
        }
        return 0;
    }
    
    public void display(){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i>=j){
                    System.out.print(array[i*(i-1)/2 + (j-1)]+" ");
                } else {
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) { 
        T_003_UpperTriangularMatrix s  = new T_003_UpperTriangularMatrix(4);
        s.setValue(1,1,3);
		s.setValue(2,1,3);
        s.setValue(2,2,3);
		s.setValue(3,1,3);
		s.setValue(3,2,3);
        s.setValue(3,3,3);
		s.setValue(4,1,3);
		s.setValue(4,2,3);
		s.setValue(4,3,3);
        s.setValue(4,4,3);
        s.display();
    }
}