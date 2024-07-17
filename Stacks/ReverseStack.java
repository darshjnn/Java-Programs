// Reverse a Stack

package Stacks;

import java.util.Stack;

public class ReverseStack {
    public static void pushAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            
            stack.push(value);
            return;
        }
        int top = stack.pop();
        pushAtBottom(stack, value);
        stack.push(top);
    }
    
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        pushAtBottom(stack, top);
    }
    
    public static void main(String[] args) {
        Stack<Integer> list = new Stack<>();
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
