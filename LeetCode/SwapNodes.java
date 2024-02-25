/*
Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

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

// Definition for singly-linked list.
class SwapNodes {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevNode = dummy;
        ListNode currNode = head;

        while (currNode != null && currNode.next != null) {
            ListNode nextNode = currNode.next.next;
            ListNode second = currNode.next;

            currNode.next = nextNode;
            second.next = currNode;
            prevNode.next = second;

            prevNode = currNode;
            currNode = nextNode;
        }
        return dummy.next;
    }
}