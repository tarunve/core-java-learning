package abdulbari.practice003.array;

import java.util.logging.Level;
import java.util.logging.Logger;

public class T_005_Problems_2 {

    private static final Logger LOGGER = Logger.getLogger(T_005_Problems_2.class.getName());

    /**
     *  Find duplicate and print
     *  Time complexity : O(n)
     */
    public static void printDuplicates(int[] array){
        int lastDuplicate=0;
        for (int i=0; i< array.length-1 ; i++){
            if(array[i] == array[i+1] && array[i] != lastDuplicate){
                LOGGER.log(Level.SEVERE, String.format(" Duplicated :: %s", String.valueOf(array[i])));
                lastDuplicate = array[i];
            }
        }
    }

    public static void printDuplicatesAndCount(int[] array){
        int j;
        for (int i=0; i< array.length-1 ; i++){
            if(array[i] == array[i+1]){
                j = i+1;
                while(array[j] == array[i]){
                    j++;
                }
                LOGGER.log(Level.SEVERE, String.format(" %d is appearing %d times",array[i], j-i));
                i = j-1;
            }
        }
    }

    public static void findDuplicatesAndCountInUnsortedArray(int[] array){
        int max=array[0];
        for (int i=0; i< array.length ; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        int[] newArr = new int[max+1];
        for (int i=0; i< array.length ; i++) {
            newArr[array[i]]++;
        }
        for (int i=0; i< newArr.length ; i++) {
            if(newArr[i] > 1){
                LOGGER.log(Level.SEVERE, String.format(" %d is appearing %d times", i , newArr[i]));
            }
        }
    }

    public static void findPairWithSumK(int[] array, int sum){
        int i=0, j=array.length-1;
        while(i<j){
            if(array[i] + array[j] == sum){
                LOGGER.log(Level.SEVERE, String.format(" %d + %d = %d", array[i] ,array[j], sum));
                i++;
                j--;
            } else if(array[i] + array[j] < sum) {
                i++;
            } else {
                j--;
            }
        }

    }

    public static void main(String[] args) {
        int[] array1 = {6,7,8,8,9,11,12,12,12,12,13,14};
        printDuplicates(array1);
        printDuplicatesAndCount(array1);
        int[] array2 = {6,7,8,8,8,9,9,11,11,11,12,12,12,12,12,13,14};
        findDuplicatesAndCountInUnsortedArray(array2);
        findPairWithSumK(array2, 16);
    }
}
