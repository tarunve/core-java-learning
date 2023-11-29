package enhancements;

/**
 *  -   Conceptually, records can be thought of as tuples that are already available via
 *      3rd party libraries. Though, records are built in type in Java so they provide a
 *      more extended use and compatibility with other features in Java such as pattern
 *      matching with instanceof and switch case.
 *  -   Like enum, a record is also a special class type in Java. Records are intended to
 *      be used in places where a class is created only to act as a plain data carrier.
 *  -   The important difference between class and record is that a record aims to eliminate
 *      all the boilerplate code needed to set and get the data from the instance.
 *      Records transfer this responsibility to the Java compiler, which generates the
 *      constructor, field getters, hashCode() and equals() as well toString() methods.
 *  -   The class extends {@link Record}, which is the base class for all records. It means
 *      a record cannot extend the other classes.
 *  -   The class is marked final, so we cannot create a subclass.
 *  -   It does not have any setter method, meaning a record instance is designed to be immutable.
 */
public class E_002_Records {

    // Normal Record
    record Employee(Long id, String firstName, String lastName, String email, int age) { }

    // Typed Record
    record Container<T>(int id, T value) { }

    // Custom Record
    record CustomRecord(String firstName) {
        private static String lastName;

        CustomRecord(String firstName, String ln) {
            this(firstName);
            lastName = ln;
        }

        @Override
        public String toString() {
            return "CustomerRecord[firstName=" + firstName + ", lastName=" + lastName + "]";
        }
    }

    public static void main(String[] args) {
        Employee e = new Employee(1L, "FirstName", "LastName", "Email", 30);
        System.out.println(e);

        Container<String> c = new Container<>(1, "Test");
        System.out.println(c);

        CustomRecord cr1 = new CustomRecord("first", "last");
        System.out.println(cr1);
    }
}
