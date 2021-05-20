package com.java.enhancements.E001.modules;

/**
 *  Modular System:
 *  ==============
 *  -   Released on September 2017
 *  -   JPMS (Java Platform Module System) is the major enhancement in Java 9.
 *      It is also known as Project Jigsaw.
 *
 *  What is a Module?
 *  ----------------
 *  -   In any programming language, modules are (package-like) artifacts
 *      containing code, with metadata describing the module and also its
 *      relation to other modules. Ideally, these artifacts are recognizable
 *      from compile-time all the way through run-time. Any application
 *      generally is combination of multiple modules which work together to
 *      perform the business objectives.
 *  -   In terms of application architecture, a module shall represent a specific
 *      business capability. It should be self-sufficient for that capability, and
 *      should expose only interfaces to use the module functionality. To complete
 *      its tasks, it may be dependent on other modules, which it should declare
 *      explicitly.
 *  -   So, in short, a module should adhere to three core principles –
 *      1.  Strong Encapsulation : Encapsulation means to hide implementation details,
 *              which are are not essential to know to use the module correctly. The
 *              purpose is that encapsulated code may change freely without affecting
 *              users of the module.
 *      2.  Stable Abstraction : Abstraction helps to expose module functionality
 *              using interfaces i.e. public APIs. Anytime, you want to change the
 *              business logic or implementation inside module code, changes will be
 *              transparent to the module users.
 *      3.  Explicit dependencies : Modules can be dependent on other modules as well.
 *              These external dependencies must be part of the module definition itself.
 *              These dependencies between modules are often represented as graphs.
 *              Once you see the graph at application level, you will have better
 *              understanding of the application’s architecture
 *
 *  Introduction to Java 9 Modules:
 *  ------------------------------
 *  -   Before java 9, you had ‘packages‘ to group related classes as per business
 *      capabilities. Along with packages, you had ‘access modifiers‘ to control what
 *      will be visible and what will be hidden to other classes or packages. It has
 *      been working great so far. Java has strong support for encapsulation and abstraction.
 *  -   But, explicit dependencies is where things start to fall apart. In java,
 *      dependencies are declared with ‘import‘ statements; but they are strictly
 *      ‘compile time’ constructs. Once code is compiled, there is no mechanism to
 *      clearly state it’s runtime dependencies. In fact, java runtime dependency
 *      resolution is so much problematic area that special tools have been created to
 *      fight this problem e.g. gradle or maven. Also, few frameworks started bundling
 *      their complete runtime dependencies as well e.g. Spring boot projects.
 *  -   With new Java 9 modules, we will have better capability to write well-structured
 *      applications. This enhancement is divided into two area:
 *      1.  Modularize the JDK itself.
 *      2.  Offer a module system for other applications to use.
 *  -   Java 9 Module System has a “java.base” Module. It’s known as Base Module.
 *      It’s an Independent module and does NOT dependent on any other modules. By
 *      default, all other modules dependent on “java.base”.
 *  -   In java 9, modules helps you in encapsulating packages and manage dependencies.
 *      So typically,
 *          a class is a container of fields and methods
 *          a package is a container of classes and interfaces
 *          a module is a container of packages
 *  -   You will not feel any major difference between normal code and modular code
 *      if you don’t know the specific things to look for. e.g.
 *          A module is typically just a jar file that has a module-info.class file
 *          at the root. To use a module, include the jar file into module-path instead
 *          of the classpath. A modular jar file added to classpath is normal jar file
 *          and module-info.class file will be ignored.
 */
public class E_001_Intro {
}
