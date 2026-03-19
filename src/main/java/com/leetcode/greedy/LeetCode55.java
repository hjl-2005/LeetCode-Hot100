package com.leetcode.greedy;

/// [力扣题解](https://leetcode.cn/problems/jump-game/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode55 {
    /**
     * 大体思路：遍历数组，实时更新每次可以到达的最大位置下标，如果某个位置x + nums[x] >= nums.length 那么返回true，
     * 反之如果遍历到了一个位置以及超过了可到达最大位置下标，那么返回false。
     */
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxIndex) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
                if (maxIndex >= nums.length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
