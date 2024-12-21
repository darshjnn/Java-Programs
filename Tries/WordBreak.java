/*
139. Word Break

Given a string s and a dictionary of strings wordDict, return true if s can be segmented
into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

*/

package LeetCode;

import java.util.*;

public class WordBreak {
	public static class Node {
		Node[] children = new Node[26];
		boolean isLeaf;
		
		Node() {
			this.isLeaf = false;
		}
	}
	
//	public static Node root = new Node();
	
	public static void insert(Node root, String word) {
		Node curr = root;
		for (char c : word.toCharArray()) {
			int idx = c - 'a';
			if (curr.children[idx] == null) {
				curr.children[idx] = new Node();
			}
			curr = curr.children[idx];
		}
		curr.isLeaf = true;
	}
	
	public static boolean search(Node root, String word) {
		Node curr = root;
		for (char c : word.toCharArray()) {
			int idx = c - 'a';
			if (curr.children[idx] == null) {
				return false;
			}
			curr = curr.children[idx];
		}
		return curr.isLeaf;
	}
	
	public static boolean boolBreak(Node root, String word) {
		if (word.isEmpty()) {
			return true;
		}
		for (int i = 1; i <= word.length(); i++) {
			if (search(root, word.substring(0, i)) && boolBreak(root, word.substring(i))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean wordBreak(String s, List<String> wordDict) {
		Node root = new Node();
		for (String word : wordDict) {
			insert(root, word);
		}
		return boolBreak(root, s);
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("leet");
		list.add("code");
		list.add("sand");
		System.out.println(wordBreak("leetcode", list));
	}
}

/*
Read:
    boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length() + 1];
        return wordBreak2(s, new HashSet<>(wordDict), 0, memo);
    }

    boolean recWay(String s, Set<String> wordDict, int k, Boolean[] memo) {
        int n = s.length();
        if (k == n) return true;

        if (memo[k] != null) return memo[k];

        for (int i=k + 1; i<=n; i++) {
            String word = s.substring(k, i);
            if (wordDict.contains(word) && recWay(s, wordDict, i, memo)) {
                return memo[k] = true;
            }
        }

        return memo[k] = false;
    }
*/