package interview.java.core.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  You have an ArrayList of integers.
 *  Write function which will accept List and return new List with unique elements.
 *  You can't use Set Implementations.
 */
public class Q_001_UniqueElementsWithoutSet {

    public static List<Integer> getUniqueElements(Iterable<Integer> list){
        List<Integer> uniqueList = new ArrayList<>();
        for(Integer element : list){
            if(!uniqueList.contains(element)){
                uniqueList.add(element);
            }
        }
        return uniqueList;
    }

    public static void main(String[] args) {
        System.out.println(getUniqueElements(Arrays.asList(11,11,23,12,1,1,1,2,2,3,4,2,3)));
    }
}
