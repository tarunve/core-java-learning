package abdulbari.practice004.string;

/**
 *  ->  Using Recursion , we can achieve backtracking.
 *  ->  By backtracking, we can achieve brute force.
 */
public class T_002_Problems_1 {

    public static void main(String[] args) {
        //Palindrome
        System.out.println(isPalindrome("abaaaaba"));
        System.out.println(isPalindrome("abaavaba"));

        //find duplicates in a string
        findDuplicateChars("sdhuhhewre");

        //find if strings are anagram
        System.out.println(isAnagram("tesat", "tseta"));
        System.out.println(isAnagram("tesat", "tsetb"));

        //print permutations
        permutations("abc", 0, 2);
    }

    //T(n) = O(n)
    public static boolean isPalindrome(String str){
        int i=0;
        int j=str.length()-1;
        while(i<=j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void findDuplicateChars(String str){
        char[] strArr = str.toCharArray();
        int[] hashtable = new int[26];
        for(int i=0; i<strArr.length; i++){
            hashtable[strArr[i]-97] += 1;
        }
        for(int i=0; i<26; i++){
            if(hashtable[i] >1){
                System.out.println(((char)i+97) +  " " + hashtable[i]);
            }
        }
    }

    public static boolean isAnagram(String str1, String str2){
        char[] arrA = str1.toCharArray();
        char[] arrB = str2.toCharArray();
        int[] hashtable = new int[26];
        int i;

        for(i=0; i<arrA.length; i++){
            hashtable[arrA[i]-97] += 1;
        }

        for(i=0; i<arrB.length; i++){
            hashtable[arrB[i]-97] -= 1;
        }

        for(i=0; i<26; i++){
            if(hashtable[i] != 0){
                return false;
            }
        }
        return true;
    }


    public static void permutations(String str, int l, int r){
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permutations(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
