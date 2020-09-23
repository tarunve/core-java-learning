package abdulbari.practice003.array;

/**
 *  Array:
 *  ======
 *  ->  Collection of similar data element group under same name.
 *  ->  Contiguous block of memory.
 *  ->  Every element occupies the same amount of space in memory.
 *  ->  If an array starts at memory address x, and the size of each element in the array is y,
 *      we can calculate the memory address of the ith element by using the following expression:
 *          x+i*y
 *  ->  If we know the index of the element, the time to retrieve the element will be the same,
 *      no matter where it is in the array.
 *
 *  Big-O Values for Array Operations:
 *  ---------------------------------
 *  1.  Retrieve with index                                     :   O(1) - constant time
 *  2.  Retrieve without index                                  :   O(n) - linear time
 *  3.  Add an element to a full array                          :   O(n)
 *  4.  Add an element to the end of an array (has space)       :   O(1)
 *  5.  Insert or update an element at specific index           :   O(1)
 *  6.  Delete an element by setting it to null                 :   O(1)
 *  7.  Delete an element by shifting elements                  :   O(n)
 */
public class T_001_ArrayOverview {

    public static void main(String[] args) {
        int[] a = new int[5];
        for (int i=0; i<a.length ; i++){
            System.out.println(a[i]);
        }
    }
}
