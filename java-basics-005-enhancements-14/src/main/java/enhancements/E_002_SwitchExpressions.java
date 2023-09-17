package enhancements;

/**
 *  -   This change extends the switch statement so that it can be used as either a statement or
 *      an expression.
 *  -   Instead of having to define a break statement per case block, we can simply use the arrow
 *      syntax. The arrow syntax semantically looks like a lambda and separates the case label
 *      from the expression.
 *  -   With the new switch expressions, we can directly assign the switch statement to a variable.
 */
public class E_002_SwitchExpressions {

    enum Day {
        MONDAY, TUESDAY,  WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }

    private static void isWeekend(Day day) {
        boolean isWeekend = switch (day)
                {
                    case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> false;
                    case SATURDAY, SUNDAY -> true;
                };

        System.out.println(isWeekend);  //true or false - based on current day
    }

    public static void main(String[] args) {
        isWeekend(Day.FRIDAY);
        isWeekend(Day.SATURDAY);
    }
}
