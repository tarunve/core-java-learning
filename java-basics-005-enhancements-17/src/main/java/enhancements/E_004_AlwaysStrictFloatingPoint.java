package enhancements;

/**
 * - In Java 17, a new feature called “Restore Always-Strict Floating-Point Semantics” has been introduced.
 *   This feature aims to improve the consistency and reliability of floating-point arithmetic in Java
 *   applications. It can be mainly important in applications where precision is critical.
 * - Prior to Java 17, some floating-point operations in Java were not always strictly adhering to the
 *   IEEE 754 floating-point standard, which can lead to inconsistent behavior across different platforms
 *   and architectures. With the new feature, Java will always use the strictest possible floating-point
 *   semantics by default, which should result in more predictable and consistent behavior across
 *   different platforms.
 */
public class E_004_AlwaysStrictFloatingPoint {

    /**
     * In this example, we are adding two doubles a and b and storing the result in c. Prior to Java 17,
     * the result of this operation would have been 0.30000000000000004 due to rounding errors that can
     * occur in floating-point arithmetic. However, with the new feature in Java 17, the result will be
     * 0.3 as per the IEEE 754 floating-point standard.
     */
    public static void main(String[] args) {
        double a = 0.1;
        double b = 0.2;
        double c = a + b;
        System.out.println(c);
    }
}
