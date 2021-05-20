package com.java.enhancements.E001.modules;

/**
 *  JLink:
 *  =====
 *  -   Used to create our own modules as deliverable like JDK.
 *  -   We can create custom runtime image using jlink.
 *
 *  Steps:
 *  =====
 *  -   Create jar File:
 *          jar --create --file lib/com.shop.billing.jar
 *              // --main-class=ABC // we can specify main class as well.
 *              -C out/production/com.shop.billing .
 *  -   Create Image using Jlink
 *          jlink --module-path lib/:${JAVA_11_HOME}/jmods
 *                --add-modules com.shop.billing
 *                --strip-debug
 *                --compress=2
 *                --output ~/Desktop/image
 */
public class E_004_JLink {

}
