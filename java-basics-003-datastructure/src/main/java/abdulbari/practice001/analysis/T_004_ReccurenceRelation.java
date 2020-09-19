package abdulbari.practice001.analysis;

/**
 *  ->  A recurrence is an equation or inequality that describes a function in terms of its values
 *      on smaller inputs. To solve a Recurrence Relation means to obtain a function defined on the
 *      natural numbers that satisfy the recurrence.
 *      Example, the Worst Case Running Time T(n) of the MERGE SORT Procedures is described by the recurrence:
 *          T (n) = ? (1)       if n=1
 *          2T(n/2) + ? (n)     if n>1
 *
 *  ->  There are four methods for solving Recurrence:
 *      1.  Substitution Method :
 *          -------------------
 *          -   The Substitution Method Consists of two main steps:
 *              a.  Guess the Solution.
 *              b.  Use the mathematical induction to find the boundary condition and shows that
 *                  the guess is correct.
 *          -   Example: Solve the equation by Substitution Method.
 *                          T (n) = T(n/2) + n
 *                       We have to show that it is asymptotically bound by O (log n).
 *              Solution:
 *                      For T (n) = O (log n)
 *                      We have to show that for some constant c,
 *                          T (n) ?c*logn.
 *                      Put this in given Recurrence Equation.
 *                          T (n) ?c*log(n/2)+ 1
 * 			                      ?c*log(n/2)+ 1 = c logn-clog(2+1)
 * 			                      ?c*logn for c?1
 *                      Thus T (n) =O(logn).
 *      2.  Iteration Methods:
 *          -----------------
 *          -   It means to expand the recurrence and express it as a summation of terms of n and
 *              initial condition.
 *          -   Example: Consider the Recurrence
 *                      T (n) = 1           if n=1
 *                            = 2T (n-1)    if n>1
 *              Solution:
 *                      T (n) = 2T(n-1)
 *                            = 2[2T(n-2)] = (2^2)T(n-2)
 *                            = 4[2T(n-3)] = (2^3)T(n-3)
 *                            = 8[2T(n-4)] = (2^4)T(n-4)
 *
 *                      Repeat the procedure for i times
 *                              T(n) = (2^i)T(n-i)
 *                      Put n-i=1 or i= n-1 in    (Eq.1)
 *                              T(n) = (2^(n-1))T(1)
 *                                   = (2^(n-1))*1    {T(1) =1 .....given}
 *                                   = 2^(n-1)
 *      3.  Recursion Tree Method
 *          ---------------------
 *          -   Recursion Tree Method is a pictorial representation of an iteration method which is
 *              in the form of a tree where at each level nodes are expanded.
 *          -   In general, we consider the second term in recurrence as root.
 *          -   It is useful when the divide & Conquer algorithm is used.
 *          -   It is sometimes difficult to come up with a good guess. In Recursion tree, each root
 *              and child represents the cost of a single sub-problem.
 *          -   We sum the costs within each of the levels of the tree to obtain a set of pre-level
 *              costs and then sum all pre-level costs to determine the total cost of all levels of
 *              the recursion.
 *          -   A Recursion Tree is best used to generate a good guess, which can be verified by the
 *              Substitution Method.
 *
 *      4.  Master's Theorem:
 *          -   In the next chapter.
 */
public class T_004_ReccurenceRelation {
}
