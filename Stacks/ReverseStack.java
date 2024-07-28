// Reverse a Stack

package Stacks;

import java.util.Stack;

public class ReverseStack {
    public static void pushAtBottom(Stack<Object> stack, Object value) {
        if (stack.isEmpty()) {
            
            stack.push(value);
            return;
        }
        Object top = stack.pop();
        pushAtBottom(stack, value);
        stack.push(top);
    }
    
    public static void reverseStack(Stack<Object> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Object top = stack.pop();
        reverseStack(stack);
        pushAtBottom(stack, top);
    }
    
    public static void main(String[] args) {
        Stack<Object> list = new Stack<>();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        
        while (!list.isEmpty()) {
            System.out.print(list.peek() + " ");
            list.pop();
        }
        System.out.println();
        
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        
        reverseStack(list);
        while (!list.isEmpty()) {
            System.out.print(list.peek() + " ");
            list.pop();
        }
        System.out.println();
    }
}
