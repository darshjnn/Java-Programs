//Stack can be implemented using Array, ArrayList & Linked List

//Implementing Stack using Array List
package Stack;

import java.util.ArrayList;

public class StackUsingArrayList {
    static ArrayList<Integer> list = new ArrayList<>();
    
    public boolean isEmpty() {
        return (list.size() == 0);
    }
    
    public void push(int data) {
        list.add(data);
    }
    
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        
        int top = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return top;
    }
    
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        
        return (list.get(list.size() - 1));
    }
    
    public static void main(String args[]) {
        StackUsingArrayList list = new StackUsingArrayList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        
        while (!list.isEmpty()) {
            System.out.println(list.peek());;
            list.pop();
        }
        System.out.println(list.peek());
    }
}
