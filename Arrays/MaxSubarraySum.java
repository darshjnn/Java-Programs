package Arrays;

public class MaxSubarraySum {
	//	Using Brute force
	private static int bruteMaxSubarraySum(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int currentSum = 0;
				for (int k = i; k <= j; k++) {
					currentSum += arr[k];
				}
				if (currentSum > maxSum) {
					maxSum = currentSum;
				}
				
			}
		}
		return maxSum;
	}
	
	//	Using Prefix Sum
	private static int prefixMaxSubarraySum(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		int[] prefixSum = new int[arr.length];
		prefixSum[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
				prefixSum[i] = prefixSum[i - 1] + arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int currentSum = i == 0 ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1];
				if (currentSum > maxSum) {
					maxSum = currentSum;
				}
			}
		}
		return maxSum;
	}
	
	//	Kadane's Algorithm
	private static int kadaneMaxSubarraySum(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		int maxNegativeSum = Integer.MIN_VALUE;
		boolean isNegative = true;
		int currSum = 0;
//		Check if all elements are negative, then return highest negative number
		for (int j : arr) {
			if (j > 0) {
				isNegative = false;
				break;
			}
		}
		if (isNegative) {
			for (int j : arr) {
				if (j > maxNegativeSum) {
					maxNegativeSum = j;
				}
			}
			return maxNegativeSum;
		}
		for (int i : arr) {
			currSum += i;
			if (currSum < 0) {
				currSum = 0;
			}
			maxSum = Math.max(maxSum, currSum);
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] arr = {-2, 3, -4, -1, -2, -3, 5, -3};
		System.out.println(bruteMaxSubarraySum(arr));
		System.out.println(prefixMaxSubarraySum(arr));
		System.out.println(kadaneMaxSubarraySum(arr));
	}
}