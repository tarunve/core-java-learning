package interview.java.core.io;

/**
 *  Custom Checked Exception:
 *  ========================
 *  -   Extend the class - java.lang.Exception.
 *  -   Create a constructor with String argument.
 *
 *  Custom UnChecked Exception:
 *  ========================
 *  -   Extend the class - java.lang.RuntimeException.
 *  -   Create a constructor with String argument.
 */
public class Q_001_CustomizedException {

    //Custom Checked Exception
    static class MyCheckedException extends Exception{

        MyCheckedException(String message){
            super(message);
        }
    }

    //Custom UnChecked Exception
    static class MyUnCheckedException extends RuntimeException{

        MyUnCheckedException(String message){
            super(message);
        }
    }
}
