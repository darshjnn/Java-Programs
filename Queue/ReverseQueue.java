// Reverse a Queue

package Queue;

import java.util.*;

public class ReverseQueue {
	public static void reverseQueue(Queue<Object> queue) {
		if (queue.size() < 2) {
			return;
		}
		Object front = queue.poll();
		reverseQueue(queue);
		queue.offer(front);
	}
	
	public static void main(String[] args) {
		Queue<Object> queue = new LinkedList<>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		queue.offer(5);
		while (!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
		System.out.println();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		queue.offer(5);
		reverseQueue(queue);
		while (!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
	}
}