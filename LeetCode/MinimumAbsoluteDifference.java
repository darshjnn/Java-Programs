/*
1200. Minimum Absolute Difference

Given an array of distinct integers arr, find all pairs of elements with the
minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b,
(b - a) equals to the minimum absolute difference of any two elements in arr


Example 1:
Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference
equal to 1 in ascending order.

Example 2:
Input: arr = [1,3,6,10,15]
Output: [[1,3]]

Example 3:
Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]

*/

package LeetCode;

import java.util.*;

public class MinimumAbsoluteDifference {
	public static void minAbsDiff(int[] arr) {
		ArrayList<int[]> result = new ArrayList<>();
		Arrays.sort(arr);
		int minDiff = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length; i++) {
			minDiff = Math.min(minDiff, Math.abs(arr[i] - arr[i - 1]));
		}
		for (int i = 1; i < arr.length; i++) {
			if (Math.abs(arr[i] - arr[i - 1]) == minDiff) {
				int[] sol = {arr[i - 1], arr[i]};
				result.add(sol);
			}
		}
		for (int[] i : result) {
			System.out.println(i[0] + " " + i[1]);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {3,8,-10,23,19,-4,-14,27};
		minAbsDiff(arr);
	}
}