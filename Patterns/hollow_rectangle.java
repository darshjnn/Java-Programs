package Patterns;
import java.util.*;

public class hollow_rectangle {
    public static void main(String[] args){
        System.out.println("print solid ractangle");
        
        int r,c,i,j;
        
        Scanner sc= new Scanner(System.in);
        
        try{
            System.out.print("Enter number of rows: ");
            r=sc.nextInt();
            
            System.out.print("Enter number of columns: ");
            c=sc.nextInt();

            for(i=0;i<r;i++){
                for(j=0;j<c;j++){
                    if(i==0 || i==(r-1) || j==0 || j==(c-1)){
                        System.out.print("* ");
                    }

                    else{
                        System.out.print("  ");
                    }
                }

                System.out.println();
            }
        }
        
        finally{
            sc.close();
        }
    }
}