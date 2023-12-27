package Letters;

public class h {
    public static void main(String[] args){
        
        int h=7;
        int half=(h/2)+1;
        
        int i,j;
        
        for(i=1;i<=h;i++){
            if(i!=half){
                for(j=1;j<=7;j++){
                    if(j==1 || j==7){
                        System.out.print("* ");
                    }
                    else{
                        System.out.print("  ");
                    }                    
                }
            }

            else{
                for(j=1;j<=7;j++){
                    System.out.print("* ");
                }
                
            }  
            
            System.out.println();
        }
    }
}
