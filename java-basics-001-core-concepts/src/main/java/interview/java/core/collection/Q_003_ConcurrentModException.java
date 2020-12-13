package interview.java.core.collection;

/**
 *  How Iterator works in java
 *  ==========================
 *  -   In Java, when you create an iterator, it starts to count the modifications that were applied
 *      on the collection. If the iterator detects that some modifications were made without using
 *      its method (or using another iterator on the same collection), it cannot guarantee anymore
 *      that it will not pass twice on the same element or skip one, so it throws this exception
 *      (ConcurrentModificationException)
 *  -   ArrayList methods always increase a counter ‘modCount‘ declared as:
 *          protected transient int modCount = 0;
 *  -   When you create an Iterator/ListIterator on arraylist, this modCount is used to initialize
 *      expectedModCount for that Iterator instance.
 *          int expectedModCount = modCount;
 *  -   Any operation done on ArrayList directly (without using iterator instance) will increase
 *      the modCount. Iterator’s all methods perform a check to validate the equality of
 *      modCount == expectedModCount – before performing the operation. If they do not match, it
 *      simply throws the exception.
 *          final void checkForCoModification() {
 *              if (modCount != expectedModCount)
 *                  throw new ConcurrentModificationException();
 *          }
 */
public class Q_003_ConcurrentModException {}
