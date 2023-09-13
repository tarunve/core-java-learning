package enhancements;

import java.util.ArrayList;
import java.util.List;

/**
 *  String.indent() :
 *      -   The indent method helps with changing the indentation of a String. We can either pass a
 *          positive value or a negative value depending on whether we want to add more white spaces
 *          or remove existing white spaces.
 *      -   indent() method automatically adds a newline character if it has not been provided yet.
 *
 *  String.transform() :
 *      -   The transform() method takes a String and transforms it into a new String with the help
 *          of a Function.
 */
public class E_002_StringAPIChanges {

    public static void main(String[] args) {
        // String.indent()
        String result = "foo\nbar\nbar2".indent(4);
        System.out.println(result);

        // String.transform()
        List<String> names = List.of("   Alex", "brian");
        List<String> transformedNames = new ArrayList<>();
        for (String name : names)
        {
            String transformedName = name.transform(String::strip)
                    .transform(String::toUpperCase);
            transformedNames.add(transformedName);
        }
        System.out.println(transformedNames);
    }
}
