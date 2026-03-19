package com.leetcode.array;

/**
 * <pre>{@code
 * 动态规划：
 * 假设f(i) 代表以第 i 个数结尾的「连续子数组的最大和」，其中f(i):
 * f(i)=max{f(i−1)+nums[i],nums[i]}
 * 最后获取f(i)中的最大值即可
 * }</pre>
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int preF = 0, maxF = nums[0];
        for (int i : nums) {
            preF = Math.max(preF + i, i);
            maxF = Math.max(maxF, preF);
        }
        return maxF;
    }
}
