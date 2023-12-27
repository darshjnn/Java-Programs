package Letters;

public class m {
    public static void main(String[] args){
        
        int h=7;
        
        int i,j;
        
        for(i=1;i<=h;i++){
            for(j=1;j<=7;j++){
                if(j==1 || j==7 ){
                    System.out.print("* ");
                }
                else if(j==i && i<5 || j== 8-i && i<5){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            
            System.out.println();
        }
    }
}
