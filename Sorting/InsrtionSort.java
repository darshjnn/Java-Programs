public class InsrtionSort {
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

        for(int i=1; i<arr.length; i++){
            int current = arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>current){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }

        System.out.println("Array after sorting is: ");
        PrintArr(arr);
    }
}