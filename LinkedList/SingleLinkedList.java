/*
Single Linked List Class

*/

package LinkedList;

public class SingleLinkedList {
	Node head, tail;
	int size;
	
	class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
			++size;
		}
	}
	
	public SingleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	// Add element at Start
	public void addStart(int data) {
		Node newNode = new Node(data);
		
		if (this.head == null) {
			this.head = this.tail = newNode;
			return;
		}
		
		newNode.next = this.head;
		this.head = newNode;
	}
	
	// Add element at Last
	public void addEnd(int data) {
		Node newNode = new Node(data);
		
		if (this.head == null) {
			this.head = this.tail = newNode;
			return;
		}
		
		this.tail.next = newNode;
		this.tail = newNode;
	}
	
	// Add element in Middle
	public void addMid(int data) {
	
	}
}
