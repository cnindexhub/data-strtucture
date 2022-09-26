package com.dpf.datastrtucture.stack;

/**
 * 利用栈来实现解析一个字符串数学表达式并且计算出最终结果
 */
public class Cakculator {

    public static void main(String[] args) {
        // 根据前面老师的思路，完成表达式的运算
        String expression = "30+2*6-2";
        // 创建一个栈，一个数栈，符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        // 定义扫描的索引
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; // 将每次扫描得到的char保持到ch
        String keepNum = ""; // 用于拼接多位数
        // 开始while循环的扫描expression
        while(true) {
            if (expression.length() == index) {
                break;
            }
            // 依次得到expression 的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            // 判断ch是什么，然后做相应的处理
            // 符号栈为空直接入栈
            if (operStack.isOper(ch) && operStack.isEmpty()) {
                operStack.push(ch);
            // 符号栈不为空需要进行比较
            } else if (operStack.isOper(ch)
                    && !operStack.isEmpty()
                    && operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                num1 = numStack.pop();
                num2 = numStack.pop();
                oper = operStack.pop();
                res = numStack.cal(num1, num2, (char) oper);
                numStack.push(res);
                operStack.push(ch);
            // 符号栈不为空需要进行比较
            } else if (operStack.isOper(ch) && !operStack.isEmpty() && operStack.priority(ch) > operStack.priority(operStack.peek())) {
                operStack.push(ch);
            // 如果是数字入栈
            } else if (!operStack.isOper(ch)) {
                keepNum += ch;
                if ((index+1) == expression.length()) {
                    numStack.push(Integer.parseInt(keepNum));
                    index++;
                    continue;
                }
                if (operStack.isOper(expression.substring(index+1, index + 2).charAt(0))) {
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum = "";
                }
            }
            index++;
        }
        System.out.println();
        // 由于在此前循环已经将该表达式运算符调整为同一优先级则可以直接运算
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, (char) oper);
            numStack.push(res);
        }
        System.out.printf(expression+"=%d", numStack.pop());
    }
}

class ArrayStack2 {

    private int maxSize; // 栈的大小

    private int[] stack; // 数组模拟栈, 数据存储

    private int top = -1; // 栈顶索引，初始化-1

    public ArrayStack2 (int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top + 1 == maxSize;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈
    public void push (int value) {
        if (isFull()) {
            System.out.println("栈满！");
            return;
        }
        top++;
        this.stack[top] = value;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空！没有数据~");
        }
        int value = this.stack[top];
        top--;
        return value;
    }

    // 查看栈顶
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空！没有数据~");
        }
        return this.stack[top];
    }

    // 显示栈的清况，遍历栈, 需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i, stack[i]);
        }
    }

    // 返回运算符的优先级，优先级是程序员来确定，优先级使用数字表示
    // 数字越大，则优先级就越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    // 判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法
    public int cal(int num1, int num2, char oper) {
        int res = 0; // res 用于存放计算后的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }

}
