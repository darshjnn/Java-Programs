/*
Implementation of Single Linked List

*/

package LinkedList;

public class SingleLinkedListImplementation {
	public static void main(String[] args) {
		SingleLinkedList list1 = new SingleLinkedList();
		list1.addStart(2);
		list1.addStart(1);
		list1.addEnd(4);
		list1.addStart(5);
		list1.addMid(3, 7);
		list1.addStart(0);
		System.out.println("Size of Linked List: " + list1.size);
		list1.printList();
		
		System.out.println();
		System.out.println(list1.removeStart());
		System.out.println(list1.removeEnd());
		list1.printList();
		System.out.println();

		list1.addMid(3, 7);
		list1.addStart(0);
		list1.printList();
		System.out.println("5 Found at index: " + list1.itrSearch(5));
		System.out.println("5 Found at index: " + list1.recSearch(5));
		System.out.println();

		SingleLinkedList cloneList1 = list1.copy();
		System.out.print("Clone of List: ");
		cloneList1.printList();
		System.out.print("Original List: ");
		list1.printList();
		System.out.println();

		System.out.print("Reverse: ");
		list1.reverse();
		list1.printList();
		System.out.println();

		System.out.println("Delete third Node from end: " + list1.delFromEnd(3));
		System.out.print("List after deleting: ");
		list1.printList();
		System.out.println();

		list1.addMid(2, 3);
		list1.printList();
		System.out.println("Mid Node of List: " + list1.getMid().data);
		System.out.println();

		SingleLinkedList list2 = new SingleLinkedList();
		list2.addStart(2);
		list2.addEnd(1);
		list2.addEnd(1);
		list2.addEnd(2);
		System.out.print("List: ");
		list2.printList();
		System.out.println("Is List Palindrome: " + list2.isPalindrome());
		System.out.println();

		SingleLinkedList list3 = new SingleLinkedList();
		list3.addStart(1);
		list3.addStart(2);
		list3.addStart(3);
		list3.addStart(4);
		System.out.print("List: ");
		list3.printList();
		list3.tail.next = list3.head;
		System.out.println("Cycle in List: " + list3.isCycle());
		list3.removeCycle();
		System.out.println("Still cycle in List: " + list3.isCycle());
		System.out.print("List: ");
		list3.printList();
		System.out.println();
		
		System.out.print("List: ");
		list1.printList();
		list1.head = list1.mergeSort();
		System.out.print("List after sorting: ");
		list1.printList();
		System.out.println();

		System.out.print("List: ");
		list1.printList();
		System.out.print("Zig zag list: ");
		list1.zigZag();
		list1.printList();
	}
}
