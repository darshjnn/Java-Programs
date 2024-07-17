package Queue;

public class QueueUsingArray {
    static class Queue {
        static int[] arr;
        static int size;
        static int rear;
        
        Queue(int size) {
            arr = new int[size];
            Queue.size = size;
            Queue.rear = -1;
        }
        
        public boolean isEmpty() {
            return rear == -1;
        }
        
        public void enqueue(int item) {
            if (rear == (size - 1)) {
                System.out.println("Queue is full...");
                return;
            }
            arr[++rear] = item;
        }
        
        public int dequeue() {
            if (isEmpty()) {
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            --rear;
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
        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println();
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}