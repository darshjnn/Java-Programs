/*
965. UniValued Binary Tree

A binary tree is uni-valued if every node in the tree has the same value.

Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.

Example 1:
Input: root = [1,1,1,1,1,null,1]
Output: true

Example 2:
Input: root = [2,2,2,5,2]
Output: false

*/

package LeetCode;

public class UniValuedBinaryTree {
	public static class Node {
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	static class BST {
		public Node buildTree(Node root, int value) {
			if (root == null) {
				return new Node(value);
			}
			if (value < root.data) {
				root.left = this.buildTree(root.left, value);
			} else {
				root.right = this.buildTree(root.right, value);
			}
			return root;
		}
		
		public boolean isUniValTree(Node root) {
			if (root == null) {
				return true;
			}
			if (root.left != null && root.left.data != root.data) {
				return false;
			}
			if (root.right != null && root.right.data != root.data) {
				return false;
			}
			boolean left = isUniValTree(root.left);
			boolean right = isUniValTree(root.right);
			return (left && right);
		}
	}
	
	public static void main(String[] args) {
		BST bst = new BST();
		Node root = null;
		int[] arr = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
		for (int i : arr) {
			root = bst.buildTree(root, i);
		}
		System.out.println(bst.isUniValTree(root));
	}
}