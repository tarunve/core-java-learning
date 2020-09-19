package abdulbari.practice001.analysis;

/**
 *  Asymptotic Notations:
 *  ====================
 *  ->  Asymptotic Notations are the expressions that are used to represent the complexity of an algorithm.
 *  ->  Best Case:  In which we analyse the performance of an algorithm for the input, for which the algorithm
 *                  takes less time or space.
 *  ->  Worst Case: In which we analyse the performance of an algorithm for the input, for which the algorithm
 *                  takes long time or space.
 *  ->  Average Case: In which we analyse the performance of an algorithm for the input, for which the algorithm
 *                    takes time or space that lies between best and worst case.
 *
 *  Types of Asymptotic Notation:
 *  ============================
 *  1.  Big-O Notation (?) :
 *      -   Big O notation specifically describes worst case scenario. It represents the upper bound running
 *          time complexity of an algorithm.
 *      -   The function f(n) = O(g(n)) if - there exists +ve constants c and n0(n-node)
 *              such that f(n) <= c*g(n) , for all n>n0
 *      -   Example : f(n) = 2n+3
 *              for this , f(n) = O(n) , O(n^2), O(n^3) all are true but O(logn) is not true.
 *  2.  Omega Notation (?)
 *      -   Omega notation specifically describes best case scenario. It represents the lower bound running
 *          time complexity of an algorithm. So if we represent a complexity of an algorithm in Omega notation,
 *          it means that the algorithm cannot be completed in less time than this, it would at-least take the
 *          time represented by Omega notation or it can take more (when not in best case scenario).
 *      -   The function f(n) = ?(g(n)) if - there exists +ve constants c and n0(n-node)
 *              such that f(n) >= c*g(n) , for all n>n0
 *      -   Example : f(n) = 2n+3
 *              for this , f(n) = ?(n) , ?(logn) all are true but ?(n^2) is not true.
 *  3.  Theta Notation (?)
 *      -   This notation describes both upper bound and lower bound of an algorithm so we can say that it
 *          defines exact asymptotic behaviour. In the real case scenario the algorithm not always run on
 *          best and worst cases, the average running time lies between best and worst and can be represented
 *          by the theta notation.
 *      -   The function f(n) = ?(g(n)) if - there exists +ve constants c1, c2 and n0(n-node)
 *              such that c1*g(n) <= f(n) <= c2*g(n)
 *      -   Example : f(n) = 2n+3
 *              1*n <= 2n+3 <= 5*n
 *              O(n)            O(n)
 *              f(n) = ?(n) is true only.
 *
 *  ->  Don't confuse these notations with Best case or worst case. We can write any notation for
 *      best case, worst case and average case.
 *
 *  Properties of Asymptotic Notation:
 *  =================================
 *  1.  General Property :
 *      -   if f(n) is ?(g(n)) then a*f(n) is ?(g(n))
 *          Example : f(n) = 2n^2+5  is ?(n^2)
 *                  then 7*f(n) = 14n^2+35 is also ?(n^2)
 *      -   This property is same for all three notations.
 *  2.  Reflexive Property:
 *      -   if f(n) is given then f(n) is O(f(n)).
 *          Example :   f(n) = n^2  then it is O(n^2)
 *      -   This property is same for all three notations.
 *  3.  Transitive Property:
 *      -   if f(n) is O(g(n)) and g(n) is O(h(n)) then f(n) = O(h(n))
 *          Example:    f(n) = n, g(n) = n^2 , h(n) = n^3
 *                  i.e.   n is (n^2) and n^2 is O(n^3) then n is O(n^3)
 *      -   This property is same for all three notations.
 *  4.  Symmetric Property:
 *      -   This property is only true for Theta notation.
 *      -   if f(n) is ?(g(n) then g(n) is ?(f(n)
 *          Example : f(n) = n^2 , g(n) = n^2
 *                  then f(n) = ?(n^2) , g(n) = ?(n^2)
 *  5.  Transpose property:
 *      -   if f(n) is O(g(n) then g(n) is ?(f(n)
 *          Example : f(n) = n , g(n) = n^2
 *                  then n is O(n^2) and n^2 is ?(n)
 *  6.  if f(n) = O(g(n)) and f(n) = ?(g(n))
 *          i.e g(n) <= f(n) <= g(n)
 *          then f(n) = ?(g(n)
 *  7.  if f(n) = O(g(n)) and d(n) = O(e(n))
 *          then f(n) + d(n) = O(max(g(n), e(n)))
 *  8.  if f(n) = O(g(n)) and d(n) = O(e(n))
 *          then f(n) * d(n) = O(g(n)*e(n))
 *
 *  True or False
 *  =============
 *  1.  (n+k)^m = ?(n^m)                            ==> TRUE
 *  2.  2^(n+1) = O(2^n)    ==> 2*2^n = O(2^n)      ==> TRUE
 *  3.  2^2n = O(2^n)       ==> 4^n > 2^n           ==> FALSE
 *  4.  (logn)^1/2 = O(loglogn)                     ==> FALSE
 *  5.  n^logn = O(2^n)     ==> logn*logn = nlog2   ==> TRUE
 */
public class T_003_AsymptoticNotation {}
