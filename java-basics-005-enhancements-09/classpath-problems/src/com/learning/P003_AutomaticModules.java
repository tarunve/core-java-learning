package com.learning;


import org.apache.commons.lang3.StringUtils;

/**
 *  Compile:
 *      javac --module-path lib --add-modules org.apache.commons.lang3
 *      classpath-problems/src/com/learning/P003_AutomaticModules.java
 */
public class P003_AutomaticModules {
    public static void main(String[] args) {
        String out = StringUtils.leftPad("Padme!", 20);
        System.out.println(out);
    }
}
