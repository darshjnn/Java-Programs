package LinkedList;

public class DoubleLinkedList {
	public Node head;
	public Node tail;
	public int size;
	
	
	DoubleLinkedList() {
		this.size = 0;
	}
	
	public class Node {
		int data;
		Node next;
		Node prev;
		
		Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
			size++;
		}
	}
	
	// Add at Start
	public void addStart(int data) {
		Node newNode = new Node(data);
		++this.size;
		if (this.head == null) {
			this.head = this.tail = newNode;
			return;
		}
		newNode.next = this.head;
		this.head.prev = newNode;
		head = newNode;
	}
	
	// Add at End
	public void addEnd(int data) {
		Node newNode = new Node(data);
		if (this.head == null) {
			addStart(data);
			return;
		}
		++this.size;
		Node temp = this.head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		newNode.prev = temp;
		this.tail = newNode;
	}
	
	// Add in Middle
	public void addMid(int index, int data) {
		Node newNode = new Node(data);
		if (this.head == null || index <= 0) {
			addStart(data);
			return;
		}
		if (index >= this.size) {
			addEnd(data);
			return;
		}
		++this.size;
		Node temp = this.head;
		int i = 0;
		while (i < (index - 1)) {
			temp = temp.next;
			i++;
		}
		newNode.prev = temp;
		newNode.next = temp.next;
		temp.next.prev = newNode;
		temp.next = newNode;
	}
	
	// Remove from Start
	public int removeStart() {
		if (this.head == null) {
			return Integer.MIN_VALUE;
		}
		--this.size;
		if (this.size == 1) {
			int returnVal = this.head.data;
			this.head = this.tail = null;
			return returnVal;
		}
		int returnVal = this.head.data;
		this.head = this.head.next;
		this.head.prev = null;
		return returnVal;
	}
	
	// Remove from End
	public int removeEnd() {
		if (this.head == null) {
			return Integer.MAX_VALUE;
		}
		if (this.size == 1) {
			return removeStart();
		}
		--this.size;
		Node temp = this.head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		int returnVal = temp.data;
		temp.next.prev = null;
		temp.next = null;
		return returnVal;
	}
	
	// Print Elements
	public void print() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	// Reverse the Linked List
	public void reverse() {
		this.tail = this.head;
		Node curr = this.head;
		Node prev = null;
		Node next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			curr.prev = next;
			prev = curr;
			curr = next;
		}
		this.head = prev;
	}
	
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		list.addStart(4);
		list.addStart(3);
		list.addStart(2);
		list.addStart(1);
		list.addEnd(5);
		list.addMid(3, 45);
		list.print();
		System.out.println(list.removeEnd());
		list.print();
		list.reverse();
		list.print();
	}
}