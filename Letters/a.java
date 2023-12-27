package Letters;

public class a {
    public static void main(String[] args){
        
        int h=7;
        int half=(h/2)+1;
        
        int i,j,k;
        
        for(i=1;i<=h;i++){
            for(j=0;j<h-i;j++){
                System.out.print(" ");
            }
            if(i!= half){
                
                for(k=1;k<=15;k++){
                    if(k==(2*i)-1 || k==1 && k<=i+1){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }      
                
            }
            else{
                for(k=1;k<i+1;k++){
                    System.out.print("* ");
                }
            }
            
            System.out.println();
        }
    }
    
}
