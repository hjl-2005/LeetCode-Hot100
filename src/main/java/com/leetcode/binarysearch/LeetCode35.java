package com.leetcode.binarysearch;

/// [力扣题解](https://leetcode.cn/problems/search-insert-position/solution/er-fen-cha-zhao-suan-fa-xi-jie-yun-yin-by-labula/)
public class LeetCode35 {
    /**
     * 关于为什么直接返回left:
     * 1. 根据if的判断条件，left左边的值一直保持小于target，right右边的值一直保持大于等于target
     * 2. left最终一定等于right+1
     * 3. 循环结束后，在left和right之间画一条竖线，恰好可以把数组分为两部分：left左边的部分和right右边的部分
     * 4. 而且left左边的部分全部小于target，并以right结尾；right右边的部分全部大于等于target，并以left为首。所以最终答案一定在left的位置
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
