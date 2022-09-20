package enhancements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  -   Before Java 11, converting a collection to array was not straightforward. Java 11 makes
 *      the conversion more convenient.
 */
public class E_005_CollectionsAPIChanges {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("alex");
        names.add("brian");
        names.add("charles");

        String[] namesArr1 = names.toArray(new String[names.size()]);   //Before Java 11
        System.out.println(Arrays.toString(namesArr1));

        String[] namesArr2 = names.toArray(String[]::new);          //Since Java 11
        System.out.println(Arrays.toString(namesArr2));
    }
}
