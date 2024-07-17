package LinkedList;

public class SingleLinkedList {
	public Node head;
	public Node tail;
	int size;
	
	public SingleLinkedList() {
		this.size = 0;
	}
	
	public class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
			size++;
		}
	}
	
	//	Add element at Start
	public void addStart(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}
	
	//	Add element at Last
	public void addEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
			return;
		}
		tail.next = newNode;
		tail = newNode;
	}
	
	//	Add element in Middle
	public void addMid(int data, int index) {
		if (this.head == null || index <= 0) {
			addStart(data);
		}
		if (index >= this.size) {
			addEnd(data);
		}
		Node newNode = new Node(data);
		Node temp = head;
		int i = 0;
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
	
	//	Remove element from Start
	public Object removeStart() {
		if (head == null) {
			return Integer.MIN_VALUE;
		} else if (size == 1) {
			size = 0;
			Object temp = head.data;
			head = tail = null;
			return temp;
		}
		size--;
		Object temp = head.data;
		head = head.next;
		return temp;
	}
	
	//	Remove element From End
	public Object removeEnd() {
		if (head == null) {
			return Integer.MAX_VALUE;
		} else if (size == 1) {
			size = 0;
			Object temp = head.data;
			head = tail = null;
			return temp;
		}
		int i = 0;
		Node prev = head;
		while (i < (size - 2)) {
			prev = prev.next;
			i++;
		}
		size--;
		Object temp = prev.next.data;
		prev.next = null;
		tail = prev;
		return temp;
	}
	
	
	//	Print elements
	public void printList() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	//	Search an Element using Iteration
	public Object itrSearch(int key) {
		Node temp = head;
		int i = 0;
		while (temp != null) {
			if (temp.data == key) {
				return i;
			}
			i++;
			temp = temp.next;
		}
		return Integer.MAX_VALUE;
	}
	
	// Search an Element using Recursion
	private int recSearchHelper(Node head, int key) {
		if (head == null) {
			return Integer.MAX_VALUE;
		}
		if (head.data == key) {
			return 0;
		}
		int index = recSearchHelper(head.next, key);
		if (index == Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		return ++index;
	}
	
	public int recSearch(int key) {
		return recSearchHelper(head, key);
	}
	
	// Clone the Linked List
	public SingleLinkedList copy() {
		SingleLinkedList clone = new SingleLinkedList();
		Node temp = this.head;
		while (temp != null) {
			clone.addEnd(temp.data);
			temp = temp.next;
		}
		return clone;
	}
	
	// Reverse the Linked List
	public void reverse() {
		Node prev = null;
		Node curr = tail = head;
		Node next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	
	// Delete Nth node from End
	public Object delFromEnd(int n) {
		Object temp;
		if (size <= n) {
			temp = head.data;
			head = head.next;
			return temp;
		}
		Node prev = head;
		int index = size - n;
		int i = 1;
		while (i < index) {
			prev = prev.next;
			i++;
		}
		temp = prev.next.data;
		prev.next = prev.next.next;
		return temp;
	}
	
	// Finding Middle Node Linked List using Slow-fast approach
	public Node getMid() {
		Node slow = this.head; // Turtle
		Node fast = this.head; // Hare
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	// Check if Linked List is Palindrome
	public boolean palindrome() {
		if (head == null || head.next == null) {
			return true;
		}
		Node curr = this.getMid();
		Node prev = null;
		Node next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		Node right = prev;
		Node left = this.head;
		while (right != null) {
			if (left.data != right.data) {
				return false;
			}
			right = right.next;
			left = left.next;
		}
		return true;
	}
	
	// Floyd's Cycle Finding Algorithm
	public boolean isCycle() {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
	
	// Remove Cycle
	public void removeCycle() {
		Node slow = head;
		Node fast = head;
		boolean flag = false;
		while (head != null && head.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			return;
		}
		slow = head;
		Node prev = fast;
		while (fast != slow) {
			prev = fast;
			fast = fast.next;
			slow = slow.next;
		}
		prev.next = null;
	}
	
	// Merge Sort
	private Node getMid(Node head) {
		Node slow = head;
		Node fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private Node merge(Node leftHead, Node rightHead) {
		Node merged = new Node(-1);
		Node temp = merged;
		while (leftHead != null && rightHead != null) {
			if (leftHead.data < rightHead.data) {
				temp.next = leftHead;
				leftHead = leftHead.next;
			} else {
				temp.next = rightHead;
				rightHead = rightHead.next;
			}
			temp = temp.next;
		}
		while (leftHead != null) {
			temp.next = leftHead;
			leftHead = leftHead.next;
			temp = temp.next;
		}
		while (rightHead != null) {
			temp.next = rightHead;
			rightHead = rightHead.next;
			temp = temp.next;
		}
		return merged.next;
	}
	
	public Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node mid = getMid(head);
		Node right = mid.next;
		mid.next = null;
		return merge(mergeSort(head), mergeSort(right));
	}
	
	// Zig-zag Linked list OR Reorder List
	public void zigZag() {
		Node mid = this.getMid();
		Node nextLeft, nextRight;
		Node left = head;
		Node curr = mid.next, prev = null, next;
		mid.next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		Node right = prev;
		while (left != null && right != null) {
			nextLeft = left.next;
			left.next = right;
			nextRight = right.next;
			right.next = nextLeft;
			left = nextLeft;
			right = nextRight;
		}
	}
	
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.addStart(2);
		list.addStart(1);
		list.addEnd(4);
		list.addStart(5);
		list.addMid(3, 7);
		list.addStart(0);
		System.out.println("Size of Linked List: " + list.size);
		list.printList();
		
		System.out.println();
		System.out.println(list.removeStart());
		System.out.println(list.removeEnd());
		System.out.println();
		
		list.printList();
		System.out.println("Found at index: " + list.itrSearch(5));
		System.out.println("Found at index: " + list.recSearch(5));
		
		SingleLinkedList clone = list.copy();
		clone.printList();
		
		list.reverse();
		list.printList();
		
		System.out.println(list.delFromEnd(3));
		list.printList();
		
		System.out.println(list.getMid().data);
		
		SingleLinkedList list2 = new SingleLinkedList();
		list2.addStart(2);
		list2.addEnd(1);
		list2.addEnd(1);
		list2.addEnd(2);
		list2.printList();
		System.out.println(list2.palindrome());
		
		SingleLinkedList list3 = new SingleLinkedList();
		list3.addStart(1);
		list3.addStart(2);
		list3.addStart(3);
		list3.addStart(4);
		list3.head.next.next.next.next = list3.head;
		System.out.println(list3.isCycle());
		list3.removeCycle();
		System.out.println(list3.isCycle());
		list.mergeSort(list.head);
		list.printList();
		SingleLinkedList ll = new SingleLinkedList();
		ll.head = list.mergeSort(list.head);
		ll.printList();
		list.printList();
		
		list.zigZag();
		list.printList();
	}
}