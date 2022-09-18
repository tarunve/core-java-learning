package enhancements;

import java.util.List;
import java.util.stream.Collectors;

/**
 *  -   New function for creating UnmodifiableList from Collectors API.
 */
public class E_002_CollectorsApiChanges {

    public static void main(String[] args) {
        List<Integer> l = List.of(15, 20, 17, 30);
        List<Integer> res = l.stream().filter(i -> i % 3 == 0).collect(Collectors.toList());
        res.add(12); // we can add new elements.
        System.out.println(res);

        // unmodifiable list
        List<Integer> res2 = l.stream().filter(i -> i % 3 == 0).collect(Collectors.toUnmodifiableList());
        res2.add(12);
        System.out.println(res2);
    }
}
