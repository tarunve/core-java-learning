package abdulbari.practice003.array;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  ArrayADT:
 *  ========
 *  ->  Data Structure - data representation and the operations together forms an ADT.
 *  ->  Data Representation :: Array Space , Size, Length(number of elements)
 *      Data Operations     :: display(), add(x), insert(int index), search(x) etc.
 *
 *  Binary Search:
 *  --------------
 *  ->  Formulae for mid : (l+h)/2
 *        where l = low or first index
 *              h = high or last index
 *  ->  Number of comparison - logn
 *  ->  Number of comparison depends on height of tree.
 *  ->  Best Case Time - O(1) , Worst Case - O(logn)
 *  ->  Time Complexity - ceil(log(n+1)) (base 2)
 *
 */
public class T_004_ArrayADT {

    private static final Logger LOGGER = Logger.getLogger(T_004_ArrayADT.class.getName());

    static class Array {
        private final int[] a;
        private int size;
        private final int length;

        Array(){
            this.a = new int[10];
            this.size = 0;
            this.length = 10;
        }

        Array(int length){
            this.a = new int[length];
            this.size = 0;
            this.length = length;
        }

        public void insert(int index, int value){
            int i;
            if(index >= 0 && index < length){
                for (i = length-1 ; i>index ; i--){
                    a[i] = a[i-1];
                }
                a[index] = value;
                size++;
            } else{
                throw new ArrayIndexOutOfBoundsException("Array out of Range");
            }
        }

        public void append(int value){
            if(size < length){
                a[size] = value;
                size++;
            }
        }

        public int delete(int index){
            int x=0;
            if(index >= 0 && index < length){
                x = a[index];
                for(int i=index; i<length-1 ; i++){
                    a[i] = a[i+1];
                }
                size--;
                return x;
            }
            return 0;
        }

        public int linearSearch(int key){
            for(int i=0; i<length ; i++) {
                if(key == a[i]){
                    return i;
                }
            }
            return -1;
        }

        public int binarySearchIterative(int[] arr,int low, int high, int key){
            int mid = 0;
            while(low <= high){
                mid = (low+high)/2;
                if(key == arr[mid]){
                    return mid;
                } else if(key < arr[mid]){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
            return -1;
        }

        public int binarySearchRecursive(int[] arr,int low, int high, int key){
            int mid = 0;
            if(low <= high){
                mid = (low+high)/2;
                if(key == arr[mid]){
                    return mid;
                } else if(key < arr[mid]){
                    return binarySearchRecursive(arr, low, mid-1, key);
                } else {
                    return binarySearchRecursive(arr, mid+1, high, key);
                }
            }
            return -1;
        }

        public int getElement(int index){
            if(index >= 0 && index < length){
                return a[index];
            }
            return -1;
        }

        public void setElement(int index, int value){
            if(index >= 0 && index < length){
                a[index] = value;
            }
        }

        public int maxElement(){
            int max = a[0];
            int i;
            for(i=1; i<length; i++){
                if(a[i] > max){
                    max = a[i];
                }
            }
            return max;
        }

        public int minElement(){
            int min = a[0];
            int i;
            for(i=1; i<length; i++){
                if(a[i] < min){
                    min = a[i];
                }
            }
            return min;
        }

        public int[] reverseArray(){
            int[] b = new int[length];
            for(int i=length-1 , j=0; i>=0; i--, j++){
                b[j] = a[i];
            }
            return b;
        }

        public int[] mergerArrays(int[] arrayA, int[] arrayB){
            int[] arrayC = new int[arrayA.length + arrayB.length];
            int i=0, j=0, k=0;
            while(i < arrayA.length && j< arrayB.length){
                if(arrayA[i] < arrayB[j]){
                    arrayC[k++] = arrayA[i++];
                } else {
                    arrayC[k++] = arrayB[j++];
                }
            }
            for(;i<arrayA.length; i++){
                arrayC[k++] = arrayA[i];
            }
            for (; j<arrayB.length; j++){
                arrayC[k++] = arrayB[j];
            }
            return arrayC;
        }

        public int getSize() {
            return size;
        }

        public int getLength() {
            return length;
        }

        @Override
        public String toString() {
            return "Array{" + Arrays.toString(a) + "}";
        }
    }



    public static void main(String[] args) {
        Array arr = new Array();
        arr.insert(0, 12);
        arr.insert(5, 45);
        arr.insert(9, 45);
        arr.append(34);
        LOGGER.log(Level.SEVERE, arr.toString());
        LOGGER.log(Level.SEVERE, String.valueOf(arr.getElement( 4)));
        Arrays.sort(arr.a);
        LOGGER.log(Level.SEVERE, String.format("Key is present at index Binary Search Iterative:: %d",
                arr.binarySearchIterative(arr.a,0, arr.length-1,45)));
        LOGGER.log(Level.SEVERE, Arrays.toString(arr.reverseArray()));


        Array arr2 = new Array(5);
        arr2.insert(0, 12);
        arr2.insert(1, 45);
        arr2.append(23);
        arr2.append(2);
        LOGGER.log(Level.SEVERE, arr2.toString());
        arr2.delete( 1);
        LOGGER.log(Level.SEVERE, arr2.toString());
        LOGGER.log(Level.SEVERE, String.format("Key is present at index Linear Search :: %d", arr2.linearSearch(23)));
        Arrays.sort(arr2.a);
        LOGGER.log(Level.SEVERE, String.format("Key is present at index Binary Search Recursive:: %d",
                arr2.binarySearchRecursive(arr2.a,0, arr2.length-1,0)));

        LOGGER.log(Level.SEVERE, String.format("Merged Array :: %s", Arrays.toString(arr.mergerArrays(arr.a, arr2.a))));
    }
}


