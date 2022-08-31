package com.dpf.datastrtucture.linkedlist;

import org.springframework.beans.factory.config.BeanDefinitionHolder;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        // 进行测试
        // 创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
//        HeroNode heroNode5 = new HeroNode(5, "鲁智深", "花和尚");
        // 创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 添加节点
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode4);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode2);
        // 添加节点 带编号排序
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);
//        singleLinkedList.addByOrder(heroNode5);
        // 修改前显示
        System.out.println("-----修改前显示-----");
        singleLinkedList.show();
        // 修改节点
        singleLinkedList.update(new HeroNode(2, "小卢", "玉麒麟~"));
        // 修改后显示
        System.out.println("-----修改后显示-----");
        singleLinkedList.show();
        // 删除节点
//        singleLinkedList.delete(1);
//        singleLinkedList.delete(2);
//        singleLinkedList.delete(3);
//        singleLinkedList.delete(4);
        // 删除后显示
        System.out.println("-----删除后显示-----");
        singleLinkedList.show();
        // 获取位于链表中间的英雄
        System.out.println(singleLinkedList.middleHeroNode());
        // 获取当前链表的有效节点个数
        System.out.println("-----显示当前链表的有效节点个数-----");
        System.out.println(getLength(singleLinkedList.getHead()));
        // 获取当前链表的倒数第k个节点
        System.out.println("-----显示当前链表的倒数第k个节点-----");
        System.out.println(findLastIndexHeroNode(singleLinkedList.getHead(), 4));
        // 反转当前链表--使用迭代法
        System.out.println("-----反转当前链表--使用迭代法-----");
        HeroNode head = reversalListByIterativeMethod(singleLinkedList.getHead());
        System.out.println(head);
        // 使用迭代法反转后显示
        System.out.println("-----使用迭代法反转后显示-----");
        singleLinkedList.foreachShowList(head);
        // 反转当前链表--使用递归法
//        System.out.println("-----反转当前链表--使用递归法-----");
//        head = reversalListByRecursiveMethod(singleLinkedList.getHead().next);
//        System.out.println(head);
        // 利用栈的先进后出的特性打印链表
        System.out.println("-----利用栈的先进后出的特性逆序打印单链表-----");
        reverseOrderPrintListNode(head);
    }


    // 方法：获取到单链表的节点个数

    /**
     *
     * @param head 链表头节点
     * @return 返回有效节点个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        while (head.next != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    // 查找单链表中倒数第k个节点 【新浪面试题】
    // 思路
    public static HeroNode findLastIndexHeroNode(HeroNode head, int k) {
        if (head.next == null) {
            return null;
        }
        int length = getLength(head);
        if (k > length || k <= 0) {
            return null;
        }
        int index = length - k;
        while (index >= 0) {
            head = head.next;
            index--;
        }
        return head;
    }

    /**
     * 反转单链表迭代法
     * @param head 待头节点的链表
     * @return 反转后的链表
     */
    public static HeroNode reversalListByIterativeMethod (HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return null;
        }
        HeroNode pre = null;
        HeroNode cur = head.next;
        while(cur != null) {
            HeroNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = pre;
        return head;
    }

    /**
     * 反转单链表迭代法
     * @param head 待头节点的链表
     * @return 反转后的链表
     */
    public static HeroNode reversalListByRecursiveMethod (HeroNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        HeroNode newHeroNode = reversalListByRecursiveMethod(head.next);
        head.next.next = newHeroNode;
        head.next = null;
        return newHeroNode;
    }

    // 从尾到头打印单链表
    // 思路
    // 方法1：先将单链表进行反转操作，然后再遍历即可
    // 方法2: 可以利用栈这个数据结构，将各个节点压入栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
    // 使用方式2来实现逆序打印

    public static void reverseOrderPrintListNode (HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        while (true) {
            if (head.next == null) {
                break;
            }
            head = head.next;
            stack.push(head);
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }


}
