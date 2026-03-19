package com.leetcode.substring;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <pre>{@code
 * 这里用到的一个思路就是：
 * 当前的滑动窗口中i,j都为数组的下标，若满足i < j且nums[i] <= nums[j]，那么
 * 可以直接将i从队列中移除了
 * 因为nums[j]>=nums[i]，且j始终和i一起出现在一个窗口或者j单独出现在一个窗口
 * }</pre>
 */
public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //使用双向队列来维护窗口的最大值
        Deque<Integer> dp = new ArrayDeque<>();
        //先处理第一个窗口里的最大值
        for (int i = 0; i < k; i++) {
            while (!dp.isEmpty() && nums[i] >= nums[dp.peekLast()]) {
                dp.pollLast();
            }
            dp.offerLast(i);
        }

        int n = nums.length;
        int[] res = new int[n - k + 1];
        res[0] = nums[dp.peekFirst()];
        for (int i = k; i < n; ++i) {
            // 步骤1：维护递减性质
            while (!dp.isEmpty() && nums[i] >= nums[dp.peekLast()]) {
                dp.pollLast();
            }
            dp.offerLast(i);
            // 步骤2：移除不在窗口内的元素
            while (dp.peekFirst() <= i - k) {
                dp.pollFirst();
            }
            // 步骤3：记录当前窗口最大值
            res[i - k + 1] = nums[dp.peekFirst()];
        }
        return res;
    }
}
