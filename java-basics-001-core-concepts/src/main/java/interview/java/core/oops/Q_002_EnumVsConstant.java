package interview.java.core.oops;

/**
 *  -   Suppose you use constant strings (or int values - the same goes for them):
 *          //  Constants for player types
 *          public static final String ARCHER = "Archer";
 *          public static final String WARRIOR = "Warrior";
 *      then you end up not really knowing the type of your data - leading to potentially incorrect code:
 *          String playerType = Constants.MALE;
 *  -   If you use enums, that would end up as:
 *          //  Compile-time error - incompatible types!
 *              PlayerType playerType = Gender.MALE;
 *      -   Enums give a restricted set of values.
 *      -   Additionally, enums in Java can have more information associated with
 *          them, and can also have behaviour. Much better all round.
 *      -   Enum is better to use for type safety. Wrong values cannot be entered.
 */
public class Q_002_EnumVsConstant {
}
