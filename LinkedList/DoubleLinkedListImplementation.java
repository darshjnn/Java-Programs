package LinkedList;

public class DoubleLinkedListImplementation {
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		list.addStart(4);
		list.addStart(3);
		list.addStart(2);
		list.addStart(1);
		list.addEnd(5);
		list.addMid(45, 3);
		list.printList();
		System.out.println(list.removeEnd());
		list.printList();
		list.reverse();
		list.printList();
	}
}