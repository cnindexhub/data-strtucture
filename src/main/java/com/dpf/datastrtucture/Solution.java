package com.dpf.datastrtucture;

import java.util.Arrays;

/**
 * leetcode 题目
 */
public class Solution {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        listNode5.next = listNode6;
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        int a = 3;
        int b = 4;
        ListNode listNode7 = new ListNode(1000000);
        ListNode listNode8 = new ListNode(1000001);
        ListNode listNode9 = new ListNode(1000002);
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        mergeInBetween(listNode1, a, b, listNode7);
    }

    /**
     * 给定一个字符串 s 和一个整数 k。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
     *
     * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串。
     * 1 <= k <= S.length <= 1000
     * s 只由小写字母组成。
     * @param s
     * @param k
     * @return
     */
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                sb.deleteCharAt(0);
                sb.append(c);
                String cur = sb.toString();
                if (cur.compareTo(ans) < 0) {
                    ans = cur;
                }
            }
            return ans;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }


    /**
      Definition for singly-linked list.
     */
    static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tempList1 = list1;
        ListNode removeAfterrightListNode = new ListNode();
        int i = 0;
        while (tempList1 != null) {
            if (tempList1.next == null) {
                break;
            }
            i++;
            if (i == a) {
                removeAfterrightListNode = tempList1.next;
                tempList1.next = list2;
            }
            tempList1 = tempList1.next;
        }
        b = b - a + 1;
        while (b != 0) {
            b --;
            if (removeAfterrightListNode == null) {
                break;
            }
            removeAfterrightListNode = removeAfterrightListNode.next;
        }
        tempList1.next = removeAfterrightListNode;
        return list1;
    }


}
