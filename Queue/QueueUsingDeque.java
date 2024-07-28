// Queue Using Deque

package Queue;

import java.util.*;

public class QueueUsingDeque {
	static class Queue {
		Deque<Integer> deque = new LinkedList<>();
		
		public boolean isEmpty() {
			return deque.isEmpty();
		}
		
		public void add(int data) {
			deque.addLast(data);
		}
		
		public int remove() {
			return deque.removeFirst();
		}
		
		public int peek() {
			if (deque.isEmpty()) {
				return -1;
			}
			return deque.peekFirst();
		}
	}
	
	public static void main(String[] args) {
		Queue q = new Queue();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		System.out.println(q.peek());
		System.out.println(q.remove());
	}
}