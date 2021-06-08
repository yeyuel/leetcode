package playground;

public class MyCircularQueue {

    private int[] data;
    private int front;
    private int rear;
    private int maxSize;

    public MyCircularQueue (int k) {
        data = new int[k + 1];
        front = 0;
        rear = 0;
        maxSize = k + 1;
    }

    public boolean enQueue (int value) {
        if (isFull()) {
            return false;
        } else {
            data[rear] = value;
            rear = (rear + 1) % maxSize;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            front = (front + 1) % maxSize;
        }
        return true;
    }

    public int front() {
        if (isEmpty()) return -1;
        return data[front];
    }

    public int rear() {
        if (isEmpty()) return -1;
        return data[(rear - 1 + maxSize) % maxSize]; // pay attention!!
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(2);
        queue.enQueue(1);
        System.out.println(queue.front());
        queue.enQueue(2);
        System.out.println(queue.front());
        queue.enQueue(3);
        System.out.println(queue.front());
        queue.deQueue();
        System.out.println(queue.front());
        queue.deQueue();
        queue.enQueue(4);
        System.out.println(queue.front());
        System.out.println(queue.rear());
    }
}
