import java.util.*;

public class ScoreTester{
    public static void main(String[] args){
        
        System.out.println("To sum up score, enter 1; to exit, enter 0");
        
        Scanner sc= new Scanner(System.in);
        
        double sum=0.0;
        int i,a=1;
        
        try{
            for(i=0;i<=100;i++){
                
                System.out.print("enter score: ");
                sum+=sc.nextDouble();          
                
                if(sum>=100){
                    System.out.println("marks should be <= 100...");
                    a=0;
                    break;
                }
                
                System.out.println("enter 1 to add more, else enter 0");
                a=sc.nextInt();
                
                if(a==0){
                    break;
                } 
                
                else if(a==1){
                    continue;
                }
                
                else{
                    System.out.println("enter valid input");
                    continue;
                }          
            }
            
            System.out.println("Total score: "+sum);
            
            if(sum>=90 && sum<=100){
                System.out.println("This is Good");
            }
            
            else if(sum<=89 && sum>=60){
                System.out.println("This is also Good");
            }
            
            else if(sum>=0 && sum<=59){
                System.out.println("This is Good as well");
            } 
            
            else{
                System.out.println("Error: Enter valid score...");
            }
        }
        
        finally{
            sc.close();
        }      
    }
}