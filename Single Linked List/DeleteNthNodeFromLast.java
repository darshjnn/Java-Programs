package SingleLinkedList;
//Delete nth Node from the last

public class DeleteNthNodeFromLast {
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
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = -1;
        ListNode currNode = new ListNode(0);
        currNode.next = head;
        // get size
        while (currNode != null) {
            sz++;
            currNode = currNode.next;
        }
        
        // main
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int del = sz - n;
        if (sz == 1) {
            head = null;
        } else if (sz == n) {
            head = head.next;
        } else {
            while (del != 0) {
                dummy = dummy.next;
                del--;
            }
            dummy.next = dummy.next.next;
        }
        
        return head;
    }
    
}
