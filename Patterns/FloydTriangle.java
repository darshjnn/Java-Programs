package Patterns;

import java.util.Scanner;

public class FloydTriangle {
    public static void main(String[] args){
        System.out.println("print solid ractangle");
        
        int r,i,j;
        int no=1;
        
        Scanner sc= new Scanner(System.in);
        
        try{
            System.out.print("Enter number of rows: ");
            r=sc.nextInt();
            
            for(i=0;i<=r;++i){
                for(j=0;j<i;j++){
                    System.out.print(no+" ");
                    no++;
                }
                
                System.out.println();
            }
        }    
        
        finally{
            sc.close();
        }
    }
}
