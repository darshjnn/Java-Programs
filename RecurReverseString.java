//Reverse String Using Recursion

import java.util.*;

public class RecurReverseString {
    public static String stringReverse(String str){
        if (str.length() == 1){
            return str;
        }

    char sparestr = str.charAt(0);
    String newstr = stringReverse(str.substring(1));
    return newstr + sparestr;
    }
    public static void main(String args[]){
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String to reverse: ");
        str = sc.nextLine();

        System.out.println("Reversed String: " +stringReverse(str));

        sc.close();
    }
}
