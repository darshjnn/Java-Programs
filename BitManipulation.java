import java.util.*;

public class BitManipulation {
    public static void main(String args[]){

        int a = 5; //0101
        int BitMask, pos = 2;
        BitMask = 1<<pos;

        //Git Bit
        if((BitMask & a) == 0){
            System.out.println("Bit was 0");
        }
        else{
            System.out.println("Bit was 1");
        }

        //Set Bit
        int newa = BitMask | a;
        System.out.println("Number after Set Bit operation: " + newa);

        //Clear Bit
        int cleara = (~BitMask) & a;
        System.out.println("Number after Clear Bit Operation: " + cleara);

        //Update Bit
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Operation(0 or 1): ");
        int operation = sc.nextInt();

        if(operation == 1){
            //Set Operation
            newa = BitMask | a;
            System.out.println("Number after Update Bit operation: " + newa);
        }
        else{
            //Clear Operation
            cleara = (~BitMask) & a;
            System.out.println("Number after Update Bit Operation: " + cleara);
        }
        sc.close();
    }
}
