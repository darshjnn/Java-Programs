/*
84. Largest Rectangle in Histogram

Given an array of integers heights representing the histogram's bar height
where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4

*/

package LeetCode;

import java.util.Stack;

public class LargestRectangle {
	public static int maxArea(int[] heights) {
		int n = heights.length;
		int[] nsl = new int[n];  // nextSmallerLeft
		int[] nsr = new int[n];  // nextSmallerRight
		int maxArea = 0;
		Stack<Integer> stack = new Stack<>();

		// Next Smaller Left
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				nsl[i] = -1;
			} else {
				nsl[i] = stack.peek();
			}
			stack.push(i);
		}

		// Next Smaller Right
		stack = new Stack<>();
		for (int i = (n - 1); i >= 0; i--) {
			while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				nsr[i] = n;
			} else {
				nsr[i] = stack.peek();
			}
			stack.push(i);
		}

		// Calculating Max Area
		int area;
		for (int i = 0; i < n; i++) {
			area = heights[i] * (nsr[i] - nsl[i] - 1);
			maxArea = Math.max(area, maxArea);
		}

		return maxArea;
	}
	
	public static void main(String[] args) {
		int[] heights = {2, 1, 5, 6, 2, 3};
		System.out.println(maxArea(heights));
	}
}