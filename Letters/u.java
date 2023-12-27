package Letters;

public class u {
    public static void main(String[] args){
        
        int h=7;
        
        int i,j;
        
        for(i=1;i<=h;i++){
            if(i<=h-2){
                for(j=1;j<=7;j++){
                    if(j==1 || j==7){
                        System.out.print("* ");
                    }
                    else{
                        System.out.print("  ");
                    }                               
                }
            }
            else if(i==h-1){
                for(j=1;j<=7;j++){
                    if(j==1 || j==6){
                        System.out.print(" *");
                    }
                    else{
                        System.out.print("  ");
                    }
                }
            }
            else{
                System.out.print("  ");
                for(j=1;j<=4;j++){
                    System.out.print(" *");
                }
            }                
            
            System.out.println();
        }
    }
}
