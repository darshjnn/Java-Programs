package Patterns;
import java.util.*;

public class parallelogram {
    public static void main(String[] args){
        System.out.println("print solid ractangle");
        
        int r,c,i,j,k;
        
        Scanner sc= new Scanner(System.in);
        
        try{
            System.out.print("Enter number of rows: ");
            r=sc.nextInt();
            
            System.out.print("Enter number of columns: ");
            c=sc.nextInt();
            
            for(i=1;i<=r;i++){
                for(j=(i-1);j>0;j--){
                    System.out.print("  ");
                }
                for(k=1;k<=c;k++){
                    System.out.print("* ");
                    
                }
                System.out.println();
            }
        }
        
        finally{
            sc.close();
        }
    }
}
