package com.java.enhancements.E001.modules;

/**
 *  Encapsulated Types:
 *  ==================
 *  -   Classes which are for internal use are not exposed.
 *  -   work around is : --add-exports
 *      Ex: javac --add-exports java.base/sun.security.x509=ALL-UNNAMED
 *          classpath-problems/src/com/learning/P001_EncapsulatedTypes.java
 *  -   We can use jdeps for getting internal information for JDK
 *      Ex: jdeps -jdkinternals classpath-problems/src/com/learning/P001_EncapsulatedTypes.class
 *      We can get the class which should be the replacement & more info.
 *
 *  Non Default Java SE Module:
 *  ==========================
 *  -   Some modules are not resolved by default because dependencies have
 *      been distributed.
 *      Ex: javax.xml.bind : we need to add the jar to the module path.
 *      javac --module-path lib --add-modules java.xml.bind
 *      classpath-problems/src/com/learning/P002_NonDefaultJavaSEModule.java
 *
 *  Explicit Dependencies/Automatic Modules:
 *  ======================================
 *  -   We might need to use externals/3rd party jars in project.
 *  -   We can add it in some directory and add the directory to module path.
 *      Ex: javac --module-path lib --add-modules org.apache.commons.lang3
 *      classpath-problems/src/com/learning/P003_AutomaticModules.java
 *
 */
public class E_003_ClassPathIsseues {
}
