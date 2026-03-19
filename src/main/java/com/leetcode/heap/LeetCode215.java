package com.leetcode.heap;

/// [力扣题解](https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/307351/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcod-2/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode215 {
    /**
     * 时间复杂度为：O(n*log k)，当 k 为常数时为 O(n)。
     */
    public int findKthLargest(int[] nums, int k) {
        // 用前 k 个元素构建最小堆
        // heapSize / 2 - 1 ：表示最后一个非叶子节点的索引
        for (int i = k / 2 - 1; i >= 0; --i) {
            // 特地查了一下：“ify”在“Max-Heapify”中不是缩写，而是英语中的一个后缀，表示“使…化”或“变成…”
            minHeapify(nums, i, k);
        }
        // 遍历剩余元素
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                swap(nums, 0, i);
                // 一直维持堆的大小为k
                minHeapify(nums, 0, k);
            }
        }
        return nums[0];
    }

    private void minHeapify(int[] nums, int i, int heapSize) {
        int left = i * 2 + 1, right = i * 2 + 2;
        int smallest = i;
        if (left < heapSize && nums[left] < nums[smallest]) {
            smallest = left;
        }
        if (right < heapSize && nums[right] < nums[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(nums, smallest, i);
            // 递归地完善子树的最小堆
            minHeapify(nums, smallest, heapSize);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
