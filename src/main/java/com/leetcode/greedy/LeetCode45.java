package com.leetcode.greedy;

/// [力扣题解](https://leetcode.cn/problems/jump-game-ii/solutions/230241/tiao-yue-you-xi-ii-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode45 {
    public int jump(int[] nums) {
        int end = 0; // 每次跳跃能到达的最远位置
        int maxPosition = 0; // 记录下一次可到达的最远的位置
        int steps = 0;

        // 这里的一个细节就是：循环条件是：i < nums.length - 1
        // 这么设计的原因是：当到达终点的最后一跳的边界恰好是最后一个元素时，会格外增加一次跳跃，所以直接不访问最后一个元素，因为肯定是可以到达的
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);

            // end 就是你在上一次更新end的时候那个点能跳到的最远距离，要想走更远，得在跳一次了（step ++）
            if (i == end) {
                steps++;
                end = maxPosition;
            }
        }
        return steps;
    }
}
