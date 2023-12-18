//Implementing Queue using 2 Stacks

package Queue;

import java.util.*;

public class QueueUsing2Stacks {
    static Stack<Integer> s1 = new Stack<Integer>();
    static Stack<Integer> s2 = new Stack<Integer>();
    
    boolean isEmpty() {
        return s1.isEmpty();
    }
    
    // Enqueue
    void add(int data) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        
        s1.push(data);
        
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    
    // Dequeue
    int remove() {
        if (s1.isEmpty()) {
            System.out.println("Queue is Empty...");
            return -1;
        }
        return s1.pop();
    }
    
    // Peek
    int peek() {
        if (s1.isEmpty()) {
            System.out.println("Queue is Empty...");
            return -1;
        }
        return s1.peek();
    }
    
    public static void main(String[] args) {
        QueueUsing2Stacks q = new QueueUsing2Stacks();
        q.add(1);
        q.add(2);
        q.add(3);
        
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
