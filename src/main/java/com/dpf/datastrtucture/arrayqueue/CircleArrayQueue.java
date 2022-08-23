package com.dpf.datastrtucture.arrayqueue;

public class CircleArrayQueue {

    private int maxSize; // 最大容量

    private int front; // 队列头

    private int rear; // 队列尾

    private int[] arr;

    public CircleArrayQueue (int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull () {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty () {
        return this.rear == this.front;
    }

    public boolean addQueue (int item) {
        if (!isFull()) {
            arr[rear] = item;
            this.rear = (rear + 1) % maxSize;
            return true;
        }
        return false;
    }

    public int getQueue () {
        if (!isEmpty()) {
            int item = arr[front];
            front = (front + 1) % maxSize;
            return item;
        }
        throw new RuntimeException("队列已经为空了！");
    }

    public int peek () {
        if (!isEmpty()) {
            return this.arr[front];
        }
        throw new RuntimeException("队列已经为空了！");
    }

    public void show () {
        if (isEmpty()) {
            throw new RuntimeException("队列已经为空了！");
        }
        for (int i = front; i < rear + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }


    public int size () {
        return (rear - front + 1) % maxSize;
    }

}
