package com.leetcode.array;

/**
 * 解题思路：实现一个类似哈希表的功能，将在范围 1-n 的数放在数组中 n-1 的位置
 * 最后在遍历数组得到不等于当前位置+1的数即为缺失的数（缺失的数一定是在 1-n+1 范围里）
 */
public class LeetCode41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }
}
