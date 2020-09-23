package abdulbari.practice002.reccurence;

import java.util.logging.Level;
import java.util.logging.Logger;

public class T_002_StaticGlobalVariables {

    private static final Logger LOGGER = Logger.getLogger(T_002_StaticGlobalVariables.class.getName());
    private int x;

    public static void main(String[] args) {
        int r = new T_002_StaticGlobalVariables().function(5);
        LOGGER.log(Level.SEVERE, String.valueOf(r));
    }

    private int function(int n){
        if(n>0){
            x++;
            return function(n-1) + x;
        }
        return 0;
    }
}
