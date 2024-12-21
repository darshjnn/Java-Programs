/*
1373. Maximum Sum BST in Binary Tree

Given a binary tree root, return the maximum sum of all keys of any subtree which
is also a Binary Search Tree (BST).

Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
Output: 20
Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key
equal to 3.

Example 2:
Input: root = [4,3,null,1,2]
Output: 2
Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node
with key equal to 2.

Example 3:
Input: root = [-4,-2,-5]
Output: 0
Explanation: All values are negatives. Return an empty BST.

*/

package LeetCode;

public class MaximumSumBST {
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	static class NodeInfo {
		boolean isBST;
		int sum;
		int min;
		int max;
		
		NodeInfo(boolean isBST, int sum, int min, int max) {
			this.isBST = isBST;
			this.sum = sum;
			this.min = min;
			this.max = max;
		}
	}
	
	static class BST {
		int result;
		
		public NodeInfo maxSum(Node root) {
			if (root == null) {
				return new NodeInfo((true), (0), Integer.MAX_VALUE, Integer.MIN_VALUE);
			}
			NodeInfo left = maxSum(root.left);
			NodeInfo right = maxSum(root.right);
			int min = Math.min(root.data, Math.min(left.min, right.min));
			int max = Math.max(root.data, Math.max(left.max, right.max));
			int sum = Math.max(left.sum, right.sum);
			if (left.isBST && right.isBST) {
				sum = left.sum + right.sum + root.data;
				result = Math.max(result, sum);
				return new NodeInfo(true, sum, min, max);
			}
			return new NodeInfo(false, sum, min, max);
		}
		
		public int maxSumBST(Node root) {
			int sum = maxSum(root).sum;
			System.out.println(sum);
			return Math.max(result, 0);
		}
	}
	
	public static void main(String[] args) {
		BST bst = new BST();
		Node root = new Node(4);
		root.left = new Node(-3);
		root.left.left = new Node(-5);
		root.left.right = new Node(-2);
		
		root.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(9);
		System.out.println(bst.maxSumBST(root));
	}
}

/*
Alternate Solution:
class Solution {
    int max = 0;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        if(left == Integer.MIN_VALUE || right == Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if(root.left != null){
            TreeNode curr = root.left;
            while(curr.right != null){
                curr = curr.right;
            }
            if(curr.val >= root.val){
                return Integer.MIN_VALUE;
            }
        }
        if(root.right != null){
            TreeNode curr = root.right;
            while(curr.left != null){
                curr = curr.left;
            }
            if(curr.val <= root.val){
                return Integer.MIN_VALUE;
            }
        }
        int sum = root.val + left + right;
        max = Math.max(sum, max);
        return sum;
    }
}

*/