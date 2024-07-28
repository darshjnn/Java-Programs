//To find first and last occurrence of an element using recursion
package Recursion;

public class Occurence {    

    public static int first = -1;
    public static int last = -1;

    public static void getIndices(String string, char element, int index){
        if (index == string.length()){
            return;
        }

        if (string.charAt(index) == element){
            if (first == -1){
                first = index;
            } else{
                last = index;
            }
        }

        getIndices(string, element, index+1);
    }
    public static void main(String[] args) {
        char el = 't';
        String str = "timbaktutu";
        getIndices(str, el, 0);
        System.out.println("First Occurence: " + first);
        System.out.println("Last Occurence: " + last);
    }
}
