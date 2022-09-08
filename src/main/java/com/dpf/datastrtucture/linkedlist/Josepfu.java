package com.dpf.datastrtucture.linkedlist;

/**
 * 约瑟夫问题
 * 构建一个单向的环形链表思路
 * 1. 先创建第一个节点，让first指向该节点，并形成环形
 * 2. 后面当我们每创建一个新的节点，就把该节点加入已有的环形链表中即可
 * 遍历环形链表
 * 创建一个first节点、curBoy节点，curBoy 节点指向first节点
 * 当前curBoy.next == first 时循环结束
 */
public class Josepfu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(6); // 加入6个小孩
        circleSingleLinkedList.showBoy(); // 遍历显示小孩编号
        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}

// 创建一个环形的单向链表
class CircleSingleLinkedList {
    // 创建一个first节点, 当前没有编号
    private Boy first = new Boy(-1);

    /**
     * 添加小孩节点，构建成一个环形链表
     * @param nums 节点数
     */
    public void addBoy (int nums) {
        // 边界判断 nums
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null; // 辅助指针， 帮助构建环形链表
        // 使用for来创建一个循环链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first); // 构造第一道闭环
                curBoy = first;
                continue;
            }
            boy.setNext(first);
            curBoy.setNext(boy);
            curBoy = boy;
        }
    }

    /**
     * 遍历当前环形链表
     */
    public void showBoy() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩~~");
            return;
        }
        // 因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号为：%d\n", curBoy.getNo());
            if (curBoy.getNext().getNo() == first.getNo()) {
                return;
            }
            curBoy = curBoy.getNext();
        }
    }

    // 根据用户的输入，计算出小孩出圈的顺序
    // 根据用户的输入，生成一个小孩出圈的顺序
    // n=5,即有5个人
    // k=1,从第一个人开始报数
    // m=2,数2下

    // 1. 需求创建一个辅助指针(变量)helper,事先应该指向环形链表的最后这一个节点
    // 2. 小孩报数前先让first移动到k-1的位置
    // 3. 当小孩报数时，让first和helper指针同时的移动m-1次
    // 4. first = first.next;
    // helper.next = first;
    // 原来first指向的节点就没有任何引用，就会被回收
    /**
     *
     * @param startNo
     * @param countNum
     * @param nums
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        // 创建一个辅助指针，帮助完成小孩出圈
        Boy helper = first;
        // 需求需要创建一个辅助指针(变量) helper， 事先应该指向环形链表的最后一个节点
        while(true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        // 小孩报数前先让first移动到k-1的位置
        for (int j = 0; j < startNo -1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 当小孩报数时，让first 和 helper 指针同时移动 m - 1 次, 然后出圈
        // 这里是一个循环操作，知道圈中只有一个节点
        int count = 0;
        while(true) {
            if(helper == first) {
                break;
            }
            count ++;
            first = first.getNext();
            helper = helper.getNext();
            if (count == (countNum - 1)) {
                count = 0;
                System.out.println(first.getNo());
                helper.setNext(first.getNext());
            }
        }
    }
}

// 创建一个Boy类，表示一个节点
class Boy {

    private int no; // 编号
    private Boy next; // 指向下一个节点， 默认null

    public Boy (int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
