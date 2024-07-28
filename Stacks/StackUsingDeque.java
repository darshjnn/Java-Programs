// Stack Using Deque

package Stacks;

import java.util.*;

public class StackUsingDeque {
	static class Stack {
		Deque<Integer> deque = new LinkedList<>();
		
		public boolean isEmpty() {
			return deque.isEmpty();
		}
		
		public void add(int data) {
			deque.addLast(data);
		}
		
		public int pop() {
			return deque.removeLast();
		}
		
		public int peek() {
			if (deque.isEmpty()) {
				return -1;
			}
			return deque.peekLast();
		}
	}
	
	public static void main(String[] args) {
		Stack s = new Stack();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		System.out.println(s.peek());
		System.out.println(s.pop());
	}
}