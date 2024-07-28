/*
646. Maximum Length of Pair Chain

You are given an array of n pairs where pairs[i] = [left[i], right[i]] and left[i] < right[i].

A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this
fashion.

Return the length longest chain which can be formed.

You do not need to use up all the given intervals. You can select pairs in any order.

Example 1:
Input: pairs = [[1,2],[2,3],[3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4].

Example 2:
Input: pairs = [[1,2],[7,8],[4,5]]
Output: 3
Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].

*/

package LeetCode;

import java.util.*;

public class MaximumLengthPairChain {
	public static int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, Comparator.comparingInt(p -> p[1]));
		int chain = 1;
		int chainEnd = pairs[0][1];
		for (int i = 1; i < pairs.length; i++) {
			if (pairs[i][0] > chainEnd) {
				++chain;
				chainEnd = pairs[i][1];
			}
		}
		return chain;
	}
	
	public static void main(String[] args) {
		int[][] pairs = {{1, 2}, {3, 4}, {2, 3}};
		System.out.println(findLongestChain(pairs));
	}
}

/*
Alternate Solution:
int minL = Integer.MAX_VALUE, maxR = Integer.MIN_VALUE;
for (int[] pair : pairs) {
	int l = pair[0], r = pair[1];
	minL = Math.min(minL, l);
	maxR = Math.max(maxR, r);
}
int[] arr = new int[maxR - minL + 2];
for (int[] pair : pairs) {
	int l = pair[0] - minL + 1, r = pair[1] - minL + 1;
	arr[r] = Math.max(arr[r], l);
}
int curMax = 0, ans = 0;
for (int r = 1; r <= maxR - minL + 1; ++r) {
	if (arr[r] > curMax) {
		curMax = r;
		++ans;
	}
}
return ans;
 */