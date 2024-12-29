/*
24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's nodes
(i.e., only nodes themselves may be changed.)

Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]

Example 2:
Input: head = []
Output: []

Example 3:
Input: head = [1]
Output: [1]

*/

package LinkedList.LeetCode;

import LinkedList.Node;
import LinkedList.SingleLinkedList;

public class SwapNodesInPairs {
	public static void swapNodes(SingleLinkedList list) {
		if (list.head == null) {
			System.out.println("List is empty...");
			return;
		}
		
		if (list.head.next == null) {
			return;
		}
		
		Node temp = new Node(-1);
		temp.next = list.head;
		Node prev = temp;
		Node curr = list.head;

		while (curr != null && curr.next != null) {
			Node secondNext = curr.next.next;
			Node next = curr.next;

			curr.next = secondNext;
			next.next = curr;
			prev.next = next;

			prev = curr;
			curr = secondNext;
		}
		
		list.head = temp.next;
	}
	
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.addStart(5);
		list.addEnd(1);
		list.addEnd(4);
		Node newNode = new Node(6);
		list.head.next.next.next = newNode;
		newNode.next = new Node(8);
		newNode.next.next = new Node(9);
		list.size += 2;
		list.printList();
		
		swapNodes(list);
		
		list.printList();
	}
}