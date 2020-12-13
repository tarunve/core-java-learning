package interview.java.core.oops;

/*
 *  -   A clone is an exact copy of the original. In java, it essentially means the ability
 *      to create an object with similar state as the original object. The java clone() method
 *      provides this functionality.
 *  -   By default, java cloning is ‘field by field copy’ i.e. as the Object class does not
 *      have idea about the structure of class on which clone() method will be invoked.
 *  -   So, JVM when called for cloning, do following things:
 *      -   If the class has only primitive data type members then a completely new copy of
 *          the object will be created and the reference to the new object copy will be returned.
 *      -   If the class contains members of any class type then only the object references to
 *          those members are copied and hence the member references in both the original object
 *          as well as the cloned object refer to the same object.
 *  -   Apart from above default behavior, you can always override this behavior and specify your
 *      own. This is done using overriding clone() method.
 *      -   You must implement Cloneable interface.
 *      -   You must override clone() method from Object class. [Its weird. clone() method should
 *          have been in Cloneable interface.]
 *              protected native Object clone() throws CloneNotSupportedException;
 *
 *  Deep cloning requires satisfaction of following rules:
 *  -----------------------------------------------------
 *  -   No need to separately copy primitives.
 *  -   All the member classes in original class should support cloning and in clone method of
 *      original class in context should call super.clone() on all member classes.
 *  -   If any member class does not support cloning then in clone method, one must create a new
 *      instance of that member class and copy all its attributes one by one to new member class
 *      object. This new member class object will be set in cloned object.
 *
 *  Java clone best practices
 *  -------------------------
 *  -   When you don’t know whether you can call the clone() method of a particular class as you
 *      are not sure if it is implemented in that class, you can check with checking if the class
 *      is instance of “Cloneable” interface as below.
 *          obj1 instanceof Cloneable
 *  -   No constructor is called on the object being cloned. As a result, it is your responsibility,
 *      to make sure all the members have been properly set. Also, if you are keeping track of the
 *      number of objects in the system by counting the invocation of constructors, you got a new
 *      additional place to increment the counter.
 */

public class Q_001_Cloning {

    public static class Employee implements Cloneable{

        private int empoyeeId;
        private String employeeName;
        private Department department;

        public Employee(int id, String name, Department dept)
        {
            this.empoyeeId = id;
            this.employeeName = name;
            this.department = dept;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Employee cloned = (Employee)super.clone();
            cloned.setDepartment((Department)cloned.getDepartment().clone());
            return cloned;
        }

        /* //Shallow Copy

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }*/

        public int getEmpoyeeId() {
            return empoyeeId;
        }

        public void setEmpoyeeId(int empoyeeId) {
            this.empoyeeId = empoyeeId;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }
    }

    public static class Department implements Cloneable
    {
        private int id;
        private String name;

        public Department(int id, String name)
        {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException
    {
        Department dept = new Department(1, "Human Resource");
        Employee original = new Employee(1, "Admin", dept);
        //Lets create a clone of original object
        Employee cloned = (Employee) original.clone();
        //Let verify using employee id, if cloning actually workded
        System.out.println(cloned.getEmpoyeeId());
        //Must be true and objects must have different memory addresses
        System.out.println(original != cloned);
        //As we are returning same class; so it should be true
        System.out.println(original.getClass() == cloned.getClass());
        //Default equals method checks for references so it should be false. If we want to make it true,
        //then we need to override equals method in Employee class.
        System.out.println(original.equals(cloned));

        //Test Deep Copy
        Department hr = new Department(1, "Human Resource");
        Employee originalEmployee = new Employee(1, "Admin", hr);
        Employee clonedEmployee = (Employee) originalEmployee.clone();
        //Let change the department name in cloned object and we will verify in original object
        clonedEmployee.getDepartment().setName("Finance");
        System.out.println(originalEmployee.getDepartment().getName());
        System.out.println(clonedEmployee.getDepartment().getName());
    }
}
