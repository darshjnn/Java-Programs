package Recursion;

import java.util.*;

public class PrintNumber {
    public static void ReverseOrder(int a){
        if(a==0){
            return;
        }
        System.out.print(a + " ");
        ReverseOrder(a-1);
    }

    public static void ForwardOrder(int a, int i){
        if(i==a+1){
            return;
        }
        System.out.print(i + " ");
        i++;
        ForwardOrder(a, i);
    } 
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            int a;
            System.out.print("Enter number to start with: ");
            a = sc.nextInt();
            System.out.println("Numbers in reverse order: ");
            ReverseOrder(a);

            System.out.println();

            System.out.println("Numbers in reverse order: ");
            ForwardOrder(a, 1);
        }
    }
    
}
