package Patterns;
import java.util.*;

public class palindromicNumberPyramid {
    public static void main(String[] args){
        System.out.println("print solid ractangle");
        
        int r,i,j,k;
        
        
        Scanner sc= new Scanner(System.in);
        
        try{
            System.out.print("Enter number of rows: ");
            r=sc.nextInt();

            for(i=1;i<=r;i++){
                for(j=0;j<r-i;j++){
                    System.out.print("  ");
                }
                for(k=i;k>=1;k--){
                    System.out.print(" "+k);
                }
                for(k=2;k<=i;k++){
                    System.out.print(" "+k);
                }
                System.out.println();
            }    
        }
        
        finally{
            sc.close();
        }
    }  
}  
