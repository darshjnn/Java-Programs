package Arrays;

public class Subarrays {
	private static void subArrays(int[] arr) {
		int ts = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				System.out.print("[ ");
				for (int k = i; k <= j; k++) {
					System.out.print(arr[k] + " ");
				}
				ts++;
				System.out.println("]");
			}
			System.out.println();
		}
		System.out.println("Total number of Subarrays: " + ts);
//		Total no. of subarrays = n(n+1)/2
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		subArrays(arr);
	}
}