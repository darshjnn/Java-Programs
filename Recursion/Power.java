package Recursion;

import java.util.*;

public class Power {
    public static int PowerNstack(int a, int b){          //Print x^n (with stack height = n)
        if(a==0){
            return 0;
        }
        if(b==0){
            return 1;
        }
        int pow = a*PowerNstack(a, b-1);        
        return pow;
    }

    public static int PowerlogStack(int a, int b){       //Print x^n (with stack height = logn)
        if(b==0){
            return 1;
        }
        if(b%2==0){
            return PowerlogStack(a, b/2)*PowerlogStack(a, b/2);
        }
        else{
            return a*PowerlogStack(a, b/2)*PowerlogStack(a, b/2);
        }
    }
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            int a, b;
            System.out.print("Enter Base: ");
            a = sc.nextInt();

            System.out.print("Enter Power: ");
            b = sc.nextInt();

            System.out.println(PowerNstack(a, b));
            System.out.println(PowerlogStack(a, b));
        }
    }    
}
