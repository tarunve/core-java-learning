package abdulbari.practice001.analysis;

/**
 *      T(n) = T(n-1) + 1 = O(n)
 *      T(n) = T(n-1) + n = O(n^2)
 *      T(n) = T(n-1) + logn = O(nlogn)
 *      T(n) = 2T(n-1) + 1 = O(2^n)
 *      T(n) = 3T(n-1) + 1 = O(3^n)
 *      T(n) = 2T(n-1) + n = O(n2^n)
 *
 *  Master Theorem for Decreasing Functions:
 *  ---------------------------------------
 *  ->  Master Theorem is used to determine running time of algorithms in terms of asymptotic notations.
 *  ->  General form :
 *          T(n) = aT(n-b) + n^k
 *              where a>0, b>0 and f(n) = O(n^k) where k>=0
 *  ->  Three cases:
 *      1.  if a<1 , T(n) = O(n^k) = O(f(n))
 *          Example:
 *                  T(n)=0.5T(n-1) + n
 *                  so here a=0.5<1 thus by applying case 1 we get T(n) = O(n) (because f(n) = n)
 *      2.  If a=1 , T(n) = O(n^(k+1)) or simply T(n) = O(n*f(n)).
 *          Example:
 *                  T(n)=T(n-1) + n^2
 *                  so here a=1 , k=2 thus by applying case 2 we get T(n) = O(n^3) (because f(n) = n^2)
 *      3.  If a>1 , T(n) = O(a^(n/b) * n^k) or simply O(a^(n/b) * f(n))
 *          Example:
 *                  T(n)=2T(n-1) + n^2
 *                  so here a=2 ,b=1, f(n)=n^2 thus by applying case 3 we get T(n) = O(2^n * n^2)
 *
 *  Master theorem for Dividing functions :
 *  --------------------------------------
 *  ->  Dividing functions can be defined as T(n) = T(n/2) + c, T(n)=2T(n/2)+logn, etc.
 *  ->  The general form for the dividing functions :
 *          T(n) = aT(n/b) + Theta(n^k * (logn)^p)
 *              where a and b are constants. a>=1, b>1 and f(n) can be expressed as O(n^k * (logn)^p)
 *                    a = Number of sub-problems
 *                    b = The cost of dividing and merging the sub-problems
 *  ->  To find the time complexity for these kinds of functions again there are 3 cases. Here we have
 *      to find two things
 *      1. loga (base b)
 *      2. k
 *  ->  Three Cases:
 *      1.  If a > b^k then T(n) = Theta(n^loga).
 *      2.  if a = b^k, then
 *              (a) if p > -1, then T(n) = Theta(n^(loga) * (logn)^(p+1))
 *              (b) if p = -1, then T(n) = Theta(n^(loga) * loglogn)
 *              (c) if p < -1, then T(n) = Theta(n^(loga))
 *      3.  if a < b^k, then
 *              (a) if p >= 0, then T(n) = Theta(n^k * (logn)^p)
 *              (b) if p < 0, then T(n) = Theta(n^k)
 */
public class T_005_MastersTheorem {}
