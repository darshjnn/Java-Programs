package Recursion;

import java.util.HashSet;

public class UniqueSubsequences {
    public static void uniqSeq(String str, int index, String newStr, HashSet<String> set){
        if (str.length() == index){
            if (set.contains(newStr)){
                return;
            } else {
                System.out.println(newStr);
                set.add(newStr);
                return;
            }
        }
        
        uniqSeq(str, index + 1, newStr + str.charAt(index), set);
        
        uniqSeq(str, index + 1, newStr, set);
        
    }
    public static void main(String args[]){
        String str = "aaa";
        HashSet<String> set = new HashSet<>();
        uniqSeq(str, 0,"" , set);
    }
}
