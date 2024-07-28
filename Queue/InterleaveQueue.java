// Interleaving 2 halves of Queue

package Queue;

import java.util.*;

public class InterleaveQueue {
	public static void interleaveQueue(Queue<Object> q) {
		if (q.isEmpty() || q.size() == 1) {
			return;
		}
		Queue<Object> first = new LinkedList<>();
		int size = q.size();
		for (int i = 0; i < (size / 2); i++) {
			first.offer(q.poll());
		}
		for (int i = 0; i < size / 2; i++) {
			q.offer(first.poll());
			q.offer(q.poll());
		}
	}
	
	public static void main(String[] args) {
		Queue<Object> q = new LinkedList<>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		q.offer(6);
		while (!q.isEmpty()) {
			System.out.print(q.poll() + " ");
		}
		System.out.println();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		q.offer(6);
		interleaveQueue(q);
		while (!q.isEmpty()) {
			System.out.print(q.poll() + " ");
		}
	}
}