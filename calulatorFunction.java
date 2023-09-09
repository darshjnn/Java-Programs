import java.util.*;

public class CalulatorFunction {
    public static void calc(Double a, Double b, char op){
        Double out;
        if(op=='+'){
             out=a+b;
             System.out.println("Sum is: " +out);
        }
        else if(op=='-'){
            out=a-b;
            System.out.println("Subtraction is: " +out);
        }
        else if(op=='*'){
            out=a*b;
            System.out.println("Product is: " +out);
        }
        else if(op=='/'){
            out=a/b;
            System.out.println("Division is: " +out);
        }
        else if(op=='%'){
            out=a%b;
            System.out.println("Remainder is: " +out);
        }
        else if(op=='^'){
            out=Math.pow(a, b);
            System.out.println("Exponent of " +a+ " raised to " +b+ " is: " +out);
        }
        else{
            System.out.println("Error: Enter valid operation...");
        }
    }
    
    public static void main(String[] args){
        char op;
        Double a,b;
        
        Scanner sc=new Scanner(System.in);
        Scanner ope=new Scanner(System.in);
        
        System.out.print("Enter a: ");
        a=sc.nextDouble();
        
        System.out.print("Enter b: ");
        b=sc.nextDouble();
        
        System.out.println("Enter operation(+,-,*,/,%,^)");
        op=ope.next().charAt(0);

        calc(a,b,op);
        
        sc.close();
        ope.close();
    }
}
