/*
160. Intersection of Two Linked Lists

Given the heads of two singly linked-lists headA and headB, return the node at which the
two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:
The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.

Custom Judge:
The inputs to the judge are given as follows (your program is not given these inputs):

intersectVal - The value of the node where the intersection occurs.
This is 0 if there is no intersected node.
listA - The first linked list.
listB - The second linked list.
skipA - The number of nodes to skip ahead in listA (starting from the head) to get to
		the intersected node.
skipB - The number of nodes to skip ahead in listB (starting from the head) to get to
		the intersected node.
The judge will then create the linked structure based on these inputs and pass the
two heads, headA and headB to your program. If you correctly return the intersected node,
then your solution will be accepted.

Example 1:
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8
(note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5].
There are 2 nodes before the intersected node in A; There are 3 nodes before the
intersected node in B.
- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B
(2nd node in A and 3rd node in B) are different node references.
In other words, they point to two different locations in memory, while the nodes with value 8
in A and B (3rd node in A and 4th node in B) point to the same location in memory.

Example 2:
Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2'
Explanation: The intersected node's value is 2 (note that this must not be 0
if the two lists intersect).
From the head of A, it reads as [1,9,1,2,4].
From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A;
There are 1 node before the intersected node in B.

Example 3:
Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: No intersection
Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5].
Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be
arbitrary values.
Explanation: The two lists do not intersect, so return null.

*/

package LinkedList.LeetCode;

import LinkedList.Node;
import LinkedList.SingleLinkedList;

public class IntersectionOfLinkedList {
	@SuppressWarnings("ALL")
	public static int getIntersectionNode(Node head1, Node head2) {
		int len1 = 0, len2 = 0;
		Node temp1 = head1;
		Node temp2 = head2;
		while (temp1 != null) {
			++len1;
			temp1 = temp1.next;
		}
		while (temp2 != null) {
			++len2;
			temp2 = temp2.next;
		}
		
		if (len1 > len2) {
			for (int i = 0; i < (len1 - len2); i++) {
				head1 = head1.next;
			}
		} else if (len2 > len1) {
			for (int i = 0; i < (len2 - len1); i++) {
				head2 = head2.next;
			}
		}
		
		while (head1 != head2) {
			head1 = head1.next;
			head2 = head2.next;
		}
		
		if (head1 != null) {
			return head1.data;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		SingleLinkedList list1 = new SingleLinkedList();
		list1.addStart(1);
		list1.addEnd(2);
		list1.addEnd(3);
		Node newNode = new Node(4);
		list1.head.next.next.next = newNode;
		newNode.next = new Node(5);
		newNode.next.next = new Node(6);
		list1.size += 2;
		list1.printList();
		
		SingleLinkedList list2 = new SingleLinkedList();
		list2.addStart(10);
		list2.addEnd(20);
		list2.addEnd(30);
		list2.head.next.next.next = newNode;
		list2.printList();
		
		System.out.println(getIntersectionNode(list1.head, list2.head));
	}
}

/*
Brute force Approach:
	Node temp1 = head1;
	while (temp1 != null) {
		Node temp2 = head2;
		while (temp2 != null) {
			if (temp1.data == temp2.data) {
				return temp2.data;
			}
			temp2 = temp2.next;
		}
		temp1 = temp1.next;
	}
	return 0;
*/