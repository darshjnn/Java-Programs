/*
236. Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
between two nodes p and q as the lowest node in T that has both p and q as descendants
(where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [1,2], p = 1, q = 2
Output: 1

*/

package LeetCode;

public class LowestCommonAncestor {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	static class BinaryTree {
		static int ind = -1;

		public Node buildTree(int[] arr) {
			++ind;
			if (arr[ind] == -1) {
				return null;
			}
			Node newNode = new Node(arr[ind]);
			newNode.left = buildTree(arr);
			return newNode;
		}

		public Node lowestCommonAncestor(Node root, int p, int q) {
			if (root == null || root.data == p || root.data == q) {
				return root;
			}
			Node left = lowestCommonAncestor(root.left, p, q);
			Node right = lowestCommonAncestor(root.right, p, q);
			if (left == null) {
				return right;
			}
			if (right == null) {
				return left;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(arr);
		int p = 4;
		int q = 5;
		System.out.println(tree.lowestCommonAncestor(root, p, q).data);
	}
}
