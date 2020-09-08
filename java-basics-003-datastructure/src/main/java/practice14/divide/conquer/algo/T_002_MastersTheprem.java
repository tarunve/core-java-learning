package practice14.divide.conquer.algo;

/**
 * 	->	In the D & C method, we solve the sub problems recursively. All problems are
 * 		generally defined in terms of recursive definitions. These recursive problems can easily be
 * 		solved using Master theorem. For details on Master theorem, refer to the Introduction to Analysis
 * 		of Algorithms chapter. Just for continuity, let us reconsider the Master theorem.
 * 	->	If the recurrence is of the form T(n) = aT(n/b) + Θ(n^k(log^pn)), 
 * 		where a >= 1, b > 1, k >= 0 and p is a real number, then the complexity can be directly given as:
 * 		1)	If a > b^k, then T(n) = Θ(n^logba)
 * 		2) 	If a = b^k
 * 			a.	If p > -1, then , Θ(n^logba*log^(p+1)n)
 * 			b. 	If p = -1, then , Θ(n^logba*loglogn)
 * 			c. 	If p < -1, then , Θ(n^logba)
 * 		3) 	If a< b^k
 * 			a. 	If p >= 0, then T(n) = Θ(n^klog^pn)
 * 			b. 	If p < 0, then T(n) = O(n^k)
 * 
 * 	Example :   T(n) = (2^1/2)T(n/2) + logn
 * 				=>	a=2^1/2 , b=2, k=0, p=1
 * 				=>	a>b^k  => 1(a)
 * 				=>	Θ(log2(2^1/2))
 * 				=>	Θ(n^1/2)
 */	
public class T_002_MastersTheprem {
	
}
