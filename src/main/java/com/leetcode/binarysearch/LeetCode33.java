package com.leetcode.binarysearch;

/// [力扣题解](https://leetcode.cn/problems/search-in-rotated-sorted-array/solutions/220083/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode33 {
    /**
     * 将数组一份为二的话，一定有一组是有序的，可以根据有序的那一组来判断target是否在其中
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            // true: 代表左边部分的数组有序
            if (nums[0] <= nums[mid]) {
                // target在左边有序范围内
                // 这里有个细节：判断条件没有设置为：nums[left] <= target && nums[mid - 1] >= target
                // 是因为 left 和 mid - 1 是有可能越界的，而我们的判断又可以不那么精确，用更大范围也无妨，还避免了越界的问题
                if (nums[0] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // target在右边有序范围内
                if (nums[mid] < target && nums[nums.length - 1] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
