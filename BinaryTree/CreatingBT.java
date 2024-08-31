package BinaryTree;

import java.util.*;

public class CreatingBT {
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	static class TreeInfo {
		int h;
		int d;
		
		TreeInfo(int height, int diameter) {
			this.h = height;
			this.d = diameter;
		}
	}
	
	static class NodeInfo {
		int xDist;
		Node node;
		
		NodeInfo(int xDist, Node node) {
			this.xDist = xDist;
			this.node = node;
		}
	}
	
	static class BinaryTree {
		static int ind = -1;
		
		public Node buildTree(int[] arr) {
			++ind;
			if (arr[ind] == -1) {
				return null;
			}
			Node root = new Node(arr[ind]);
			root.left = buildTree(arr);
			root.right = buildTree(arr);
			return root;
		}
		
		// DFS Traversal: Preorder, Postorder, Inorder
		public void preorder(Node root) {
			if (root == null) {
				return;
			}
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
		
		public void inorder(Node root) {
			if (root == null) {
				return;
			}
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
		
		public void postorder(Node root) {
			if (root == null) {
				return;
			}
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
		
		// BFS Traversal: Level Order
		public void levelOrder(Node root) {
			if (root == null) {
				return;
			}
			Queue<Node> q = new LinkedList<>();
			q.offer(root);
			q.offer(null);
			while (!q.isEmpty()) {
				Node curr = q.poll();
				if (curr == null) {
					System.out.println();
					if (q.isEmpty()) {
						break;
					} else {
						q.offer(null);
					}
				} else {
					System.out.print(curr.data + " ");
					if (curr.left != null) {
						q.offer(curr.left);
					}
					if (curr.right != null) {
						q.offer(curr.right);
					}
				}
			}
		}
		
		// Height of Tree
		public int height(Node root) {
			if (root == null) {
				return 0;
			}
			int leftHeight = height(root.left);
			int rightHeight = height(root.right);
			return (Math.max(leftHeight, rightHeight) + 1);
		}
		
		// Minimum Depth of Tree
		public int minDepth(Node root) {
			if (root == null) {
				return 0;
			}
			int leftDepth = minDepth(root.left);
			int rightDepth = minDepth(root.right);
			if (root.left == null) {
				return rightDepth + 1;
			}
			if (root.right == null) {
				return leftDepth + 1;
			}
			return Math.min(leftDepth, rightDepth) + 1;
		}
		
		// Count Number of Nodes
		public int countNodes(Node root) {
			if (root == null) {
				return 0;
			}
			int leftCount = countNodes(root.left);
			int rightCount = countNodes(root.right);
			return leftCount + rightCount + 1;
		}
		
		// Sum of Nodes
		public int sumNode(Node root) {
			if (root == null) {
				return 0;
			}
			int leftSum = sumNode(root.left);
			int rightSum = sumNode(root.right);
			return leftSum + rightSum + root.data;
		}
		
		// Diameter of Tree: Approach 1 -> Time Complexity: O(n^2)
		public int diameter(Node root) {
			if (root == null) {
				return 0;
			}
			int leftDiameter = diameter(root.left);
			int rightDiameter = diameter(root.right);
			int diameter = height(root.left) + height(root.right) + 1;
			return Math.max(diameter, Math.max(leftDiameter, rightDiameter));
		}
		
		// Diameter of Tree: Approach 2 -> Time Complexity: O(n)
		public TreeInfo treeInfo(Node root) {
			if (root == null) {
				return new TreeInfo(0, 0);
			}
			TreeInfo left = treeInfo(root.left);
			TreeInfo right = treeInfo(root.right);
			int height = Math.max(left.h, right.h) + 1;
			int diameter = Math.max(Math.max(left.d, right.d), (left.h + right.h + 1));
			return new TreeInfo(height, diameter);
		}
		
		// Check if given Tree is Subtree
		public boolean isIdentical(Node root, Node subRoot) {
			if (root == null && subRoot == null) {
				return true;
			}
			if (root == null || subRoot == null || root.data != subRoot.data) {
				return false;
			}
			return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
		}
		
		public boolean isSubtree(Node root, Node subRoot) {
			if (root == null) {
				return false;
			}
			if (root.data == subRoot.data) {
				return isIdentical(root, subRoot);
			}
			return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
		}
		
		// Top View of Tree
		public void topView(Node root) {
			if (root == null) {
				return;
			}
			HashMap<Integer, Node> map = new HashMap<>();
			Queue<NodeInfo> q = new LinkedList<>();
			int max = 0, min = 0;
			q.offer(new NodeInfo(0, root));
			q.offer(null);
			while (!q.isEmpty()) {
				NodeInfo curr = q.poll();
				if (curr == null) {
					if (q.isEmpty()) {
						break;
					} else {
						q.offer(null);
					}
				} else {
					if (!map.containsKey(curr.xDist)) {
						map.put(curr.xDist, curr.node);
					}
					if (curr.node.left != null) {
						q.offer(new NodeInfo((curr.xDist - 1), curr.node.left));
						min = Math.min(min, (curr.xDist - 1));
					}
					if (curr.node.right != null) {
						q.offer(new NodeInfo((curr.xDist + 1), curr.node.right));
						max = Math.max(max, (curr.xDist + 1));
					}
				}
			}
			for (int i = min; i <= max; i++) {
				System.out.print(map.get(i).data + " ");
			}
		}
		
		// Bottom View of Tree
		public void bottomView(Node root) {
			if (root == null) {
				return;
			}
			HashMap<Integer, Node> map = new HashMap<>();
			Queue<NodeInfo> q = new LinkedList<>();
			int max = 0, min = 0;
			q.offer(new NodeInfo(0, root));
			q.offer(null);
			while (!q.isEmpty()) {
				NodeInfo curr = q.poll();
				if (curr == null) {
					if (q.isEmpty()) {
						break;
					} else {
						q.offer(null);
					}
				} else {
					map.put(curr.xDist, curr.node);
					if (curr.node.left != null) {
						q.offer(new NodeInfo(curr.xDist - 1, curr.node.left));
						min = Math.min(min, curr.xDist - 1);
					}
					if (curr.node.right != null) {
						q.offer(new NodeInfo(curr.xDist + 1, curr.node.right));
						max = Math.max(max, curr.xDist + 1);
					}
				}
			}
			for (int i = min; i <= max; i++) {
				System.out.print(map.get(i).data + " ");
			}
		}
		
		// Kth level
		public void kthLevel(Node root, int level, int k) {
			if (root == null) {
				return;
			}
			if (level == k) {
				System.out.print(root.data + " ");
				return;
			}
			kthLevel(root.left, level + 1, k);
			kthLevel(root.right, level + 1, k);
		}
		
		// Lowest Common Ancestor: Approach 1
		public boolean getPath(Node root, int n, ArrayList<Node> path) {
			if (root == null) {
				return false;
			}
			path.add(root);
			if (root.data == n) {
				return true;
			}
			if (getPath(root.left, n, path) || getPath(root.right, n, path)) {
				return true;
			}
			path.remove(path.size() - 1);
			return false;
		}
		
		public int lowestCommonAncestor1(Node root, int p, int q) {
			if (root == null) {
				return Integer.MAX_VALUE;
			}
			ArrayList<Node> path1 = new ArrayList<>();
			ArrayList<Node> path2 = new ArrayList<>();
			this.getPath(root, p, path1);
			this.getPath(root, q, path2);
			int i = 0;
			for (; i < path1.size() && i < path2.size(); i++) {
				if (path1.get(i) != path2.get(i)) {
					break;
				}
			}
			if (i == path1.size() || i == path2.size()) {
				return Integer.MIN_VALUE;
			}
			return path1.get(i - 1).data;
		}
		
		// Lowest Common Ancestor: Approach 2
		public Node lowestCommonAncestor2(Node root, int p, int q) {
			if (root == null || root.data == p || root.data == q) {
				return root;
			}
			Node left = lowestCommonAncestor2(root.left, p, q);
			Node right = lowestCommonAncestor2(root.right, p, q);
			if (left == null) {
				return right;
			}
			if (right == null) {
				return left;
			}
			return root;
		}
		
		// Minimum Distance Between Two Nodes
		public int pathDist(Node root, int n) {
			if (root == null) {
				return -1;
			}
			if (root.data == n) {
				return 0;
			}
			int left = this.pathDist(root.left, n);
			int right = this.pathDist(root.right, n);
			if (left == -1 && right == -1) {
				return -1;
			}
			return Math.max(left, right) + 1;
		}
		
		public int minDist(Node root, int p, int q) {
			Node lowestCommonAncestor = this.lowestCommonAncestor2(root, p, q);
			int pDist = this.pathDist(lowestCommonAncestor, p);
			int qDist = this.pathDist(lowestCommonAncestor, q);
			return pDist + qDist;
		}
		
		// Kth Ancestor of a Node
		public int kAncestor(Node root, int n, int k) {
			if (root == null) {
				return -1;
			}
			if (root.data == n) {
				return 0;
			}
			int left = kAncestor(root.left, n, k);
			int right = kAncestor(root.right, n, k);
			if (left == -1 && right == -1) {
				return -1;
			}
			int dist = Math.max(left, right) + 1;
			if (dist == k) {
				System.out.println("Kth Ancestor: " + root.data);
			}
			return dist;
		}
		
		// Transform to Sum Tree
		public int sumTree(Node root) {
			if (root == null) {
				return 0;
			}
			int leftChild = sumTree(root.left);
			int newLeft = root.left == null ? 0 : root.left.data;
			int rightChild = sumTree(root.right);
			int newRight = root.right == null ? 0 : root.right.data;
			int data = root.data;
			root.data = leftChild + newLeft + rightChild + newRight;
			return data;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(arr);
		System.out.println();
		
		System.out.print("Preorder traversal is: ");
		tree.preorder(root);
		System.out.println();
		
		System.out.print("Inorder traversal is: ");
		tree.inorder(root);
		System.out.println();
		
		System.out.print("Postorder traversal is: ");
		tree.postorder(root);
		System.out.println();
		
		System.out.println("Level Order Traversal is: ");
		tree.levelOrder(root);
		System.out.println();
		
		System.out.println("Height of tree: " + tree.height(root));
		System.out.println("Minimum Depth of tree: " + tree.minDepth(root));
		System.out.println();
		
		System.out.println("No. of Nodes in the tree: " + tree.countNodes(root));
		System.out.println();
		
		System.out.println("Sum of Nodes: " + tree.sumNode(root));
		System.out.println();
		
		System.out.println("Diameter: " + tree.diameter(root));
		System.out.println();
		
		TreeInfo treeInfo = tree.treeInfo(root);
		System.out.println("Tree Information:");
		System.out.println("Diameter = " + treeInfo.d + ", Height = " + treeInfo.h);
		System.out.println();
		
		Node subRoot = new Node(2);
		subRoot.left = new Node(4);
		subRoot.right = new Node(5);
		System.out.println("Is Subtree? " + tree.isSubtree(root, subRoot));
		System.out.println();
		
		System.out.println("Top View of Tree: ");
		tree.topView(root);
		System.out.println();
		
		System.out.println("Bottom View of Tree: ");
		tree.bottomView(root);
		System.out.println("\n");
		
		System.out.print("Kth Level: ");
		tree.kthLevel(root, 1, 3);
		System.out.println("\n");
		
		System.out.print("Lowest Common Ancestor: ");
		System.out.print(tree.lowestCommonAncestor1(root, 5, 6) + " ; ");
		System.out.println(tree.lowestCommonAncestor2(root, 5, 6).data + "\n");
		
		System.out.println("Min Dist Between Nodes: " + tree.minDist(root, 5, 6) + " Edges");
		System.out.println();
		
		tree.kAncestor(root, 2,1);
		System.out.println();
		
		System.out.println("Transform to Sum Tree::");
		tree.sumTree(root);
		tree.levelOrder(root);
	}
}