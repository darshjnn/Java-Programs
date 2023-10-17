
import java.util.*;

public class ReverseNumber{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int a, reverse = 0;
        System.out.print("Enter no. to reverse: ");
        a = sc.nextInt();
        
        while(a!=0){
            int num = a%10;
            reverse = (reverse * 10) + num;
            a /= 10;
        }
        
        System.out.println("Reversed no. is: "+reverse);
        
        sc.close();
    }
}