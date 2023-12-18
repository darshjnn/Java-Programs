package SingleLinkedList;

public class SLLquestion {
    
    Node head;
    private int size;
    
    SLLquestion() {
        this.size = 0;
    }
    
    class Node {
        String data;
        Node next;
        
        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }
    
    //Adding element at start
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        
        newNode.next = head;
        head = newNode;
    }
    
    //Adding element at last
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
    
    //Adding element in the middle
    public void add(String data, int index) {        
        if (index > size || index < 0) {
            System.out.println("Enter valid index");
            return;
        }
        
        Node newNode = new Node(data);
        if (head == null || index == 0) {
            head = newNode;
            return;
        }
        
        Node currNode = head;
        for (int i = 1; i < index; i++) {
            currNode = currNode.next;
        }
        Node nextNode = currNode.next;
        currNode.next = newNode;
        currNode = newNode;
        newNode.next = nextNode;
    }

    
    //print list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
        System.out.println();
    }

    //size of list
    public int getsize() {
        return size;
    }
    public static void main(String args[]){
        SLLquestion list = new SLLquestion();
        list.addFirst("d");
        list.addLast("r");
        list.addLast("s");
        
        list.add("a", 1);
        list.add("a", 5);

        list.printList();

    }
}