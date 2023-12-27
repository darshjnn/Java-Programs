package Letters;

public class d {
    public static void main(String[] args){
        
        int h=7;
        
        int i,j;
        
        for(i=1;i<=h;i++){
            for(j=1;j<=7;j++){
                if(i==1 || i==h){
                    System.out.print("* ");
                }
                else if(i>=2 && j==2 || j==7){
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
