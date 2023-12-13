package Patterns;
import java.util.*;

public class numberHalfPyramid {
    public static void main(String[] args){
        System.out.println("print solid ractangle");
            
            int r,i,j;
            
            Scanner sc= new Scanner(System.in);
            
            try{
                System.out.print("Enter number of rows: ");
                r=sc.nextInt();
                
                for(i=1;i<=r;i++){
                    for(j=0;j<i;j++){
                        System.out.print(i+" ");
                    }

                    System.out.println();
                }
            }    

            finally{
                sc.close();
            }
    }    
}
