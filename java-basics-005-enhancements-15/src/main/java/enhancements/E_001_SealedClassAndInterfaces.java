package enhancements;

/**
 *  -   In Java, by default, there is no restriction on a class which public interfaces it can
 *      implement. Since Java 15, now a class or interface can be declared sealed class or sealed
 *      interface using the modifier sealed. It is a preview feature in Java 15.
 *  -   A sealed class or interface restricts which other classes or interfaces may extend or
 *      implement them. Conceptually, it is a more declarative way than access modifiers to
 *      restrict the use of a class or interface as a parent class or as a parent interface.
 *  -   A sealed class is a class or interface that restricts which other classes or interfaces
 *      may extend.
 *  -   The permitted subclasses must have exactly one of the following modifiers to describe how
 *      it continues the sealing initiated by its superclass:
 *      -   final class cannot be extended further.
 *      -   sealed class can only be extended by its permitted subclasses.
 *      -   non-sealed class can be extended by unknown subclasses as well. A sealed class cannot
 *          force the sealing behavior to its permitted subclasses.
 *
 *  -   Remember the use of instanceof operator to test whether the object is an instance of the
 *      specified class. Generally, we checked all the possible class types and, at last, in else
 *      block, we have to write some code if the given instance doesn’t match any class type.
 *  -   Also, there is no guarantee that another developer will add one more class to the hierarchy
 *      and add the type check in the given instanceof checks. Sealed classes can impose this
 *      restriction on the hierarchies at the language level.
 *  -   With the future direction of instanceof operator and pattern matching, the default block or
 *      else block will not be needed.
 *  -   As soon as a new subclass is added to a sealed class, by using type test patterns, the
 *      compiler will be able to check that every permitted subclass is covered.
 */
public class E_001_SealedClassAndInterfaces {

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
