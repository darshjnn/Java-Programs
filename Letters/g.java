package Letters;

public class g {
    public static void main(String[] args){
        
        int h=7;
        
        int i,j,k;
        
        for(i=1;i<=h;i++){
            if(i==1){
                System.out.print("  ");
                for(k=1;k<7;k++){
                    System.out.print("* ");
                }
            }
            
            else{
                for(j=1;j<=7;j++){
                    if(j==1 || j==5 && i>4 || i==h && j<=5){
                        System.out.print(" *");
                    }
                    else if(i==5 && j==4 || i==5 && j>=6){
                        System.out.print(" *");
                    }
                    else if(i>=6 && j==7){
                        System.out.print(" *");
                    }
                    else{
                        System.out.print("  ");
                    }
                }
            }
            
            System.out.println();
        }
    }
}
