public class BubbleSort {
    
    public static void PrintArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        
        int arr[] = {7,8,3,1,2};
        
        System.out.println("Array before sorting: ");
        PrintArr(arr);
        
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        
        System.out.println("Array after sorting: ");
        PrintArr(arr);
        
    }
}
