package com.dpf.datastrtucture;

import java.util.Arrays;

/**
 * leetcode 题目
 */
public class Solution {

    public static void main(String[] args) {

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


}
