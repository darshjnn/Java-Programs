package Letters;

public class r {
    public static void main(String args[]){
        int h=7;
        
        int i,j,k;
        
        for(i=1;i<=h;i++){
            for(j=1;j<=7;j++){
                if(j==1){
                    System.out.print("* ");                   
                    
                }
                else if(j>1 && j<7 && i==1){
                    System.out.print("* ");
                }   
                else if(i==2 && j>1 && j<7){
                    System.out.print("  ");
                }      
                else if(i==3 && j>1 && j<6){
                    System.out.print("  ");
                }      
                else if(i==4 && j>1 && j<6){
                    System.out.print("* ");
                }
            }
            if(i==2 || i==3){
                System.out.print("*");
            }
            else if(i>4 && i<8){
                    for(k=1;k<i;k++){
                        for(j=0;j<k;j++){
                            System.out.print("  ");
                        }                        
                    }
                    System.out.print("*");
                }
            System.out.println();
        }
    }
}

