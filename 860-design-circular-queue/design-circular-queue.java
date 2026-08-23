class MyCircularQueue {
    int[] queue;
    int idx;
    int front;
    int rear;
    int size;

    public MyCircularQueue(int k) {
        queue = new int[k];
        idx = 0;
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;

        queue[idx] = value;

        rear = idx;
        idx = (idx + 1) % queue.length;

        size++;

        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;

        front = (front + 1) % queue.length;
        size--;

        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return queue[front];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return queue[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == queue.length;
    }
}