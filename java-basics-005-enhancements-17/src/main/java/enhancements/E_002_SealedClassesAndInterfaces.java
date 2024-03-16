package enhancements;

/**
 * - Sealed classes and interfaces offer a restriction whether classes/interfaces can extend/implement
 *   other classes/interfaces or not.
 * - In simple words, Sealed Classes work by specifying which classes or interfaces are allowed to extend
 *   or implement a particular class or interface. This is achieved by using the “sealed” modifier on the
 *   parent class or interface, and then specifying the allowed subclasses or implementing classes using the
 *   “permits” keyword.
 * - Sealed Classes were proposed by JEP 360 and delivered in JDK 15 as a preview feature. They were
 *   proposed again, with some refinements, and delivered in JDK 16 as a preview feature. Now in JDK 17,
 *   Sealed Classes are being finalized with no changes from JDK 16.
 * - Sealed classes also allow developers to define “permitted” interfaces that can be implemented by
 *   the allowed subclasses.
 */
public class E_002_SealedClassesAndInterfaces {

    public sealed class Shape permits Circle, Square, Triangle { }

    public non-sealed class Circle extends Shape { }
    public non-sealed class Square extends Shape { }
    public non-sealed class Triangle extends Shape { }

    sealed class Account permits CurrentAccount, SavingAccount, LoanAccount { }

    final class CurrentAccount extends Account {}
    non-sealed class SavingAccount extends Account {}
    sealed class LoanAccount extends Account permits HomeloanAccount, AutoloanAccount {}

    final class HomeloanAccount extends LoanAccount{}
    final class AutoloanAccount extends LoanAccount{}

    // class Test extends Account {} // Test is not allowed in the sealed hierarchy

    // Interface
    public sealed interface IReport
            permits Printable, Formattable, ExcelReport, PdfReport {
    }

    non-sealed interface Printable extends IReport {}
    non-sealed interface Formattable extends IReport {}
    non-sealed static class ExcelReport implements IReport {}
    non-sealed static class PdfReport implements IReport {}
}
