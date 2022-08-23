package com.dpf.datastrtucture.arrayqueue;

// 使用数组模拟队列
public class ArrayQueue {

    private int maxSize;

    private int front;

    private int rear;

    private int[] arr;

    public ArrayQueue (int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        this.rear = -1;
        this.front = -1;
    }

    public boolean isFull () {
        return this.rear == maxSize -1;
    }

    public boolean isEmpty () {
        return this.rear == this.front;
    }

    public boolean addQueue (int item) {
        if (!isFull()) {
            this.rear++;
            this.arr[this.rear] = item;
            return true;
        }
        return false;
    }

    public int getQueue () {
        if (!isEmpty()) {
            this.front++;
            return this.arr[front];
        }
        System.out.println("队列已经为空了！");
        throw new RuntimeException("队列已经为空了！");
    }

    public int peek () {
        if (!isEmpty()) {
            return this.arr[front + 1];
        }
        throw new RuntimeException("队列已经为空了！");
    }

    public void show () {
        if (isEmpty()) {
            throw new RuntimeException("队列已经为空了！");
        }
        for (int i = 0; i < maxSize; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

}
