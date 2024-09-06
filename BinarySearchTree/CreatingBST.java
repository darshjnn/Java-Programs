/*
Inorder Traversal of a Binary Search Tree gives a sorted sequence of elements.
*/

package BinarySearchTree;

import java.util.*;

public class CreatingBST {
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
		int size;
		int sum;
		int min;
		int max;

		NodeInfo(boolean isBST, int size, int sum, int min, int max) {
			this.isBST = isBST;
			this.size = size;
			this.sum = sum;
			this.min = min;
			this.max = max;
		}
	}

	static class BST {
		public Node buildTree(Node root, int value) {
			if (root == null) {
				return new Node(value);
			}
			if (root.data < value) {
				root.right = this.buildTree(root.right, value);
			} else {
				root.left = this.buildTree(root.left, value);
			}
			return root;
		}

		// Inorder Traversal
		public void inorder(Node root) {
			if (root == null) {
				return;
			}
			this.inorder(root.left);
			System.out.print(root.data + " ");
			this.inorder(root.right);
		}

		// Preorder Traversal
		public void preorder(Node root) {
			if (root == null) {
				System.out.print("-1 ");
				return;
			}
			System.out.print(root.data + " ");
			this.preorder(root.left);
			this.preorder(root.right);
		}

		// Search Element
		// Time complexity to search a key: O(H)
		public boolean search(Node root, int key) {
			if (root == null) {
				return false;
			}
			if (root.data == key) {
				return true;
			}
			return this.search(root.left, key) || this.search(root.right, key);
		}

		// Delete Node
		// Inorder successor in BST is left most node in right subtree
		public Node findInorderSuccessor(Node root) {
			while (root.left != null) {
				root = root.left;
			}
			return root;
		}

		public Node delete(Node root, int key) {
			if (root.data > key) {
				root.left = this.delete(root.left, key);
			} else if (root.data < key) {
				root.right = this.delete(root.right, key);
			} else {
				// Voila!!!
				// Case 1: Leaf Node
				if (root.left == null && root.right == null) {
					return null;
				}
				// Case 2: Single Child
				if (root.left == null) {
					return root.right;
				} else if (root.right == null) {
					return root.left;
				}
				// Case 3: Both Child Exists
				Node inorderSuccessor = findInorderSuccessor(root.right);
				root.data = inorderSuccessor.data;
				root.right = this.delete(root.right, inorderSuccessor.data);
			}
			return root;
		}

		// Print in Range
		public void printInRange(Node root, int low, int high) {
			if (root == null) {
				return;
			}
			if (root.data >= low && root.data <= high) {
				this.printInRange(root.left, low, high);
				System.out.print(root.data + " ");
				this.printInRange(root.right, low, high);
			} else if (root.data < low) {
				this.printInRange(root.right, low, high);
			} else {
				printInRange(root.left, low, high);
			}
		}

		// Sum in Range
		public int rangeSumBST(Node root, int low, int high) {
			if (root == null) {
				return 0;
			}
			int leftSum = 0;
			int rightSum = 0;
			if (root.data >= low && root.data <= high) {
				leftSum = this.rangeSumBST(root.left, low, high);
				rightSum = this.rangeSumBST(root.right, low, high);
			} else if (root.data < low) {
				rightSum = this.rangeSumBST(root.right, low, high);
			} else {
				leftSum = this.rangeSumBST(root.left, low, high);
			}
			if (root.data >= low && root.data <= high) {
				return leftSum + root.data + rightSum;
			}
			return leftSum + rightSum;
		}

		// Root to Leaf Paths
		public void printPath(ArrayList<Integer> path) {
			for (int i : path) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

		public void rootToLeaf(Node root, ArrayList<Integer> paths) {
			if (root == null) {
				return;
			}
			paths.add(root.data);
			if (root.left == null && root.right == null) {
				this.printPath(paths);
			}
			rootToLeaf(root.left, paths);
			rootToLeaf(root.right, paths);
			paths.remove(paths.size() - 1);
		}

		// Validate a Binary Search Tree
		public boolean isValidBST(Node root, Node min, Node max) {
			if (root == null) {
				return true;
			}
			if (min != null && root.data <= min.data) {
				return false;
			}
			if (max != null && root.data >= max.data) {
				return false;
			}
			return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
		}

		// Mirror/Invert a BST
		public Node invertTree(Node root) {
			if (root == null) {
				return null;
			}
			Node left = this.invertTree(root.left);
			root.left = this.invertTree(root.right);
			root.right = left;
			return root;
		}

		// Create a Height Balance from Sorted Array
		public Node sortedArrayToBST(int[] nums, int low, int high) {
			if (low > high) {
				return null;
			}
			int mid = low + (high - low) / 2;
			Node root = new Node(nums[mid]);
			root.left = this.sortedArrayToBST(nums, low, (mid - 1));
			root.right = this.sortedArrayToBST(nums, (mid + 1), high);
			return root;
		}

		// Convert BST to Balance BST
		public void getInorder(Node root, ArrayList<Integer> inorder) {
			if (root == null) {
				return;
			}
			this.getInorder(root.left, inorder);
			inorder.add(root.data);
			this.getInorder(root.right, inorder);
		}

		public Node createBST(ArrayList<Integer> inorder, int low, int high) {
			if (low > high) {
				return null;
			}
			int mid = low + (high - low) / 2;
			Node root = new Node(inorder.get(mid));
			root.left = this.createBST(inorder, low, (mid - 1));
			root.right = this.createBST(inorder, (mid + 1), high);
			return root;
		}

		public Node balanceBST(Node root) {
			ArrayList<Integer> inorder = new ArrayList<>();
			this.getInorder(root, inorder);
			return this.createBST(inorder, 0, inorder.size() - 1);
		}

		// Size and Sum of largest BST in Binary Tree
		public NodeInfo largestBST(Node root) {
			if (root == null) {
				return new NodeInfo((true), 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
			}
			NodeInfo left = largestBST(root.left);
			NodeInfo right = largestBST(root.right);
			int size = Math.max(left.size, right.size);
			int sum = Math.max(left.sum, right.sum);
			int min = Math.min(root.data, Math.min(left.min, right.min));
			int max = Math.max(root.data, Math.max(left.max, right.max));
			if (root.data <= left.max || root.data >= right.min) {
				return new NodeInfo((false), size, sum, min, max);
			}
			if (left.isBST && right.isBST) {
				size = left.size + right.size + 1;
				sum = Math.max(root.data + left.sum + right.sum, sum);
				return new NodeInfo((true), size, sum, min, max);
			}
			return new NodeInfo((false), size, sum, min, max);
		}

		// Merge two BST
		public Node mergeBST(Node root1, Node root2) {
			ArrayList<Integer> arr1 = new ArrayList<>();
			ArrayList<Integer> arr2 = new ArrayList<>();
			this.getInorder(root1, arr1);
			this.getInorder(root2, arr2);
			ArrayList<Integer> merge = new ArrayList<>();
			int i = 0, j = 0;
			while ((i < arr1.size()) && (j < arr2.size())) {
				if (arr1.get(i) < arr2.get(j)) {
					merge.add(arr1.get(i));
					++i;
				} else {
					merge.add(arr2.get(j));
					++j;
				}
			}
			while (i < arr1.size()) {
				merge.add(arr1.get(i));
				++i;
			}
			while (j < arr2.size()) {
				merge.add(arr2.get(j));
				++j;
			}
			return this.createBST(merge, 0, (merge.size() - 1));
		}
	}

	public static void main(String[] args) {
		int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
		BST bst = new BST();
		Node root = null;
		for (int value : values) {
			root = bst.buildTree(root, value);
		}
		System.out.print("Inorder Traversal: ");
		bst.inorder(root);
		System.out.println();

		System.out.println("Search an Element: " + bst.search(root, 7) + "\n");

		System.out.println("Delete Node: 10");
		bst.delete(root, 10);
		bst.preorder(root);
		System.out.println("\n");

		System.out.print("Print in Range: ");
		bst.printInRange(root, 5, 10);
		System.out.println("\nSum in this range: " + bst.rangeSumBST(root, 5, 10));
		System.out.println();

		System.out.println("Root to Leaf Paths:");
		bst.rootToLeaf(root, new ArrayList<>());
		System.out.println();

		System.out.println("Is BST valid? " + bst.isValidBST(root, null, null) + "\n");

		bst.invertTree(root);
		System.out.print("Inorder traversal after inverting tree: ");
		bst.inorder(root);
		System.out.println("\n");

		int[] nums = { 3, 5, 6, 8, 10, 11, 12 };
		Node root1 = bst.sortedArrayToBST(nums, 0, 6);
		System.out.print("Sorted Array to BST: ");
		bst.inorder(root1);
		System.out.println("\n");

		Node root2 = new Node(8);
		root2.left = new Node(6);
		root2.left.left = new Node(5);
		root2.left.left.left = new Node(3);
		root2.right = new Node(10);
		root2.right.right = new Node(11);
		root2.right.right.right = new Node(12);
		System.out.println("Balance BST:");
		bst.inorder(root2);
		System.out.println();
		bst.preorder(root2);
		System.out.println();
		root2 = bst.balanceBST(root2);
		bst.preorder(root2);
		System.out.println("\n");

		Node root3 = new Node(50);
		root3.left = new Node(30);
		root3.left.left = new Node(5);
		root3.left.right = new Node(40);

		root3.right = new Node(60);
		root3.right.left = new Node(45);
		root3.right.right = new Node(70);
		root3.right.right.left = new Node(65);
		root3.right.right.right = new Node(40);
		bst.preorder(root3);
		System.out.println();
		NodeInfo n = bst.largestBST(root3);
		System.out.println("Size from n.size: " + n.size);
		System.out.println("Sum: " + n.sum);
		System.out.println();

		Node root4 = new Node(2);
		root4.left = new Node(1);
		root4.right = new Node(4);
		
		Node root5 = new Node(9);
		root5.left = new Node(3);
		root5.right = new Node(12);
		
		Node merged = bst.mergeBST(root4, root5);
		System.out.print("Merged BST: ");
		bst.inorder(merged);
	}
}
