package enhancements;

import java.util.HashMap;

/**
 *  var keyword for variable declaration
 *
 *  -   null can not be assigned because compiler won't know what type it is.
 *  -   can't use to define the Lambda Expression.
 */
public class E_001_VarDeclaration {

    public static void main(String[] args) {
        var v = 12;
        System.out.println(v);

        var mp = new HashMap<Integer, Integer>();
        mp.put(1, 1);
        for(var entry: mp.entrySet()){
            var value = entry.getValue();
            System.out.println(value);
        }
    }
}
