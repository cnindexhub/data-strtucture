package com.dpf.datastrtucture.arrayqueue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("--------数组模拟队列--------");
            System.out.println("(a) 新增元素");
            System.out.println("(x) 退出程序");
            System.out.println("(s) 显示队列元素");
            System.out.println("(g) 出队列");
            System.out.println("(p) 显示队列头信息");
            System.out.println("请输入指令进行操作：");
            char idt = scanner.next().charAt(0);
            switch (idt) {
                case 'a':
                    System.out.print("请输入一个数：");
                    int item = scanner.nextInt();
                    try {
                        arrayQueue.addQueue(item);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'x':
                    System.out.println("程序退出！");
                    loop = false;
                    scanner.close();
                    break;
                case 's':
                    try {
                        arrayQueue.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        System.out.println(arrayQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        System.out.println(arrayQueue.peek());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }

}

