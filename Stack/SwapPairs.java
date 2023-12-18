package LinkedList;

//  Definition for singly-linked list.

class SwapPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode list = new ListNode(0);
        list.next = head;
        ListNode currNode = list;
        
        while (currNode != null && currNode.next != null) {
            ListNode first = currNode.next;
            ListNode second = currNode.next.next;
            
            currNode.next = second;
            first.next = second.next;
            second.next = first;
            currNode = currNode.next.next;
        }
        return list.next;
    }
}