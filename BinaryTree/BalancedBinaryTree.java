/*
110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true

*/

package LeetCode;

public class BalancedBinaryTree {
	public static class Node {
		int data;
		Node left, right;
		
		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	static class BinaryTree {
		static int index = -1;
		
		Node buildTree(int[] arr) {
			++index;
			if (arr[index] == -1) {
				return null;
			}
			Node newNode = new Node(arr[index]);
			newNode.left = buildTree(arr);
			newNode.right = buildTree(arr);
			return newNode;
		}
	}
	
	private static int height(Node root) {
		if (root == null) {
			return 0;
		}
		int lh = height(root.left);
		int rh = height(root.right);
		if (lh == -1 || rh == -1) {
			return -1;
		}
		if (Math.abs(lh - rh) > 1) {
			return -1;
		}
		return Math.max(lh, rh) + 1;
	}
	
	public static boolean isBalanced(Node root) {
		if (root == null) {
			return true;
		}
		return height(root) != -1;
	}
	
	public static void main(String[] args) {
/*
		Other Testcases to try on
		int[] arr1 = {1, 2, 3, 4, -1, -1, 4, -1, -1, 3, -1, -1, 2, -1, -1};
		int[] arr2 = {3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1};
*/
		
		int[] arr = {1, 2, 3, 4, -1, -1, -1, -1, 2, -1, 3, -1, 4, -1, -1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(arr);
		System.out.println(isBalanced(root));
	}
}