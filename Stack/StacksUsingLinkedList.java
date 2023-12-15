//Stack can be implemented using Array, ArrayList & Linked List

//Implementing Stack in the form of Linked List
package Stack;

public class StacksUsingLinkedList {
    
    public class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    
    public static Node head = null;
    
    public boolean isEmpty() {
        return (head == null);
    }
    
    public void push(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    
    
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        
        int top = head.data;
        head = head.next;
        return top;
    }
    
    public  int peek() {
        if (isEmpty()) {
            return -1;
        }
        
        return head.data;
    }
    
    public static void main(String args[]) {
        StacksUsingLinkedList s = new StacksUsingLinkedList();
        
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}


