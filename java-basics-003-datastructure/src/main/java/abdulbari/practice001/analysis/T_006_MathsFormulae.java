package abdulbari.practice001.analysis;

/**
 *  ->  Sum of first n natural numbers :
 *          Sum = n(n+1)/2
 *  ->  Sum of squares of first n^2 natural numbers :
 *          Sum = n(n+1)(2n+1)/6
 *  ->  Sum of cube of first n^2 natural numbers :
 *          Sum = n^2(n+1)^2/4
 *
 *  Arithmetic Progression(AP):
 *  ======================
 *  -   The progression of the form: a, a + d, a + 2d, a + 3d … is known as an AP with
 *      first term = a,and common difference = d.
 *  -   In an AP a, a + d, a + 2d, a + 3d, …, we have:
 *      1.  nth term,
 *          T(n) = a + (n – 1)d
 *      2.  Sum to n terms,
 *              S(n) = n/2[2a+(n-1)d] = n/2(a+l)    , where l is last term
 *      3.  If a, b, c are in AP, then b is called with arithmetic mean (AM) between a and c.
 *          In this case, b = 1/2(a+c)
 *      4.  If a, a1, a2 … an, b are in AP we say that a1, a2 … an are the n arithmetic means
 *          between a and b
 *      5.  It is convenient to take:
 *              three numbers in AP as (a – d), a, (a + d)
 *              four numbers in AP as (a – 3d), (a – d), (a + d), (a + 3d)
 *
 *  Geometric Progression (GP)
 *  =========================
 *  -   The progression of the form: a, ar, ar^2, ar^3, … is known as a GP with first term = a
 *      and common ratio = r.
 *      1.  nth term,
 *              T(n) = ar^(n– 1)
 *      2.  Sum to n terms,
 *              S(n) = a(r^n-1) / (r-1)     when r<1
 *                   = a(r^n-1) / (r-1)     when r>1
 *      3.  If a, b, c are in GP, then b is the geometric mean (GM) between a and c.
 *          In this case, b= ?ab .
 *      4.  If a, a1, a2 … an, b are in GP we say that a1, a2 …an are n geometric means between a and b.
 *      5.  The sum of an infinite GP a, ar, ar^2… is
 *              Sum = a/(1-r)
 *
 *  Harmonic Progression (HP)
 *  =========================
 *  -   The progression a1, a2, a3… is called an HP if
 *          1/a1 , 1/a2 , 1/a3, ..... ia an HP.
 *  -   If a, b, c are in HP, then b is the harmonic mean between a and c.
 *      In this case, b =   2ac/(a+c)
 *
 *
 *  Relationship Between the Means of AP, GP and HP
 *  ===============================================
 *      AM*HM = GM^2
 */
public class T_006_MathsFormulae {
}
