package TwoDArray;

import java.util.*;

public class Transpose {
    public static void Print2dArray(int arr[][]){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            int i, j, row, column;
            
            System.out.print("Enter number of rows: ");
            row = sc.nextInt();
            
            System.out.print("Enter number of column: ");
            column = sc.nextInt();
            
            int arr[][] = new int[row][column];
            int arr2[][] = new int[row][column];
            
            System.out.println();
            
            for(i=0; i<row; i++){
                for(j=0; j<column; j++){
                    System.out.print("Enter [" +i+ "][" +j+ "]: ");
                    arr[i][j] = sc.nextInt();
                }
                System.out.println();
            }
            
            System.out.println("Entered matrix is: ");
            Print2dArray(arr);

            
            System.out.println("Transpose of matrix is: ");
            for(i=0; i<row; i++){
                for(j=0; j<column; j++){
                    arr[i][j] = arr2[j][i];
                }
            }

            Print2dArray(arr2);

        }    
    }
}