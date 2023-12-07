//Singly Linked List Implementation

public class SingleLL {
    
    Node head;
    private int size;
    
    SingleLL() {
        this.size = 0;
    }
    public class Node {
        String data;
        Node next;
        
        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }
    
    // Adding element at first
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        
        newNode.next = head;
        head = newNode;
    }
    
    // Adding element at last
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    
    //Adding element in middle
    public void add(String data, int index) {
        if (index < 0 || index > size){
            System.out.println("Invalid index");
            return;
        }
        
        size++;
        Node newNode = new Node(data);
        if (head == null || index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        
        Node currNode = head;
        for (int i = 0 ; i < size; i++) {
            System.out.println(i);
            if (i == index) {
                Node nextNode = currNode.next;
                currNode.next = newNode;
                newNode.next = nextNode;
                break;
            }
            currNode = currNode.next;
        }
    }
    
    // Print Linked List
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.print(" NULL");
        System.out.println();
    }
    
    //Delete First Node
    public void deleteFirst() {
        if (head == null){
            System.out.println("List is empty");
            return;
        }
        size--;
        head = head.next;
    }
    
    //Delete Lasst Node
    public void deleteLast() {
        if (head == null){
            System.out.println("List is empty");
            return;
        }
        
        size--;
        if (head.next == null){
            head = null;
            return;
        }
        
        Node secondLastNode = head;
        Node lastNode = head.next;
        while (lastNode.next != null){
            lastNode = lastNode.next;
            secondLastNode = secondLastNode.next;
        }
        secondLastNode.next = null;
    }
    
    //Return size
    public int getsize() {
        return size;
    }
    
    public static void main(String args[]) {
        SingleLL list = new SingleLL();
        list.addFirst("a");
        list.addFirst("is");
        list.addLast("list");
        list.addFirst("this");
        list.printList();
        System.out.println();
        
        // list.deleteFirst();
        // list.printList();
        
        // list.deleteLast();
        // list.printList();   
        // System.out.println(list.getsize());   
        // list.addLast("list");
        // System.out.println(list.getsize());

        // list.add("dj", 2);
        // list.printList();
    }
}