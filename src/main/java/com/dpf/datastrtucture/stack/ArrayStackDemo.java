package com.dpf.datastrtucture.stack;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) {
        // 测试一下 ArrayStack 是否正确
        // 先创建一个ArrayStack对象->表示栈
        ArrayStack stack = new ArrayStack(4);
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

// 定一个栈class结构,利用数组模拟栈
class ArrayStack {


    private int maxSize; // 栈的大小

    private int[] stack; // 数组模拟栈, 数据存储

    private int top = -1; // 栈顶索引，初始化-1

    public ArrayStack (int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top + 1 == maxSize;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈
    public void push (int value) {
        if (isFull()) {
            System.out.println("栈满！");
            return;
        }
        top++;
        this.stack[top] = value;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空！没有数据~");
        }
        int value = this.stack[top];
        top--;
        return value;
    }

    // 显示栈的清况，遍历栈, 需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i, stack[i]);
        }
    }
}
