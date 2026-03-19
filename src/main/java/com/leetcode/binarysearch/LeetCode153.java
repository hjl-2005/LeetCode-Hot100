package com.leetcode.binarysearch;

/// [力扣题解](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/solutions/698479/xun-zhao-xuan-zhuan-pai-xu-shu-zu-zhong-5irwp/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode153 {
    /**
     * 大概思路就是：以数组最后一个节点为准，记为x
     * 最小值的右侧元素都满足小于x（除了x本身），最小值的左侧元素都满足大于x ，所以可以根据这个条件来进行二分快速查找
     */
    public int findMin(int[] nums) {
        int length = nums.length - 1;
        int left = 0, right = length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= nums[length]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
