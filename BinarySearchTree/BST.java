package BinarySearchTree;

import java.util.*;

public class BST {
    
    static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
        }
    }
    
    // Create a BST
    public static Node createBST(Node root, int value) {
        
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (root.data > value) {
            // Insert in Left SubTree
            root.left = createBST(root.left, value);
        } else {
            root.right = createBST(root.right, value);
        }
        return root;
    }
    
    // Time complexity to search a key = O(H)
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data > key) {
            // Serach in left SubTree
            return search(root.left, key);
        } else if (root.data == key) {
            return true;
        } else {
            return search(root.right, key);
        }
    }
    
    // Elements are in increasing order for Inorder traversal of BST
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    // Delete a Node
    public static Node delete(Node root, int value) {
        if (root.data > value) {
            root.left = delete(root.left, value);
        } else if (root.data < value) {
            root.right = delete(root.right, value);
        } else {
            // for root.data == value
            // Case 1: For leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: Only one node attached, either at right or left
            else if (root.left == null || root.right == null) {
                if (root.left == null) {
                    return root.right;
                } else {
                    return root.left;
                }
            }
            // Case 3: Node to be deleted has both, right & left, childs
            Node inorderSuccessor = inorderSuccessorNode(root.right);
            root.data = inorderSuccessor.data;
            root.right = delete(root.right, inorderSuccessor.data);
        }
        return root;
    }
    
    // Function to find next inorder successor
    public static Node inorderSuccessorNode(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    
    //Print Nodes in range
    public static void printInRange(Node root, int X, int Y) {
        if (root == null) {
            return;
        }
        if (root.data >= X && root.data <= Y) {
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);
        } else if (root.data >= X) {
            printInRange(root.right, X, Y);
        } else {
            printInRange(root.left, X, Y);
        }
    }
    
    //Root to Leaf paths
    public static void rootToLeafPaths(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            //Leaf Node
            printPath(path);
        } else {
            //Non Leaf Node
            rootToLeafPaths(root.left, path);
            rootToLeafPaths(root.right, path);
        }
        path.remove(path.size() - 1);
    }    
    //Function to print path
    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int v[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        
        for (int i = 0; i < v.length; i++) {
            root = createBST(root, v[i]);
        }
        
        inorder(root);
        System.out.println();
        System.out.println(search(root, 8));
        
        if ((search(root, 8))) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }

        // delete(root, 1);
        // inorder(root);
        
        // System.out.println();
        // printInRange(root, 5, 8);
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        rootToLeafPaths(root, path);
    }
}
