//Creationg a binary tree of data given in preorder sequence

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
    
    static class BinaryTree {
        int idx = -1;
        
        public Node buildTree(int nodes[]) {
            idx++;
            
            if (nodes[idx] == -1) {
                return null;
            }
            
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            
            return newNode;
        }
    }
    
    // DFS Traversal in Tree: Preorder, Inorder and Postorder
    public static void preorder(Node root) {
        if (root == null) {
            // System.out.print("-1 ");
            return;
        }
        
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    
    // BFS Traversal in Tree: Level Order Traversal
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }
    
    // Count number of Nodes
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes + rightNodes + 1;
    }
    
    // Sum of Nodes
    public static int sumNodes(Node root) {
        if (root == null) {
            return 0;
        }
        
        int leftSum = sumNodes(root.left);
        int rightSum = sumNodes(root.right);
        return leftSum + rightSum + root.data;
    }
    
    // Height of Tree
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        int maxHeight = Math.max(leftHeight, rightHeight) + 1;
        
        return maxHeight;
    }
    
    // Diameter of Tree: Approach 1 -> Time colplexity = O(n^2)
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        
        int leftDia = diameter(root.left);
        int rightDia = diameter(root.right);
        int rootDia = height(root.left) + height(root.right) + 1;
        
        return (Math.max(rootDia, Math.max(leftDia, rightDia)));
    }
    
    // Diameter of Tree: Approach 2 -> Time colplexity = O(n)
    static class TreeInfo {
        int height;
        int diameter;
        
        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
    
    public static TreeInfo diameter2(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);
        
        int treeHeight = Math.max(left.height, right.height) + 1;
        
        int leftDia = left.diameter;
        int rightDia = right.diameter;
        int rootDia = left.height + right.height + 1;
        
        int diameter = Math.max(rootDia, Math.max(rightDia, leftDia));
        TreeInfo answer = new TreeInfo(treeHeight, diameter);
        return answer;
    }
    
    // To check if given tree is subtree of already created tree or not
    public static boolean isIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return true;
        }
        if (root.data == subRoot.data) {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }
        return false;
    }
    
    public static boolean isSubtree(Node root, Node subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        
        int subnodes[] = { 1, 2, 4, -1, -1, -1, 3, -1, -1 };
        BinaryTree st = new BinaryTree();
        Node subroot = st.buildTree(subnodes);
        
        // preorder(root);
        // System.out.println();
        // inorder(root);
        // System.out.println();
        // postorder(root);
        // System.out.println();
        
        // levelOrder(root);
        
        // System.out.println(countNodes(root));
        // System.out.println(sumNodes(root));
        
        // System.out.println(height(root));
        
        // System.out.println(diameter(root));
        
        System.out.println(diameter2(root).diameter);
        System.out.println(diameter2(root).height);
        
        System.out.println(isSubtree(root, subroot));

    }
}
