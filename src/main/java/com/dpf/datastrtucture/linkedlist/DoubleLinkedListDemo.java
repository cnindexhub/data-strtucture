package com.dpf.datastrtucture.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        // 测试
        // 创建节点
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
//        doubleLinkedList.add(heroNode4);
        // 遍历显示
        doubleLinkedList.show();

        // 修改
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);

        // 遍历显示
        doubleLinkedList.show();


        doubleLinkedList.delete(2);

        // 遍历显示
        doubleLinkedList.show();

    }

}

class DoubleLinkedList {

    // 初始化双向链表
    private HeroNode2 head = new HeroNode2(0, "", "");

    /**
     * 获取链表头
     * @return
     */
    public HeroNode2 getHead() {
        return head;
    }

    public void show () {
        HeroNode2 temp = head.next;
        if (head.next == null) {
            System.out.println("链表为空！");
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 添加节点到单向链表
    // 思路：当不考虑编号顺序是
    // 1. 找到当前链表的最后节点
    // 2. 将最后这个节点的next 指向 新的节点
    public void add(HeroNode2 heroNode) {
        // 因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode2 temp = head;
        // 遍历链表，找到最后
        while(true) {
            // 当前没有next节点时 说明已经到最后一个节点了
            if (temp.next == null) {
                break;
            }
            // temp 引用 挂载为下一个节点
            temp = temp.next;
        }
        // 此时添加,形成双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    // 根据no排序将英雄插入到指定顺序位置
    // 如果有这个排名，则添加失败，并给出提示
    public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;
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
            HeroNode2 tempNext = temp.next;
            heroNode.next = tempNext;
            temp.next = heroNode;
        }
    }

    /**
     * 修改节点的信息，根据no遍历来修改，即no编号不能改
     * @param newHeroNode 修改后的节点对象
     */
    public void update(HeroNode2 newHeroNode) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        // 找到需要修改的节点，根据no编号
        // 定义一个辅助变量
        HeroNode2 temp = head.next;
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
        HeroNode2 temp = head;
        // 判断当前链表是否为空
        if (head == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
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
            if (temp.next.pre.no == 0 && temp.next.next == null) {
                temp.next = null;
            } else if (temp.next.pre.no == 0 && temp.next.next != null) {
                temp.next = temp.next.next;
            } else if (temp.next.pre.no != 0 && temp.next.next == null) {
                temp.next.pre.next = null;
            } else {
                temp.next.pre.next = temp.next.next;
                if (temp.next.next != null) {
                    temp.next.next.pre = temp.next.pre;
                }
            }
            System.out.println("删除成功!");
        } else {
            System.out.println("没有找到元素！");
        }
    }
}

class HeroNode2{

    // 编号
    public int no;
    // 名称
    public String name;
    // 昵称
    public String nickName;
    // 指向下一个节点
    public HeroNode2 next;
    // 指向前一个节点
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

