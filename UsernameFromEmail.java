import java.util.*;

public class UsernameFromEmail {
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            String inp, userName = "";
            int p, i;
            System.out.print("Enter Email-id: ");
            inp = sc.nextLine();

            p = inp.indexOf('@');

            for(i=0; i<p; i++){
                userName += inp.charAt(i);
            }

            System.out.print("Your User Name is: " + userName);
            
        }
    }
}
