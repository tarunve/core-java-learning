package interview.java.core.jvm;

/**
 *  -   Total JVM memory is organized into following 5 categories.
 *  -   Method Area and Heap Area
 *
 *  Method Area:
 *  -----------
 *  -   Method Area is a part of the heap memory which is shared among all the threads.
 *  -   It creates when the JVM starts up.
 *  -   It is used to store class structure, superclass name, interface name, and
 *      constructors. The JVM stores the following kinds of information in the method area:
 *      -   A Fully qualified name of a type (ex: String)
 *      -   The type's modifiers
 *      -   Type's direct superclass name
 *      -   A structured list of the fully qualified names of super interfaces.
 *
 *  Heap Area:
 *  ---------
 *  -   For every JVM, one heap parea is available.
 *  -   Heap area will be created at the time of JVM startup.
 *  -   Objects and corresponding instance variables will be stored in heap area.
 *  -   Every array in Java is Object only. Hence, Arrays also will be stored in the heap area.
 *  -   It can be accessed by multiple threads hence not thread-safe.
 *  -   Java Application can communicate with JVM by using - java.lang.Runtime class object.
 *          Runtime r = Runtime.getRuntime();
 *          r.maxMemory()   :   Returns number of bytes of max memory allocated to Heap.
 *          r.totalMemory() :   Returns number of bytes of total memory allocated to Heap.
 *          r.freeMemory()  :   Returns number of bytes of free memory present in Heap.
 *  -   We can set the Min or Max memory as argument to Java command with below params:
 *          -Xmx    :   Max Heap Size
 *          -Xms    :   Min Heap Size
 *
 *  Stack Area:
 *  ----------
 *  -   For every thread, JVM will create a separate stack at the time of Thread creation.
 *  -   Each and every method call performed by that thread will be stored in the stack
 *      including local variables also.
 *  -   After completing a method, the corresponding entry from the stack will be removed.
 *  -   After completing all method calls, Stack will be destroyed by the JVM just before
 *      terminating the thread.
 *  -   Each entry in the stack is called StackFrame or Activation record.
 *  -   The data stored in stack is available for the thread only & hence thread-safe.
 *  -   Each StackFrame consists of 3 parts:
 *      1.  Local Variable Array:
 *          -   Contains all parameters and local variables of the method.
 *          -   Each slot in the Arrays is of 4 bytes.
 *          -   Values of type int, float, reference occupies one entry in array.
 *          -   Values of double and long occupies 2 consecutive entries in the array.
 *          -   byte , short, char values will be converted to int type before storing
 *              and occupy 1 slot.
 *          -   Storing boolean value is varied from JVM to JVM but mostly, it is 1 slot.
 *      2.  Operand Stack:
 *          -   JVM uses operand stack as workspace.
 *          -   Some instruction can push value , some can pop values and some can perform
 *              required operations.
 *      3.  Frame Data:
 *          -   It contains all the symbolic references related to that method.
 *          -   It also contains reference to exception table which provides corresponding
 *              catch block info in case of exceptions.
 *
 *  PC Registers:
 *  ------------
 *  -   For every thread, a separate PC register will be created at the time of Thread creation.
 *  -   PC registers contains the address of current executing instruction.
 *  -   Once instruction execution completes, automatically PC register will be incremented to
 *      hold address of next instruction.
 *
 *  Native Method Stacks:
 *  --------------------
 *  -   For every thread, a separate native method stack will be created by JVM.
 *  -   All native method calls invoked by the thread will be stored in the corresponding
 *      native method stack.
 */
public class Q_003_JVMMemory {}
