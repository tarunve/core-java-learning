package interview.java.core.jvm;

/**
 *  -   There are 3 types of class loader:
 *      1.  Bootstrap   2.  Extension   3.  Application/System ClassLoader
 *  -   ClassLoader follows the Delegation-Hierarchy principle.
 *  -   JVM first checks if class file is already loaded or not. If not loaded, JVM requests
 *      ClassLoader sub system to load it then delegation is handed over as below :
 *          App ClassLoader -> Ext ClassLoader -> Bootstrap ClassLoader
 *      Then Bootstrap CL checks class file in Bootstrap classpath (JRE/lib), if nt found
 *      then Ext CL checks it in Extension classpath(JRE/lib/ext), if not found then App
 *      CL will search it in Application classpath. If still not found , we will get
 *      RE: NoClassDefError or ClassNotFundException.
 *
 *  BootStrap ClassLoader:
 *  =====================
 *  -   Responsible to load core java API classes i.e. classes present in rt.jar (JRE/lib).
 *  -   JRE/lib - this location is called bootstrap classpath.
 *  -   Available in every JVM by default and implemented in native language(C/C++).
 *
 *  Extension ClassLoader:
 *  =====================
 *  -   Child class of Bootstrap ClassLoader.
 *  -   Responsible to load classes from extension classpath (JRE/lib/ext)
 *  -   Implemented in Java and corresponding .class file is - sun.misc.Launcher$ExtClassLoader.
 *
 *  Application ClassLoader:
 *  =======================
 *  -   Child class of Extension Class Loader.
 *  -   Responsible for loading classes from application classpath. It internally uses
 *      environment variable classpath.
 *
 *  Need For Customized ClassLoader:
 *  -------------------------------
 *  -   After loading class file, if it is modified outside then default class loader won't
 *      load updated version of class file.
 *  -   We can resolve this problem by defining our own customized class loader. We can define
 *      custom class loader by extending - java.lang.ClassLoader class.
 */
public class Q_002_ClassLoader {

    public static class CustomClassLoader extends ClassLoader{

        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return super.loadClass(name);
        }
    }
}
