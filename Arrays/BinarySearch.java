/*
Binary Search

Prerequisite: Array must be Sorted

*/

package Arrays;

public class BinarySearch {
	public static int binarySearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length - 1;
		
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			if (key == arr[mid]) {
				return mid;
			} else if (key < arr[mid]) {
				high = mid - 1;
			} else if (key > arr[mid]) {
				low = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		System.out.println("\nElement found at index " + binarySearch(arr, 5));
	}
}