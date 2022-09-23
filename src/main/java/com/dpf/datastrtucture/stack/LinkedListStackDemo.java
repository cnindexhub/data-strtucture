package com.dpf.datastrtucture.stack;

import java.util.Scanner;

public class LinkedListStackDemo {
    public static void main(String[] args) {
        // 测试一下 LinkedListStack 是否正确
        // 先创建一个LinkedListStack对象->表示栈
        LinkedListStack stack = new LinkedListStack();
        String key = "";
        boolean loop = true; // 控制是否退出菜单
        Scanner scanner = new Scanner(System.in);


        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈");
            System.out.println("pop: 表示从栈取出数据（出战）");
            System.out.print("请输入你的选择：");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "exit":
                    System.out.println("程序退出...");
                    scanner.close();
                    return;
                case "push":
                    System.out.print("请输入一个数：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        System.out.printf("出栈的数据为：%d\n", stack.pop());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }

        }
    }
}
// 定一个栈class结构, 利用单向链表模拟栈
class LinkedListStack {

    // 当前栈的深度
    int maxSize;

    public LinkedListStack() {}

    // 头节点
    Node head = new Node() ;

    static class Node {

        Node next;

        int value;

        public Node(){}

        public Node(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    // 栈空
    public boolean isEmpty() {
        return maxSize == 0;
    }

    // 入栈
    public void push(int value) {
        Node node = new Node(value);
        Node tempNode = head.next;
        node.next = tempNode;
        head.next = node;
        maxSize++;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空！没有数据~");
        }
        int value = head.next.getValue();
        head.next = head.next.next;
        maxSize--;
        return value;
    }

    // 显示栈的清况，遍历栈, 需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~");
            return;
        }
        Node tempNode = head;
        for (int i = maxSize; i > 0; i--) {
            tempNode = tempNode.next;
            System.out.printf("stack[%d]=%d\n", (i-1), tempNode.getValue());
        }
    }
}