package enhancements;

/**
 *  -   First, we need to pass -XX:+ShowCodeDetailsInExceptionMessages JVM flag to enable this
 *      feature while running the application. Make sure, you are passing it.
 *  -   The option will first have default false so that the message is not printed. It is intended
 *      to enable code details in exception messages by default in a later release.
 */
public class E_001_NullPointerException {

    public static void main(String[] args)
    {
        Employee e = null;

        System.out.println(e.getName());
    }

    static class Employee {
        Long id;
        String name;

        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
