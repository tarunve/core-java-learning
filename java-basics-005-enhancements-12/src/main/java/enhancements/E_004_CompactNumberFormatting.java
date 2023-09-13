package enhancements;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *  Large numbers rendered by a user interface or a command-line tool are always difficult to
 *  parse. It is far more common to use the abbreviated form of a number. Compact number
 *  representations are much easier to read and require less space on the screen without losing
 *  the original meaning.
 */
public class E_004_CompactNumberFormatting {

    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getCompactNumberInstance(Locale.US,
                NumberFormat.Style.SHORT);

        String formattedString = formatter.format(25000L);    //25K
        System.out.println(formattedString);
    }
}

