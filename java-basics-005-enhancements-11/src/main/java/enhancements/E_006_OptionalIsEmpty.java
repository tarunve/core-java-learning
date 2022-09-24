package enhancements;

import java.util.Optional;

/**
 *  -   Optional is a container object which may or may not contain a non-null value. If no value
 *      is present, the object is considered empty.
 *  -   Previously existing method isPresent() returns true if a value is present, otherwise false.
 *      Sometimes, it forces us to write negative conditions which are not readable.
 *  -   isEmpty() method is reverse of isPresent() method and returns false if a value is present,
 *      otherwise true.
 *  -   So we do not to write negative conditions in any case. Use any of these two methods when
 *      appropriate.
 */
public class E_006_OptionalIsEmpty {

    public static void main(String[] args) {
        String currentTime = null;

        System.out.println(!Optional.ofNullable(currentTime).isPresent());  //It's negative condition
        System.out.println(Optional.ofNullable(currentTime).isEmpty());   //Write it like this

        currentTime = "12:00 PM";

        System.out.println(!Optional.ofNullable(currentTime).isPresent()); //It's negative condition
        System.out.println(Optional.ofNullable(currentTime).isEmpty());  //Write it like this
    }
}
