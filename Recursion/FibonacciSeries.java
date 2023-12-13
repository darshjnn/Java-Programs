import java.util.*;

public class FibonacciSeries {
    public static void Fibonacci(int a, int b, int c){
        if(a==0){
            return;
        }
        System.out.print(b + " ");
        Fibonacci(a-1, b+c, b);
    }
    public static void main(String atgs[]){
        try(Scanner sc = new Scanner(System.in)){
            int a;
            System.out.print("Enter number of elements: ");
            a = sc.nextInt();

            Fibonacci(a,0,1);
        }        
    }    
}