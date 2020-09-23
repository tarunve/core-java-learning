package abdulbari.practice003.array;

import java.util.logging.Level;
import java.util.logging.Logger;

public class T_005_Problems_1 {

    private static final Logger LOGGER = Logger.getLogger(T_005_Problems_1.class.getName());

    /*
     *  ->  Find single missing number
     *      -   First way : take sum of first N natural numbers and subtract from sum of array elements.
     *      -   Second way : take the difference from first element and index. Check for all elements if
     *          any index has difference not equal to the first one.
     *  ->  One scan is needed so time complexity - O(n)
     */
    public static void findSingleMissingElement(int[] array){
        int diff = array[0];
        for(int i=0; i< array.length; i++){
            if(array[i] - i != diff){
                LOGGER.log(Level.SEVERE, String.format("Missing number is :: %d", i + diff));
                return;
            }
        }
    }

    public static void findMultipleMissingElement(int[] array){
        int diff = array[0];
        for(int i=0; i< array.length; i++){
            if(array[i] - i != diff){
                while(diff < array[i] - i) {
                    LOGGER.log(Level.SEVERE, String.format("Missing number is :: %d", i + diff));
                    diff++;
                }
            }
        }
    }

    private static void findMissingElementInUnsortedArray(int[] array) {
        int max = array[0];
        int min = array[0];
        for(int i=0; i< array.length; i++){
            if(array[i] > max){
                max = array[i];
            } else if(array[i] < min){
                min = array[i];
            }
        }

        int[] newArr = new int[max+1];
        for(int i=0; i< array.length; i++){
            newArr[array[i]] = 1;
        }
        for(int i=0; i< newArr.length; i++){
            if(newArr[i] == 0 && i > min && i < max){
                LOGGER.log(Level.SEVERE, String.format("Missing number is :: %d",i));
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = {6,7,8,9,11,12,13,14};
        findSingleMissingElement(array1);
        int[] array2 = {6,7,8,9,11,14};
        findMultipleMissingElement(array2);
        int[] array3 = {3,7,4,9,12,6,1,11,2,10};
        findMissingElementInUnsortedArray(array3);
    }
}
