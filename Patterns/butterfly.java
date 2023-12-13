package Patterns;
import java.util.*;

public class butterfly {
    public static void main(String[] args){
        int i,j,k,r;

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        r=sc.nextInt();

        try{
            for(i=r;i>0;i--){
                for(j=0;j<=(r-i);j++){
                    System.out.print(" *");
                }
                for(k=0;k<i-1;k++){
                    System.out.print("    ");
                }
                for(j=r-i+1;j>0;j--){
                    System.out.print(" *");
                }
                System.out.println();
            }

            for(i=0;i<r;i++){
                for(j=r-i;j>0;j--){
                    System.out.print(" *");
                }
                for(k=i-1;k>=0;k--){
                    System.out.print("    ");
                }
                for(j=r-i;j>0;j--){
                    System.out.print(" *");
                }
                System.out.println();
            }
        }

        finally{
            sc.close();
        }
    }
    
}
