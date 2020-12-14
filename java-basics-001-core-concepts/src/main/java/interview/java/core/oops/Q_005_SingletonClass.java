package interview.java.core.oops;

import com.java.basic.concepts.oops.T_015_SingletonClass;

import java.lang.reflect.Constructor;

/**
 *  Singleton Class - If we are allowed to create only one object of class.
 *  				Ex.	Runtime.
 *
 *  To create Singleton class
 *  ------------------------
 *  1.	Private constructor
 *  2.	Private static variable
 *  3.	public factory method.
 */
public class Q_005_SingletonClass {

    /*
     * Approach 1 : Singleton With Public Static Final Field
     */

    public static class Singleton1 {
        public static final Q_005_SingletonClass.Singleton1 INSTANCE = new Q_005_SingletonClass.Singleton1();
        private Singleton1() {}
    }

    /*
     * Approach 2 : Singleton With Public Static Factory Method
     */
    static class Singleton2 {
        private static Q_005_SingletonClass.Singleton2 object = new Q_005_SingletonClass.Singleton2();

        private Singleton2() {}

        public static Q_005_SingletonClass.Singleton2 getInstance() {
            return object;
        }
    }

    /*
     * Approach 3 : Singleton With Lazy Initialization
     */
    static class Singleton3 {
        private static Q_005_SingletonClass.Singleton1 INSTANCE;

        private Singleton3() {}

        public static Q_005_SingletonClass.Singleton1 getInstance() {
            if (INSTANCE == null) {
                synchronized (Q_005_SingletonClass.Singleton1.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new Q_005_SingletonClass.Singleton1();
                    }
                }
            }
            return INSTANCE;
        }
    }

    /*
     * Problem with above approaches : Reflection has break the property of singleton
     */
    public static class ReflectionDemo {
        public static void main(String[] args) throws Exception {
            Q_005_SingletonClass.Singleton1 singleton = Q_005_SingletonClass.Singleton1.INSTANCE;
            Constructor<? extends Object> constructor = singleton.getClass().getDeclaredConstructor();
            constructor.setAccessible(true);
            Q_005_SingletonClass.Singleton1 singleton2 = (Q_005_SingletonClass.Singleton1) constructor.newInstance();
            if (singleton == singleton2) {
                System.out.println("Two objects are same");
            } else {
                System.out.println("Two objects are not same");
            }
        }
    }

    /*
     * Approach 4 : Singleton with Enum
     */
    public enum SingletonEnum {
        INSTANCE;
        int value;
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
    }

    public static class EnumDemo {
        public static void main(String[] args) {
            Q_005_SingletonClass.SingletonEnum singleton = Q_005_SingletonClass.SingletonEnum.INSTANCE;
            Q_005_SingletonClass.SingletonEnum singleton1 = Q_005_SingletonClass.SingletonEnum.INSTANCE;
            Q_005_SingletonClass.SingletonEnum singleton2 = Q_005_SingletonClass.SingletonEnum.INSTANCE;
            System.out.println(singleton.getValue());
            singleton.setValue(2);
            System.out.println(singleton.getValue());
            System.out.println(singleton == singleton1);
            System.out.println(singleton1 == singleton2);
            System.out.println(singleton == singleton2);
        }
    }
}
