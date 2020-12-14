package interview.java.core.collection;

/**
 *  -   Which sorting technique does Arrays.sort() method implies:
 *      -   sort method with primitive type arrays: PivotQuickSort (quick sort)
 *          -   This algorithm offers O(n log(n)) average time complexity. That's a
 *              great average sorting time for many collections to have. Moreover, it
 *              has the advantage of being completely in place, so it does not require
 *              any additional storage.
 *          -   Though, in the worst case, its time complexity is O(n2).
 *      -   sort method with Object[] : TimSort algorithm
 *          -   TimSort makes use of the Insertion sort and the MergeSort algorithms.
 *          -   time complexity of O(n log(n)).
 *          -   However, it is still slower compared to other sorting algorithms like
 *              some of the QuickSort implementations.
 *
 *  -   Collections.sort():
 *      -   method with List<T> argument sort in ascending order.
 *      -   method with List<T>, Comparator<? extends T> argument sort in custom order.
 *      -   Both these methods internally used Arrays.sort() method (Object[] arg).
 *
 */
public class Q_004_ArrayCollectionUtilSorting {
}
