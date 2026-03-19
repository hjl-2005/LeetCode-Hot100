package com.leetcode.binarysearch;

/// [力扣题解](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solutions/504484/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-3-4/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = findIndex(nums, target, true);
        int rightIndex = findIndex(nums, target, false);
        // 边界值处理，当leftIndex 索引处的元素不等于target时，rightIndex 索引处的元素肯定也不等于target
        if (leftIndex < 0 || leftIndex >= nums.length || nums[leftIndex] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{leftIndex, rightIndex};
    }

    /**
     * 关键就在于条件是：nums[mid] < target OR nums[mid] <= target
     * - 无论是那个条件最后都一定停留的位置一定是left = right + 1
     * - nums[mid] < target 时，left 左边的元素一定小于target，right 右边的元素一定大于等于target，所以left 一定是第一个 target（如果存在的话）
     * - nums[mid] <= target 时，left 左边的元素一定小于等于target，right 右边的元素一定大于target，所以 right 一定是最后一个 target（如果存在的话）
     */
    private int findIndex(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isFirst) {
                // 查找左边界：当 nums[mid] < target 时向右移动
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 查找右边界：当 nums[mid] <= target 时向右移动
                if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return isFirst ? left : right;
    }
}
