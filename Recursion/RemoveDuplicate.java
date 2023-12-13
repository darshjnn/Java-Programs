public class RemoveDuplicate {
    
    public static boolean[] map = new boolean[26];
    public static String newStr = "";
    
    public static String removeDups(String str, int index){
        if (index == str.length()){
            return newStr;
        }
        
        if (map[str.charAt(index) - 'a']){         // OR if (map[str.charAt(index) - 'a'] == true)
        removeDups(str, index + 1);
    } else {
        map[str.charAt(index) - 'a'] = true;
        newStr += str.charAt(index);
        removeDups(str, index + 1);
    }
    return newStr;
}
public static void main(String args[]){
    String str = "aabcdebcdefgh";
    System.out.println(removeDups(str, 0));
}
}


// OR
// public static String removeDuplicates(String str, int idx, boolean present[]) {
    //     if(idx == str.length()) {
        //         return ""; 
        //     }
        //     char curr = str.charAt(idx); 
        //     if(present[curr-'a']) {
            //         return removeDuplicates(str, idx+1, present); 
            //     } else {
                //         present[curr-'a'] = true;
                //         return curr + removeDuplicates(str, idx+1, present); 
                //     }
                // }