/*
1. Two Sum Problem

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

*/
package LeetCode;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int a;
        for (int i = 0; i < nums.length; i++) {
            a = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == a && j != i) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[0];
    }
    
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int target = 5;
        for (int j = 0; j < 2; j++) {
	        System.out.print(" " + twoSum(arr, target)[j] + " ");
        }
    }
}