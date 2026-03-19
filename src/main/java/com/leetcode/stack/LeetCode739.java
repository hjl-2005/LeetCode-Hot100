package com.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/// [力扣题解](https://leetcode.cn/problems/daily-temperatures/solutions/71433/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        // 入栈的是下标
        Deque<Integer> stk = new LinkedList<>();
        int length = temperatures.length;
        int[] ans = new int[length];

        for (int i = 0; i < length; ++i) {
            while (!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
                int index = stk.pop();
                ans[index] = i - index;
            }
            stk.push(i);
        }
        return ans;
    }
}
