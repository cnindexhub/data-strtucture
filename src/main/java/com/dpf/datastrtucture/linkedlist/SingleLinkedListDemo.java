package com.dpf.datastrtucture.linkedlist;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        // 进行测试
        // 创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
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
        singleLinkedList.delete(4);
        // 删除后显示
        System.out.println("-----删除后显示-----");
        singleLinkedList.show();
    }
}
