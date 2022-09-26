package com.dpf.datastrtucture.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {
        // 先定义一个逆波兰表达式
        // (3+4)x5-6 => 3 4 + 5 x 6 -
        // 说明：为了方便，逆波兰表达式的数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 * 6 -";
        // 思路
        // 1. 先将 "3 4 + 5 x 6 -"=> 放到ArrayList中
        // 2. 将ArrayList 传递给一个方法， 配合栈完成计算
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList=" + rpnList);
        System.out.println("计算的结果是：" + calculate(rpnList));
    }

    public static List<String> getListString(String suffixExpression) {
        // suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    // 计算逆波兰表达式
    public static int calculate(List<String> ls) {
        // 创建给栈，只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        // 遍历,ls
        for (String item : ls) {
            // 这里使用正则表达式来取出数
            if (item.matches("\\d+")) { // 匹配多位数
                // 入栈
                stack.push(item);
            } else {
                // pop 出两个数进行计算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误！");
                }
                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
