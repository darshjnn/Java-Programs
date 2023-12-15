//Push Elements at the bottom of the Stack

package Stack;

import java.util.Stack;

public class PushAtBottomOfStack {
    public static void pushAtBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        
        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);
    }
    
    public static void main(String args[]) {
        Stack<Integer> list = new Stack<>();
        list.push(1);
        list.push(2);
        list.push(3);

        pushAtBottom(list, 4);
        
        while (!list.isEmpty()) {
            System.out.println(list.peek());
            list.pop();
        }
    }
}
