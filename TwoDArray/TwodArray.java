package TwoDArray;

import java.util.*;

public class TwodArray {
    public static void Print2dArray(float arr[][]){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void Search2dArray(float arr[][],float x){
        int y = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]==x){
                    y+=1;
                    System.out.println("Element occured at ["+i+"]["+j+"]");
                }
            }                 
        }
        System.out.println("Element occured " +y+ " times...");
    }
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){ 
            int row, column, i, j, a;
            float element;
            
            System.out.print("Enter number of Rows: ");
            row = sc.nextInt();
            
            System.out.print("Enter number of Columns: ");
            column = sc.nextInt();
            
            float arr[][] = new float[row][column];
            
            for(i=0; i<row; i++){
                for(j=0; j<column; j++){
                    System.out.print("Enter ["+i+"]["+j+"] element: " );
                    arr[i][j] = sc.nextFloat();
                }
                System.out.println();
            }
            Print2dArray(arr);

            System.out.print("Enter 1 to search element, else press any key: ");
            a = sc.nextInt();

            if(a==1){
                System.out.print("Enter element to be searched: ");
                element = sc.nextFloat();

                Search2dArray(arr, element);
            }        
        } 
    }
}
