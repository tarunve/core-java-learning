package abdulbari.practice004.string;

/**
 *  ASCII - American Standard Codes of Information and Interchange
 *  -----
 *  -   For English language.
 *  -   Same across all regions and platforms.
 *  -   Example : A-65, B-66, a-97, c-99 etc.
 *  -   0-127 = 8 bits
 *
 *  unicodes
 *  --------
 *  -   2 bytes = 16 bits
 *  -   National codes for any language. Example : Hindi letters.
 */
public class T_001_StringOverview {

    public static void main(String[] args) {
        char ch = 'A';
        System.out.println(String.format("Character %c", ch));
        System.out.println(String.format("Character %d", (int)ch));

        System.out.println(isValidPassword("Tarun".toCharArray()));
        System.out.println(isValidPassword("Tarun@".toCharArray()));

        System.out.println(reverse("Tarun"));
    }

    public static int length(String str){
        return str.toCharArray().length;
    }

    public static boolean isValidPassword(char[] pass){
        int i=0;
        for(i=0; i<pass.length && pass[i] != '\0'; i++){
            if(!(pass[i] >= 65 && pass[i] <=90) && !(pass[i] >= 97 && pass[i] <=122) && !(pass[i] >= 48 && pass[i] <=57)){
                return false;
            }
        }
        return true;
    }

    public static String reverse(String str){
        char[] chArr = str.toCharArray();
        int j = chArr.length-1;
        int i=0;
        while(i<j){
            char temp = chArr[i];
            chArr[i] = chArr[j];
            chArr[j] = temp;
            i++;
            j--;
        }
        return new String(chArr);
    }
}
