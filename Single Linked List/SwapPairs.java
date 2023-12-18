package SingleLinkedList;

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