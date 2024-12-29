/*
53. Maximum Subarray

Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

*/

package Arrays.LeetCode;

public class MaximumSubArray {
	// Brute Force Approach
	public static int bruteMaxSubArray(int[] nums) {
		int n = nums.length;
		int currSum;
		int maxSum = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				currSum = 0;
				for (int k = i; k <= j; k++) {
					currSum += nums[k];
				}
				if (currSum > maxSum) {
					maxSum = currSum;
				}
			}
		}
		
		return maxSum;
	}
	
	// Using Prefix Sum
	public static int prefixMaxSubArray(int[] nums) {
		int n = nums.length;
		
		int[] prefixSum = new int[n];
		prefixSum[0] = nums[0];
		for (int i = 1; i < n; i++) {
			prefixSum[i] = nums[i] + prefixSum[i - 1];
		}
		
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int currSum = i == 0 ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1];
				if (currSum > maxSum) {
					maxSum = currSum;
				}
			}
		}
		
		return maxSum;
	}
	
	// Using Kadane's Algorithm
	public static int kadaneMaxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		
		boolean isNegative = true;
		for (int num : nums) {
			if (num >= 0) {
				isNegative = false;
				break;
			}
		}
		
		if (isNegative) {
			int minNegative = Integer.MIN_VALUE;
			for (int num : nums) {
				if (num > minNegative) {
					minNegative = num;
				}
			}
			return minNegative;
		}
		
		for (int num : nums) {
			currSum += num;
			if (currSum < 0) {
				currSum = 0;
			}
			maxSum = Math.max(maxSum, currSum);
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(bruteMaxSubArray(nums));
		System.out.println(prefixMaxSubArray(nums));
		System.out.println(kadaneMaxSubArray(nums));
	}
}