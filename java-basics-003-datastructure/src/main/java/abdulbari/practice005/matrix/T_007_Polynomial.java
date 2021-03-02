package abdulbari.practice005.matrix;

/**
 *  The Polynomial class represents a polynomial with integer coefficients.
 *  Polynomials are immutable: their values cannot be changed after they
 *  are created.
 *  It includes methods for addition, subtraction, multiplication, composition,
 *  differentiation, and evaluation.
 */
public class T_007_Polynomial {
    private final int[] coef;   // coefficients p(x) = sum { coef[i] * x^i }
    private int degree;   // degree of polynomial (-1 for the zero polynomial)

    public T_007_Polynomial(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("exponent cannot be negative: " + b);
        }
        coef = new int[b+1];
        coef[b] = a;
        reduce();
    }

    private void reduce() {
        degree = -1;
        for (int i = coef.length - 1; i >= 0; i--) {
            if (coef[i] != 0) {
                degree = i;
                return;
            }
        }
    }

    public int degree() {
        return degree;
    }

    public T_007_Polynomial plus(T_007_Polynomial that) {
        T_007_Polynomial poly = new T_007_Polynomial(0, Math.max(this.degree, that.degree));
        for (int i = 0; i <= this.degree; i++) poly.coef[i] += this.coef[i];
        for (int i = 0; i <= that.degree; i++) poly.coef[i] += that.coef[i];
        poly.reduce();
        return poly;
    }

    public T_007_Polynomial minus(T_007_Polynomial that) {
        T_007_Polynomial poly = new T_007_Polynomial(0, Math.max(this.degree, that.degree));
        for (int i = 0; i <= this.degree; i++) poly.coef[i] += this.coef[i];
        for (int i = 0; i <= that.degree; i++) poly.coef[i] -= that.coef[i];
        poly.reduce();
        return poly;
    }

    public T_007_Polynomial times(T_007_Polynomial that) {
        T_007_Polynomial poly = new T_007_Polynomial(0, this.degree + that.degree);
        for (int i = 0; i <= this.degree; i++)
            for (int j = 0; j <= that.degree; j++)
                poly.coef[i+j] += (this.coef[i] * that.coef[j]);
        poly.reduce();
        return poly;
    }

    public T_007_Polynomial compose(T_007_Polynomial that) {
        T_007_Polynomial poly = new T_007_Polynomial(0, 0);
        for (int i = this.degree; i >= 0; i--) {
            T_007_Polynomial term = new T_007_Polynomial(this.coef[i], 0);
            poly = term.plus(that.times(poly));
        }
        return poly;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        T_007_Polynomial that = (T_007_Polynomial) other;
        if (this.degree != that.degree) return false;
        for (int i = this.degree; i >= 0; i--)
            if (this.coef[i] != that.coef[i]) return false;
        return true;
    }

    public T_007_Polynomial differentiate() {
        if (degree == 0) return new T_007_Polynomial(0, 0);
        T_007_Polynomial poly = new T_007_Polynomial(0, degree - 1);
        poly.degree = degree - 1;
        for (int i = 0; i < degree; i++)
            poly.coef[i] = (i + 1) * coef[i + 1];
        return poly;
    }

    public int evaluate(int x) {
        int p = 0;
        for (int i = degree; i >= 0; i--)
            p = coef[i] + (x * p);
        return p;
    }

    public int compareTo(T_007_Polynomial that) {
        if (this.degree < that.degree) return -1;
        if (this.degree > that.degree) return +1;
        for (int i = this.degree; i >= 0; i--) {
            if (this.coef[i] < that.coef[i]) return -1;
            if (this.coef[i] > that.coef[i]) return +1;
        }
        return 0;
    }

    /**
     * Return a string representation of this polynomial.
     * @return a string representation of this polynomial in the format
     *         4x^5 - 3x^2 + 11x + 5
     */
    @Override
    public String toString() {
        if      (degree == -1) return "0";
        else if (degree ==  0) return "" + coef[0];
        else if (degree ==  1) return coef[1] + "x + " + coef[0];
        String s = coef[degree] + "x^" + degree;
        for (int i = degree - 1; i >= 0; i--) {
            if      (coef[i] == 0) continue;
            else if (coef[i]  > 0) s = s + " + " + (coef[i]);
            else if (coef[i]  < 0) s = s + " - " + (-coef[i]);
            if      (i == 1) s = s + "x";
            else if (i >  1) s = s + "x^" + i;
        }
        return s;
    }

    /**
     * Unit tests the polynomial data type.
     *
     * @param args the command-line arguments (none)
     */
    public static void main(String[] args) {
        T_007_Polynomial zero = new T_007_Polynomial(0, 0);

        T_007_Polynomial p1   = new T_007_Polynomial(4, 3);
        T_007_Polynomial p2   = new T_007_Polynomial(3, 2);
        T_007_Polynomial p3   = new T_007_Polynomial(1, 0);
        T_007_Polynomial p4   = new T_007_Polynomial(2, 1);
        T_007_Polynomial p    = p1.plus(p2).plus(p3).plus(p4);   // 4x^3 + 3x^2 + 1

        T_007_Polynomial q1   = new T_007_Polynomial(3, 2);
        T_007_Polynomial q2   = new T_007_Polynomial(5, 0);
        T_007_Polynomial q    = q1.plus(q2);                     // 3x^2 + 5


        T_007_Polynomial r    = p.plus(q);
        T_007_Polynomial s    = p.times(q);
        T_007_Polynomial t    = p.compose(q);
        T_007_Polynomial u    = p.minus(p);

        System.out.println("zero(x)     = " + zero);
        System.out.println("p(x)        = " + p);
        System.out.println("q(x)        = " + q);
        System.out.println("p(x) + q(x) = " + r);
        System.out.println("p(x) * q(x) = " + s);
        System.out.println("p(q(x))     = " + t);
        System.out.println("p(x) - p(x) = " + u);
        System.out.println("0 - p(x)    = " + zero.minus(p));
        System.out.println("p(3)        = " + p.evaluate(3));
        System.out.println("p'(x)       = " + p.differentiate());
        System.out.println("p''(x)      = " + p.differentiate().differentiate());
    }
}
