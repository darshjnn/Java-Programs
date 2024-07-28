/*
387. First Unique Character in a String

Given a string s, find the first non-repeating character in it and return its index.
If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1

*/

package LeetCode;

import java.util.*;

public class FirstUniqueChar {
	public static int firstUniqChar(String s) {
		Queue<Integer> q = new LinkedList<>();
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			++count[index];
			q.offer(i);
		}
		while (!q.isEmpty()) {
			if (count[s.charAt(q.peek()) - 'a'] == 1) {
				return q.peek();
			} else {
				q.poll();
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String s = "leetcode";
		System.out.println(firstUniqChar(s));
	}
}