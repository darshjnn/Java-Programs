/*
143. Reorder List

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

*/

package LeetCode;

public class ReorderList {
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    static class SingleLinkedList {
        Node head;
        int size;
        
        SingleLinkedList() {
            this.size = 0;
        }
        
        // Add at Start
        public void addStart(int data) {
            Node newNode = new Node(data);
            ++this.size;
            if (this.head == null) {
                this.head = newNode;
                return;
            }
            newNode.next = head;
            this.head = newNode;
        }
        
        // Add at Last
        public void addLast(int data) {
            Node newNode = new Node(data);
            ++this.size;
            if (this.head == null) {
                this.head = newNode;
                return;
            }
            Node temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        
        // Add in Middle
        public void addMid(int index, int data) {
            Node newNode = new Node(data);
            ++this.size;
            if (index == 0) {
                addStart(data);
            }
            int i = 0;
            Node temp = this.head;
            while (i < (index - 1)) {
                if (temp.next == null) {
                    temp.next = newNode;
                    return;
                }
                temp = temp.next;
                i++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        
        
        // Print List
        public void print() {
            if (head == null) {
                System.out.println("List is Empty...");
                return;
            }
            Node temp = this.head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
        
        // Get Middle Node
        public Node getMid() {
            Node slow = this.head;
            Node fast = this.head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
        
        // Zig-zag List OR Reorder List
        public void reorder() {
            Node mid = this.getMid();
            Node curr = mid.next;
            mid.next = null;
            Node left = head;
            Node prev = null;
            Node next;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node right = prev;
            Node tempLeft, tempRight;
            while (right != null && left != null) {
                tempLeft = left.next;
                left.next = right;
                tempRight = right.next;
                right.next = tempLeft;
                left = tempLeft;
                right = tempRight;
            }
        }
    }
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(3);
        list.addStart(0);
        list.addLast(4);
        list.addStart(1);
        list.addMid(2, 2);
        list.addLast(5);
        list.print();
        list.reorder();
        list.print();
    }
}
