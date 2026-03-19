package com.leetcode.binarytree;

/// [力扣题解](https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/solutions/312607/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-33/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        // 递归出口
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
