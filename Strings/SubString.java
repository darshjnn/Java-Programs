package Strings;

import java.util.*;

public class SubString {    
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            String str, sub;

            str = "WelcomeToUjjain";
            System.out.println("Original String is: "+str);

            sub = str.substring(0, 7);
            System.out.println("Sub String is: "+sub);
            System.out.println(str);
        }
    }
}