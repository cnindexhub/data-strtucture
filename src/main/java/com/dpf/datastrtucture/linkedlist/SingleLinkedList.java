package com.dpf.datastrtucture.linkedlist;


// 定义SingleLinkedList 管理我们的英雄
public class SingleLinkedList {

    // 初始化一个头节点
    private HeroNode head = new HeroNode(0, "", "");

    // 添加节点到单向链表
    // 思路：当不考虑编号顺序是
    // 1. 找到当前链表的最后节点
    // 2. 将最后这个节点的next 指向 新的节点
    public void add(HeroNode heroNode) {
        // 因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        // 遍历链表，找到最后
        while(true) {
            // 当前没有next节点时 说明已经到最后一个节点了
            if (temp.next == null) {
                break;
            }
            // temp 引用 挂载为下一个节点
            temp = temp.next;
        }
        // 此时添加
        temp.next = heroNode;
    }

    // 根据no排序将英雄插入到指定顺序位置
    // 如果有这个排名，则添加失败，并给出提示
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            // 当前英雄已经存在
            if (heroNode.no == temp.next.no) {
                flag = true;
                break;
            }
            // 在temp 指向添加的英雄
            if (temp.next.no > heroNode.no) {
                break;
            }
            // 操作排序的英雄
            temp = temp.next;
        }
        if (flag) {
            System.out.println("当前英雄已经存在！");
        } else {
            HeroNode tempNext = temp.next;
            heroNode.next = tempNext;
            temp.next = heroNode;
        }
    }


    /**
     * 修改节点的信息，根据no遍历来修改，即no编号不能改
     * @param newHeroNode 修改后的节点对象
     */
    public void update(HeroNode newHeroNode) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        // 找到需要修改的节点，根据no编号
        // 定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false; // 表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
            System.out.println("修改成功!");
        } else {
            System.out.println("没有找到该节点~");
        }
    }

    /**
     * 删除节点
     * @param no 英雄编号
     */
    public void delete (int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
            System.out.println("删除成功!");
        } else {
            System.out.println("没有找到元素！");
        }
    }

    /**
     * 获取中间的链表中间节点
     * @return HeroNode middleHeroNode
     */
    public HeroNode middleHeroNode () {
        HeroNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void show () {
        HeroNode temp = head.next;
        if (head.next == null) {
            System.out.println("链表为空！");
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void foreachShowList (HeroNode head) {
        HeroNode temp = head.next;
        if (head.next == null) {
            System.out.println("链表为空！");
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public HeroNode getHead () {
        return this.head;
    }
}
