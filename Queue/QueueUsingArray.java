package Queue;

public class QueueUsingArray {
    static class Queue {
        static int size;
        static int arr[];
        static int rear = -1;
        
        Queue(int n) {
            arr = new int[n];
            Queue.size = n;
        }
        
        public boolean isEmpty() {
            return rear == -1;
        }
        
        // Enqueue
        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }
        
        // Dequeue
        // If implemented using array, time complexity = O(n), else O(1)
        public int remove() {
            if (isEmpty()) {
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }
        
        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return arr[0];
        }
    }
    
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}