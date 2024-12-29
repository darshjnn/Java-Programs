/*
Double Linked List Class

*/

package LinkedList;

@SuppressWarnings("DuplicatedCode")
public class DoubleLinkedList {
	Node head, tail;
	int size;
	
	public DoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	// Add element at Start
	public void addStart(int data) {
		Node newNode = new Node(data);
		++this.size;
		
		if (this.head == null) {
			this.head = this.tail = newNode;
			return;
		}
		
		newNode.next = this.head;
		this.head.prev = newNode;
		this.head = newNode;
	}
	
	// Add element at Last
	public void addEnd(int data) {
		Node newNode = new Node(data);
		++this.size;
		
		if (this.head == null) {
			this.head = this.tail = newNode;
			return;
		}
		
		newNode.prev = this.tail;
		this.tail.next = newNode;
		this.tail = newNode;
	}
	
	// Add element in Middle
	public void addMid(int data, int index) {
		Node newNode = new Node(data);
		++this.size;
		
		if (this.head == null || index <= 0) {
			this.head = this.tail = newNode;
			return;
		}
		
		if (index >= this.size) {
			this.addEnd(data);
			return;
		}
		
		int i = 0;
		Node temp = this.head;
		while (i < (index - 1)) {
			temp = temp.next;
			++i;
		}
		newNode.prev = temp;
		newNode.next = temp.next;
		temp.next.prev = newNode;
		temp.next = newNode;
	}
	
	// Remove element from Start
	public int removeStart() {
		if (this.head == null) {
			System.out.println("List is empty...");
			return Integer.MIN_VALUE;
		} else if (this.size == 1) {
			this.size = 0;
			int returnVal = this.head.data;
			this.head = this.tail = null;
			return returnVal;
		}
		
		--this.size;
		int returnVal = this.head.data;
		this.head = this.head.next;
		this.head.prev = null;
		return returnVal;
	}
	
	// Remove element from End
	public int removeEnd() {
		if (this.head == null || this.size == 1) {
			return this.removeStart();
		}
		
		--this.size;
		Node temp = this.head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		int returnVal = temp.next.data;
		temp.next.prev = null;
		temp.next = null;
		return returnVal;
	}
	
	// Print elements
	public void printList() {
		if (this.head == null) {
			System.out.println("List is empty...");
			return;
		}
		
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	// Reverse the Linked List
	public void reverse() {
		if (this.head == null) {
			System.out.println("List is empty...");
			return;
		}
		
		this.tail = this.head;
		Node curr = this.head;
		Node prev = null, next;
		
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			curr.prev = next;
			prev = curr;
			curr = next;
		}
		this.head = prev;
	}
}