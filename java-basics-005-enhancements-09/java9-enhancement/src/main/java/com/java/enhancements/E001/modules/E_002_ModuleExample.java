package com.java.enhancements.E001.modules;

/**
 *  module-info.java:
 *  ================
 *  -   File required for specifying the packages required and to be delivered.
 *  -   'transitive' can be used with requires to import the packages for the
 *      3rd module. Ex: A exports some package , B requires module A, module
 *      C needs the java files from module A. If B add transitive requires for
 *      module A and C requires B then the packages will be available for module C.
 *      Basically, it is used for aggregating modules.
 *
 *  Service Loader:
 *  --------------
 *  -   We can have impl of specific interfaces on diff modules and we can use
 *      those impl without directly depending on that module.
 *  -   We need to specify 'provide - with' syntax in module-info.java
 *      And 'uses interface-name' in target module where we want to use it.
 *
 *  Can Reflection be possible in Java9:
 *  -----------------------------------
 *  -   No , unless or until we export the package of class or open module.
 *      -   'exports' keyword for the package enables it for reflection.
 *      -   'open' keyword in module configuration enables it to enable reflection.
 *      -   'opens' keyword for the package also enable it for reflection.
 *
 *  Commands:
 *  =========
 *  Compile Java file:
 *      javac --modules-source-path src -d out ${find . -name *.java}
 *  Run :
 *      java --module-path out package/Main
 *
 *  java --list-modules javafx
 */
public class E_002_ModuleExample {
    public static void main(String[] args) {

    }

}
