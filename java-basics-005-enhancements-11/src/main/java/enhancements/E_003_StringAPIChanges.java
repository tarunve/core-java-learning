package enhancements;

import java.util.ArrayList;
import java.util.List;

/**
 *  New Methods
 *  -   String.repeat(Integer)  :
 *      -   This method simply repeats a string n times. It returns a string whose value is the
 *          concatenation of given string repeated N times.
 *      -   If this string is empty or count is zero then the empty string is returned.
 *  -   String.isBlank()
 *      -   This method indicates whether a string is empty or contains only white-spaces. Previously,
 *          we have been using it from Apache’s StringUtils.java.
 *  -   String.strip()
 *      -   This method takes care of removing leading and trailing white-spaces. We can be even
 *          more specific by removing just the leading characters by using String.stripLeading()
 *          or just the trailing characters by using String.stripTrailing().
 *  -   String.lines()
 *      -   This method helps in processing multi-line texts as a Stream.
 */
public class E_003_StringAPIChanges {

    public static void repeatMethod(){
        String str = "1".repeat(5);
        System.out.println(str);  //11111
    }

    public static void isBlankMethod(){
        System.out.println("1".isBlank());  //false
        System.out.println("".isBlank()); //true
        System.out.println("    ".isBlank()); //true
    }

    public static void stripMethod(){
        System.out.println("   hi  ".strip());  //"hi"
        System.out.println("   hi  ".stripLeading());  //"hi   "
        System.out.println("   hi  ".stripTrailing()); //"   hi"
    }

    public static void linesMethod(){
        String testString = "hello\nworld\nis\nexecuted";
        List<String> lines = new ArrayList<>();
        // testString.lines().forEach(line -> lines.add(line));
        testString.lines().forEach(lines::add);
        System.out.println(lines);
    }

    public static void main(String[] args) {
        repeatMethod();
        System.out.println("================");
        isBlankMethod();
        System.out.println("================");
        stripMethod();
        System.out.println("================");
        linesMethod();
    }
}
