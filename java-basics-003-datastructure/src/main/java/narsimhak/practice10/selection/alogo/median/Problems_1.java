package practice10.selection.alogo.median;

public class Problems_1 {
	
	/*
	 * 	Given two arrays each containing n sorted elements, give an O(logn)-time algorithm to 
	 * 	find the median of all 2n elements.
	 */
	public double findMedianSortedArrays(int[] arrA, int[] arrB){
		int n1= arrA.length;
		int n2= arrB.length;
		if((n1+n2) % 2 == 0){
			double r1 = (double)findMedianSortedArrays(arrA, 0, n1, arrB, 0, n2, (n1+n2)/2);
			double r2 = (double)findMedianSortedArrays(arrA, 0, n1, arrB, 0, n2, (n1+n2)/2 +1);
			return (r1+r2)/2;
		} else{
			return findMedianSortedArrays(arrA, 0, n1, arrB, 0, n2, (n1+n2+1)/2);
		}
	}

	private double findMedianSortedArrays(int[] arrA, int startA, int endA, int[] arrB, int startB, int endB, int k) {
		int n = endA-startA;
		int m = endB-startB;
		if(n <= 0)
			return arrB[startB+k-1];
		if(m <= 0)
			return arrA[startA+k-1];
		if(k == 1)
			return arrA[startA] < arrB[startB] ? arrA[startA] : arrB[startB];
			
		int midA = (startA+endA)/2;
		int midB = (startB+endB)/2;
		if(arrA[midA] <= arrB[midB]){
			if(n/2 + m/2 + 1 >= k)
				return findMedianSortedArrays(arrA, startA, endA, arrB, startB, midB, k);
			else
				return findMedianSortedArrays(arrA, midA+1, endA, arrB, startB, endB, k-n/2-1);
		} else{
			if(n/2 + m/2 + 1 >= k)
				return findMedianSortedArrays(arrA, startA, midA, arrB, startB, endB, k);
			else
				return findMedianSortedArrays(arrA, startA, endA, arrB, midB+1, endB, k-n/2-1);
		}
		
	}
}
