package com.java.basics.lowleveldesign;

/**
 *  Types of Relations :
 *  1.  Association : When 2 entities relates to each other (let's A and B)
 *      1.1.    Bi-Directional ( A - B ) : A can call B and B can call A.
 *      1.2.    Uni-Directional ( A -> B ) : A can call B.
 *      1.3.    Multiplicity ( A 1 - 1...n B ) : 1 instance of A can have n instances of B.
 *
 *  2.  Aggregation (has-a relation) : B can exists without A
 *  3.  Composition (has-a relation) : B cannot exists without A
 *  4.  Inheritance (is-a relation)
 *      4.1.    Implements (interface)
 *      4.2.    Extends (class)
 *
 *  Tutorial : <a link="https://creately.com/guides/class-diagram-relationships/"></a>
 *
 *  Which design problems related to design patterns:
 *  1.  State or Chain of Responsibility Design Pattern :
 *      -   Design ATM machine (Working state -> Non-Working state (State Pattern) , money conversion (chain))
 *      -   Design Vending Machine (Working state -> Non-Working state (State Pattern) , money conversion (chain))
 *      -   Design Logger (One Log Level -> Another Log level (chain)
 *  2.  Observer Design Pattern
 *      -   Notify me (when any stock is available, when any item in shopping website is available)
 *      -   BroadCasting
 *  3.  Strategy Design pattern
 *      -   Strategy to choose while Payment (Cash, Card etc.)
 *  4.  Decorator Design Pattern
 *      -   Topping on Pizza as a decorator (adding new functionalities)
 *  5.  Proxy Design Pattern
 *      -   Visiting website (goes through proxy for blocked website)
 *      -   Cache (b/w client and server)
 *      -   Pre-processing & Post-Processing (like analyzers in Elastic Search, logging , auth. in any application etc)
 *      -   Spring Boot (a proxy bean is created for every bean)
 */
public class T_001_Basics { }
