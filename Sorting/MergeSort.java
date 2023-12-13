// Time Complexity O(nlogn)
public class MergeSort {
    public static void conquer(int arr[], int si, int mid, int ei) {
        int indx1 = si;
        int indx2 = mid + 1;
        int merged[] = new int[ei - si + 1];
        
        int x = 0;
        //O(n)
        while (indx1 <= mid && indx2 <= ei) {
            if (arr[indx1] >= arr[indx2]) {
                merged[x++] = arr[indx2++];
            } else {
                merged[x++] = arr[indx1++];
            }
        }
        
        while (indx1 <= mid) {
            merged[x++] = arr[indx1++];
        }
        
        while (indx2 <= ei) {
            merged[x++] = arr[indx2++];
        }
        
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }
    
    public static void divide(int arr[], int si, int ei) {
        //O(logn)
        if (si >= ei) {
            return;
        }
        
        int mid = si + (ei - si) / 2; // To avoid space complexity issue
        
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, mid, ei);
    }
    
    public static void main(String args[]) {
        int arr[] = { 5, 6, 7, 1, 3, 9, 4 };
        int i;
        
        System.out.println("Array before Sorting: ");
        for(i=0; i<=6; i++){
            System.out.print(" " + arr[i] + " ");
        }
        System.out.println();
        System.out.println();
        
        divide(arr, 0, 6);
        
        System.out.println("Array after Sorting: ");
        for(i=0; i<=6; i++){
            System.out.print(" " + arr[i] + " ");
        }
    }
}
