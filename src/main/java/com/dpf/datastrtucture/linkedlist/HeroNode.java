package com.dpf.datastrtucture.linkedlist;

/**
 * 英雄类
 */
public class HeroNode {

    // 编号
    public int no;
    // 名称
    public String name;
    // 昵称
    public String nickName;
    // 指向下一个节点
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
