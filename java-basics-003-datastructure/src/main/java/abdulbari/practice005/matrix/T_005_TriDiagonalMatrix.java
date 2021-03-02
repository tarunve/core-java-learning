package abdulbari.practice005.matrix;

import java.util.*;

/**
 *	Tri-Diagonal Matrix
 * 	-------------------
 * 	->	M[i,j] = non-zero if |i-j| <= 1 
 * 		M[i,j] = 0 if  |i-j| > 1
 *	->	Elements in main diagonal , i-j = 0
 *		Elements in lower diagonal , i-j = 1
 *		Elements in upper diagonal , i-j = -1
 * 	->	Number of non-zero elements = n + (n-1) + (n-1) = 3n-2
 *	
 *	Store elements in single dimension array and below are the index access formulae:
 *	->	Index(A[i][j])
 *		->	Case 1 : 
 *				if (i-j)=1 i.e. lower diagonal , index = i-1 
 *		->	Case 2 : 
 *				if (i-j)=0 i.e. main diagonal , index = (n-1) + i-1
 *		->	Case 3 : 
 *				if (i-j)=-1 i.e. upper diagonal , index = (2n-1) + i-1
 */
public class T_005_TriDiagonalMatrix{
	
}