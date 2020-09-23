package abdulbari.practice003.array;

/**
 *  Static Array :
 *  ------------
 *  -   Size of array is fixed and decided at compile time.
 *  -   int A[5];
 *      -   created in stack.
 *  -   int[] p = new int[5];  :: Runtime Array
 *      -   p will be created inside stack.
 *      -   memory will be allocated in the heap.
 *
 *  Dynamic Array:
 *  -------------
 *  -   Size of array can be decided at runtime in C++ ,Java etc.
 *  -   Size of array is increased by creating a new bigger array and copy all the existing elements
 *      to new array.
 *  -   Existing array size can't be increased of the consecutive memory allocation which might not be free.
 *
 */
public class T_002_StaticDynamicArray {

    public static void main(String[] args) {
        arrayExample();
    }

    public static void arrayExample(){
        int[] stackArray = {1,2,3,4,5};

        int[] heapArray = new int[5];
        heapArray[0] = 1;
        heapArray[1] = 2;
        heapArray[2] = 3;
        heapArray[3] = 4;
        heapArray[4] = 5;

        for(int i=0; i<heapArray.length ; i++){
            System.out.println(stackArray[i] + " , " + heapArray[i]);
        }
    }
}
