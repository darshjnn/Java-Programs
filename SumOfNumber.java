package Recursion;

import java.util.*;

public class SumOfNumber {
    
    public static void Sum(int a, int s){
        if(a==0){
            System.out.println(s);
            return;
        }
        s+=a;
        Sum(a-1,s);
    }
    
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter number upto where sum needs to be calculated: ");
            int a = sc.nextInt(); 
            System.out.print("Sum is: ");
            Sum(a,0);           
        }
    }    
}
