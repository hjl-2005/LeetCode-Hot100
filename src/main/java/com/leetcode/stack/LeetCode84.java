package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/// [力扣题解](https://leetcode.cn/problems/largest-rectangle-in-histogram/solutions/266844/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode-/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode84 {
    /// #### 联系 木桶短板效应 理解
    /// 要理解的有两点：
    /// #### 如何确认某条柱子的左边界？
    /// 即就是向左找**第一个小于**当前柱子高度的柱子，所以只关心出现的第一个目标柱子。
    /// 1. 使用单调栈（单增），来记录可能为边界的柱子
    /// 2. 若当前柱子（高度）小于栈顶柱子，则将栈顶柱子出栈（顺便确认其右边界），直到找到第一个小于当前柱子高度的柱子
    /// 3. 将当前柱子入栈，并记录其左边界，没有边界柱子默认为 -1
    /// ---
    /// #### 如何确认某条柱子的右边界？
    /// 1. 首先设置所以柱子的默认右边界为数组长度，需要修改再覆盖
    /// 2. 单调栈的栈顶元素出栈时，可以得知一个信息：当前柱子高度 < 栈顶柱子高度，所以以出栈元素的视角来看，右边第一个小于其高度的柱子不就是当前柱子吗
    public int largestRectangleArea(int[] heights) {
        // 左边界和右边界
        int length = heights.length;
        int[] leftBound = new int[length];
        int[] rightBound = new int[length];
        Arrays.fill(rightBound, length); // 初始化右边界为数组长度

        Deque<Integer> monoStk = new ArrayDeque<>();
        for (int i = 0; i < length; ++i) {
            while (!monoStk.isEmpty() && heights[i] < heights[monoStk.peek()]) {
                // 可以确认弹栈元素的右边界
                rightBound[monoStk.peek()] = i;
                monoStk.pop();
            }
            leftBound[i] = monoStk.isEmpty() ? -1 : monoStk.peek();
            monoStk.push(i);
        }
        int ans = -1;
        for (int i = 0; i < length; ++i) {
            ans = Math.max(ans, (rightBound[i] - leftBound[i] - 1) * heights[i]);
        }
        return ans;
    }
}
