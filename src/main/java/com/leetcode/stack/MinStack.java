package com.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/// [力扣题解](https://leetcode.cn/problems/min-stack/solutions/242190/zui-xiao-zhan-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    /**
     * 一定要保证：当栈顶元素为xStack.peek() 时，minStack.peek() 一定是xStack 中的最小值
     */
    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    /**
     * 同时删除xStack 和minStack 的栈顶元素 ，保证两个栈的元素数量相同
     */
    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
