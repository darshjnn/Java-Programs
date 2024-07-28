//To check if the array is sorted or not
//Time Complexity: O(n)

package Recursion;

public class CheckIfIncreasing {
    public static boolean isSorted(int arr[], int index){
        if (index == arr.length - 1){
            return true;
        }
        
        if (!isSorted(arr, index+1)){
            return false;
        }
        return arr[index] < arr[index + 1];
        
    //OR
    //     if (arr[index] < arr[index + 1]){
    //         return isSorted(arr, index+1);
    //     } else{
    //         return false;
    //     }
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7,8};
        boolean a = isSorted(arr, 0);
        if(a){
            System.out.println("Array is Strictly in increasing order");
        } else {
            System.out.println("Array is Strictly NOT in increasing order");
        }
    }
}
