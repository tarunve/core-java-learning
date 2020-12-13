package interview.java.core.collection;

/**
 *
 *  =>   Difference between HashMap, TreeMap, LinkedHashMap
 *      --------------------------------------------------
 *  -   All three classes implement the Map interface and offer mostly the same functionality.
 *  -   The most important difference is the order in which iteration through the entries will happen:
 *      -   HashMap makes absolutely no guarantees about the iteration order. It can (and will)
 *          even change completely when new elements are added.
 *      -   TreeMap will iterate according to the "natural ordering" of the keys according to their
 *          compareTo() method (or an externally supplied Comparator). Additionally, it implements
 *          the SortedMap interface, which contains methods that depend on this sort order.
 *      -   LinkedHashMap will iterate in the order in which the entries were put into the map "Hashtable"
 *          is the generic name for hash-based maps.
 *      -   In the context of the Java API, Hashtable is an obsolete class from the days of Java 1.1
 *          before the collections framework existed. It should not be used anymore, because its API
 *          is cluttered with obsolete methods that duplicate functionality, and its methods are
 *          synchronized (which can decrease performance and is generally useless). Use ConcurrentHashMap
 *          instead of Hashtable.
 *          ╔══════════════╦═════════════════════╦═══════════════════╦═════════════════════╗
 *          ║   Property   ║       HashMap       ║      TreeMap      ║     LinkedHashMap   ║
 *          ╠══════════════╬═════════════════════╬═══════════════════╬═════════════════════╣
 *          ║ Iteration    ║  no guarantee order ║ sorted according  ║                     ║
 *          ║   Order      ║ will remain constant║ to the natural    ║    insertion-order  ║
 *          ║              ║      over time      ║    ordering       ║                     ║
 *          ╠══════════════╬═════════════════════╬═══════════════════╬═════════════════════╣
 *          ║  Get/put     ║                     ║                   ║                     ║
 *          ║   remove     ║         O(1)        ║      O(log(n))    ║         O(1)        ║
 *          ║ containsKey  ║                     ║                   ║                     ║
 *          ╠══════════════╬═════════════════════╬═══════════════════╬═════════════════════╣
 *          ║              ║                     ║   NavigableMap    ║                     ║
 *          ║  Interfaces  ║         Map         ║       Map         ║         Map         ║
 *          ║              ║                     ║    SortedMap      ║                     ║
 *          ╠══════════════╬═════════════════════╬═══════════════════╬═════════════════════╣
 *          ║              ║                     ║                   ║                     ║
 *          ║     Null     ║       allowed       ║    only values    ║       allowed       ║
 *          ║ values/keys  ║                     ║                   ║                     ║
 *          ╠══════════════╬═════════════════════╩═══════════════════╩═════════════════════╣
 *          ║              ║   Fail-fast behavior of an iterator cannot be guaranteed      ║
 *          ║   Fail-fast  ║ impossible to make any hard guarantees in the presence of     ║
 *          ║   behavior   ║           un-synchronized concurrent modification              ║
 *          ╠══════════════╬═════════════════════╦═══════════════════╦═════════════════════╣
 *          ║              ║                     ║                   ║                     ║
 *          ║Implementation║      buckets        ║   Red-Black Tree  ║    double-linked    ║
 *          ║              ║                     ║                   ║       buckets       ║
 *          ╠══════════════╬═════════════════════╩═══════════════════╩═════════════════════╣
 *          ║      Is      ║                                                               ║
 *          ║ synchronized ║              implementation is not synchronized               ║
 *          ╚══════════════╩═══════════════════════════════════════════════════════════════╝
 */
public class Q_002_DiffTreeLinkedHashMap {}
