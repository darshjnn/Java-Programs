package TwoDArray;

import java.util.*;

public class PrintSpiralMatrix {
    public static void Print2dArray(float arr[][]){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){ 
            int row, column, i, j;
            
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
            
            //Spiral Matrix Process
            System.out.println("Spiral order matrix of above matrix is: ");

            int rowStart = 0, rowEnd = row-1, columnStart = 0, columnEnd = column-1;
            
            while(rowStart<=rowEnd && columnStart<=columnEnd){
                //1
                for(i = columnStart; i<=columnEnd;i++){
                    System.out.print(arr[rowStart][i] + " ");
                }
                rowStart++;

                //2
                for(i = rowStart; i<=rowEnd; i++ ){
                    System.out.print(arr[i][columnEnd] + " ");
                }
                columnEnd--;

                //3
                for(i = columnEnd; i>=columnStart; i--){
                    System.out.print(arr[rowEnd][i] + " ");
                }
                rowEnd--;

                //4
                for(i = rowEnd; i>=rowStart; i--){
                    System.out.print(arr[i][columnStart] + " ");
                }
                columnStart++;
            }
        }
    }
}
