package com.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/// [力扣题解](https://leetcode.cn/problems/valid-parentheses/solutions/373578/you-xiao-de-gua-hao-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode20 {
    /**
     * 使用栈的后进先出原则来匹配右括号和左括号
     */
    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1) return false;
        Map<Character, Character> pairs = Map.of(')', '(', ']', '[', '}', '{');

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            // 遇到右括号，查找栈顶第一个元素是否是与其匹配的左括号
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                // 左括号，直接入栈
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
