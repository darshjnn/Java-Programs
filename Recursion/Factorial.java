package Recursion;

import java.util.*;

public class Factorial{
    public static int fact(int a){
        if(a==1 || a==0){
            return 1;
        }
        else if(a<0){
            System.out.println("Invalid number");
            return 0;
        }
        else{
            return a*fact(a-1);
        }
    }

    public static void main(String[] srgs){
        int a;
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number to find factorial: ");
        a = sc.nextInt();


        System.out.println("Factorial is : "+fact(a));

        sc.close();

    }
}