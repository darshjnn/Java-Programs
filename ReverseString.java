import java.util.*;

public class ReverseString {
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            String str1, str2 = "";

            System.out.print("Enter String to reverse: ");
            str1 = sc.nextLine();

            for(int i=str1.length()-1; i>=0; i--){
                str2+= str1.charAt(i);
            }

            System.out.println("Reversed String is: "+str2);
        }
    }    
}
