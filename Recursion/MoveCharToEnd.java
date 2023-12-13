//Move a character to the end of the string
//Time Complexity: O(n)

public class MoveCharToEnd {

    public static int count = 0; 

    public static String moveString(String str, char ele, int index, int count){
        if (index == str.length()){
            return addEle(count);
        }

        if (str.charAt(index) == ele){
            return moveString(str, ele, index + 1, count + 1);
        } else {
            return str.charAt(index) + moveString(str, ele, index + 1, count);
        }
    }

    public static String addEle (int count){
        String newStr = "x";
        for (int i = 0; i <= count; i++){
            newStr += "x";
        }
        return newStr;
    } 
    public static void main(String args[]) {
        String str = "xxyjjdkxdxljka";
        char el = 'x';
        System.out.println(moveString(str, el, 0, 0));
    }
}