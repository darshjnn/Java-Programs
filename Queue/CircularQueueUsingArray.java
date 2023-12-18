//Creating circular Queue using Arrays

package Queue;

public class CircularQueueUsingArray {
    static class Queue {
        static int arr[];
        static int size;
        static int rear = -1;
        static int front = -1;
        
        Queue (int n) {
            arr = new int[n];
            Queue.size = n;
        }
        
        static boolean isEmpty() {
            return rear == -1 && front == -1;
        }
        
        static boolean isFull() {
            return (rear + 1) % size == front;
        }
        
        //Enqueue
        static void add(int data) {
            if(isFull()) {
                System.out.println("Queue is full...");
                return;
            }
            
            //For first element
            if(front == -1) {
                front = 0;
            }
            
            rear = (rear + 1) % size;
            arr[rear] = data;
        }
        
        //Dequeue - Time Complexity: O(1)
        static int remove() {
            if(isEmpty()) {
                System.out.println("Queue is Empty...");
                return -1;
            }
            
            int result = arr[front];
            
            //Single element
            if(rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }
        
        //Peek
        static int peek() {
            if(isEmpty()) {
                System.out.println("Queue is empty...");
                return -1;
            }
            
            return arr[front];
        }
    }
}
