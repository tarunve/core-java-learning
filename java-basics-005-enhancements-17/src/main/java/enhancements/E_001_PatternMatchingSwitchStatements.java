package enhancements;

/**
 *  Pattern Matching For Switch Statements
 *  ======================================
 *  -   Java 17 introduced a new feature called “Pattern Matching for switch Statements” that allows
 *      developers to simplify the code for switch statements that involve pattern matching. This
 *      feature provides a short and more readable syntax to handle multiple conditions in switch statements.
 *  -   Before the introduction of this feature, switch statements could only compare the value of a
 *      single variable against a series of constants or expressions. Moreover, the previous version
 *      of switch statement was limited to byte, short, char, int, Byte, Character, Short, Integer,
 *      String, and Enum types. The new feature allows developers to use patterns to match against
 *      the value of an object of any type.
 *
 *
 *  Pattern Matching For instanceof
 *  ===============================
 *  -   Java 17 introduces a short way of pattern matching for the instanceof operator, which helps
 *      to simplify the code required for type checks. With pattern matching, you can extract the value
 *      of the checked object into a new variable if the check succeeds. This new variable can then be
 *      used in following code. It eliminates the need to cast the object into the expected type.
 *  -   Note that this was a preview feature introduced under Java 14 Features. It has become a permanent
 *      feature under the list of Java 17 features.
 */
public class E_001_PatternMatchingSwitchStatements {

    /**
     * Pattern Matching for Switch Statements
     */
    public String traditionalBeforeJava12(int dayNum) {
        String day;
        switch (dayNum) {
            case 5:
            case 6:
                day = "Weekend";
                break;
            default:
                day = "Weekday";
        }
        return day;
    }
    public String switchInJava12(int dayNum) {
        return switch (dayNum) {
            case 5, 6 -> "Weekend";
            default -> "Weekday";
        };
    }

    /**
     * In addition to using constant patterns, the new feature of java 17 also allows developers to
     * use variable patterns and type patterns. A variable pattern allows you to match against a
     * specific value and assign it to a variable. A type pattern allows you to match against the
     * type of a value.
     */
    public int getLength(Object obj) {
//        return switch (obj) {
//            case String s -> s.length(); // variable pattern
//            case List list && !list.isEmpty() -> list.size(); // type pattern
//                case null -> 0;
//                default -> -1;
//        };
        return 0;
    }

    // Furthermore, this allows you to use expressions as case labels instead of just constants.
    public void switchExpressions(int value) {
        switch (value) {
            case 1 -> System.out.println("One");
            case 2 -> System.out.println("Two");
            case 3, 4 -> System.out.println("Three or Four");
//            case n if n >= 5 && n <= 10 -> System.out.println("Between Five and Ten"); // expression pattern
                default -> System.out.println("Invalid value");
        }
    }

    // Below example shows the summary of types that are allowed in a case label
    public String testType(Object obj) {
//        return switch (obj) {
//            case null -> "NULL value";
//            case String str -> "It's a String";
//            case Size s -> "Enum Type";
//            case Point p -> "Records Type";
//            case Employee e -> "Custom Object's Type";
//            case int[] ai -> "Array Type";
//            case Employee e && e.getName.equals("John") -> "Conditional Statement";
//                default -> "Unknown";
//        };
        return null;
    }
    public enum Size {
        SMALL, MEDIUM, LARGE;
    }
    public record Point( int i, int j) {  }
    public static class Employee{ }


    /**
     * Pattern Matching for instanceof
     */
    public void traditionalInstanceOfBeforeJava17(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println(str.length());
        }
    }

    public void newInstanceOfAfterJava17(Object obj) {
        if (obj instanceof String str) {
            System.out.println(str.length());
        }
    }
}
