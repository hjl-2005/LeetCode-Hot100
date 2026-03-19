package com.leetcode.array;

/**
 * 这里直接采用数位数组翻转的方法
 */
public class LeetCode189 {
    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
}
