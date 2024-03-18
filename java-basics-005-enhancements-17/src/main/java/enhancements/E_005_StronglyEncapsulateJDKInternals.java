package enhancements;

import sun.misc.Unsafe;
import java.nio.ByteBuffer;

/**
 * - The “Strongly Encapsulate JDK Internals” feature in Java 17 aims to further enhance the encapsulation
 *   of internal APIs in the JDK (Java Development Kit). The goal is to limit the use of internal APIs by
 *   third-party applications and libraries, which can improve the security and stability of Java applications.
 * - Internal APIs are not intended for use by third-party applications, as they may change or be removed
 *   without notice in future JDK releases. However, some third-party libraries and applications still rely
 *   on these internal APIs, which can result in compatibility issues and security vulnerabilities.
 * - With the “Strongly Encapsulate JDK Internals” feature in Java 17, access to internal APIs is more
 *   restricted. Any code that tries to access internal APIs will result in a warning message or a
 *   compilation error, depending on the specific API.
 */
public class E_005_StronglyEncapsulateJDKInternals {

    /**
     * In this example, we are trying to use the sun.misc.Unsafe class, which is an internal API that is
     * not intended for use by third-party applications. Prior to Java 17, this code would compile and run
     * without any issues. However, with the new feature, this code will result in a runtime error,
     * as access to the sun.misc.Unsafe class is now strongly encapsulated.
     */
    public static void priorJava17() {
        Unsafe unsafe = Unsafe.getUnsafe();
        long value = unsafe.allocateMemory(1024);
        System.out.println(value);
    }

    /**
     * In this updated example, we use the ByteBuffer class to allocate memory instead of the
     * sun.misc.Unsafe class. We then cast the ByteBuffer to a sun.nio.ch.DirectBuffer and use its
     * address() method to get the memory address.
     */
    public static void afterJava17() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        long value = ((sun.nio.ch.DirectBuffer) buffer).address();
        System.out.println(value);
    }

    public static void main(String[] args) {
        afterJava17();
        priorJava17();
    }
}
