package interview.java.core.collection;

import java.util.HashMap;
import java.util.Map;

/**
 *  HashMap:
 *  =======
 *  -   Present from Java 1.2.
 *
 *  -   Data Structure used - Array.
 *
 *  -   Data is stored as key-value pair. If you try to insert the duplicate key, it will
 *      replace the element of the corresponding key.
 *
 *  -   HashMap is similar to Hashtable but not synchronized.
 *
 *  -   It allows to store the null keys as well, but there should be only one null key object
 *      and there can be any number of null values.
 *
 *  -   Hashtable:
 *       Syntax:
 *       public class Hashtable<K,V> extends Dictionary<K,V> implements Map<K,V>, Cloneable, Serializable
 *       The initial default capacity of Hashtable class is 11 whereas loadFactor is 0.75
 *
 *  -   HashMap contains an array of Node and Node can represent a class having following objects :
 *      transient Node<K,V>[] table;
 *      1.  int hash, 2.  K key, 3.  V value, 4.  Node next
 *      Node is nothing but implementation of Map.Entry interface(LinkedList). So, in simple words,
 *      HashMap is array of LinkedList nodes.
 *
 *  -   Hashing is a process of converting an object into integer form by using the method hashCode().
 *      Its necessary to write hashCode() method properly for better performance of HashMap.
 *
 *  -   hashCode() method is used to get the hash Code of an object. hashCode() method of object class
 *      returns the memory reference of object in integer form. Definition of hashCode() method is
 *      public native hashCode(). It indicates the implementation of hashCode() is native because there
 *      is not any direct method in java to fetch the reference of object. It is possible to provide
 *      your own implementation of hashCode(). In HashMap, hashCode() is used to calculate the bucket
 *      and therefore calculate the index.
 *
 *  -   equals method is used to check that 2 objects are equal or not. This method is provided by Object
 *      class. You can override this in your class to provide your own implementation. HashMap uses
 *      equals() to compare the key whether they are equal or not.
 *
 *  -   A bucket is one element of HashMap array. It is used to store nodes. Two or more nodes can have
 *      the same bucket. In that case link list structure is used to connect the nodes. Buckets are
 *      different in capacity. A relation between bucket and capacity is as follows:
 *          capacity = number of buckets * load factor
 *      A single bucket can have more than one nodes, it depends on hashCode() method. The better
 *      your hashCode() method is, the better your buckets will be utilized.
 *
 *  -   Hash code of key may be large enough to create an array. hash code generated may be in the range
 *      of integer and if we create arrays for such a range, then it will easily cause OutOfMemoryException.
 *      So we generate index to minimize the size of array. Basically following operation is performed to
 *      calculate index.
 *          index = hashCode(key) & (n-1) , where n is number of buckets or the size of array.
 *
 *  -   HashMap improvements in Java :
 *          The principal idea is that once the number of items in a hash bucket grows beyond a certain
 *          threshold, that bucket will switch from using a linked list of entries to a balanced tree. In
 *          the case of high hash collisions, this will improve worst-case performance from O(n) to O(log n).
 *
 *  How to make good hashmap key
 *  ============================
 *  1.  The contract between hashCode() and equals():
 *      -   The very basic need for designing a good key is that “we should be able to retrieve the value
 *          object back from the map without failure“, otherwise no matter how fancy data structure you
 *          build, it will be of no use.
 *      -   Key’s hash code is used primarily in conjunction to its equals() method, for putting a key in
 *          map and then getting it back from map. So, our only focus point is these two methods. So if
 *          hash code of key object changes after we have put a key value pair in map, then its almost
 *          impossible to fetch the value object back from map. It is a case of memory leak.
 *  2.  Make HashMap key object immutable:
 *      -   Key objects are suggested to be IMMUTABLE. Immutability allows you to get same hash code every
 *          time, for a key object. So it actually solves most of the problems in one go. Also, this class
 *          must honor the hashCode() and equals() methods contract.
 *      -   This is the main reason why immutable classes like String, Integer or other wrapper classes
 *          are a good key object candidate. and it is the answer to question why string is popular hashmap
 *          key in java?
 *      -   But remember that immutability is recommended and not mandatory. If you want to make a mutable
 *          object as key in hashmap, then you have to make sure that state change for key object does not
 *          change the hash code of object. This can be done by overriding the hashCode() method. But, you
 *          must make sure you are honoring the contract with equals() also.
 *
 *  How to Synchronize HashMap in Java
 *  ==================================
 *  1.  ConcurrentHashMap :
 *      -   Our first choice should always be using the ConcurrentHashMap class if we wish to use a Map in
 *          concurrent environment. ConcurrentHashMap support concurrent access to it’s key-value pairs by
 *          design.
 *      -   Iterator obtained from ConcurrentHashMap does not throw ConcurrentModificationException. However,
 *          iterators are designed to be used by only one thread at a time. It means each iterator we obtain
 *          from a ConcurrentHashMap is designed to be used by a single thread and should not be passed around.
 *  2.  Collections.synchronizedMap() :
 *      -   SynchronizedHashMap is allows only one thread to perform read/write operations at a time because
 *          all of its methods are declared synchronized.
 *      -   ConcurrentHashMap allows multiple threads to work independently on different segments in the map.
 *          This allows higher degree of concurrency in ConcurrentHashMap and thus improve performance of the
 *          application in whole.
 *  3.  Difference between Synchronized HashMap and ConcurrentHashMap
 *      -   Multiple threads can add/remove key-value pairs from ConcurrentHashMap, while only one thread
 *          is allowed to make change in case of SynchronizedHashMap. This results higher degree of concurrency
 *          in ConcurrentHashMap.
 *      -   No need to lock the map to read a value in ConcurrentHashMap. A retrieval operation will return the
 *          value inserted by the most recent completed insert operation. A lock is required for read operation
 *          too in SynchronizedHashMap.
 *      -   ConcurrentHashMap does not throw a ConcurrentModificationException if one thread tries to modify it
 *          while another is iterating over it. The iterator reflects the state of the map at the time of it’s
 *          creation. SynchronizedHashMap returns Iterator, which fails-fast on concurrent modification.
 */
public class Q_001_HashMapInternal {

    static class HashKey{
        private final String key;

        HashKey(String key) {
            this.key = key;
        }

        @Override
        public int hashCode() {
            final int prime=31;
            int result=1;
            result = prime * result + ((key == null) ? 0 : (int)key.charAt(0));
            System.out.println("Hash of key generated : " + result);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            return key.equals(obj);
        }
    }

    public static void main(String[] args) {
        Map<HashKey, String> map = new HashMap<>();
        map.put(new HashKey("Test"), "First Value");
        System.out.println(map);

        /*
         *  Steps:
         *  =====
         *  1.  Calculate hash code of HashKey {“Tarun”}. It will be generated as 115.
         *  2.  Calculate index by using index method it will be 3 (115%16).
         *  3.  Create a node object as :
         *          {
         *              int hash = 115
         *              HashKey key = {"Tarun"}
         *              String value = "Second Value"
         *              Node next = null
         *          }
         *  4.  Place this object at index 3 if no other object is presented there.
         *  5.  In this case a node object is found at the index 3 – this is a case of collision.
         *  6.  In that case, check via hashCode() and equals() method that if both the keys are same.
         *  7.  If keys are same, replace the value with current value.
         *  8.  Otherwise connect this node object to the previous node object via linked list and
         *      both are stored at index 3.
         *      Now HashMap becomes :
         *          {HashKey@73=First Value, HashKey@73=Second Value}
         */
        map.put(new HashKey("Tarun"), "Second Value");
        System.out.println(map);

    }
}
