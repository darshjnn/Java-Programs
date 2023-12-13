package Patterns;
import java.util.*;

public class Inverted_Rotated_Half_Pyramid {
    public static void main(String[] args){
        System.out.println("print solid ractangle");
        
        int r,i,j,k;
        
        Scanner sc= new Scanner(System.in);
        
        try{
            System.out.print("Enter number of rows: ");
            r=sc.nextInt();
            
            for(i=r;i>0;i--){
                for(k=0;k<(i-1);k++){
                    System.out.print("  ");
                }
                for(j=(r-i+1);j>0;j--){
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