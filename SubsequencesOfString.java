//Time Complexity: O(2^n)

public class SubsequencesOfString {
    
    public static void Subsequences(String str, int index, String newstr){
        if (index == str.length()){
            System.out.println(newstr);
            return;
        }
        //to be in subsequence
        Subsequences(str, index+1, newstr + str.charAt(index));
        
        //to not be in subsequence
        Subsequences(str, index+1, newstr);
    }
    
    public static void main(String args[]){
        String str = "abc";
        Subsequences(str, 0, "");
    }
    
}
