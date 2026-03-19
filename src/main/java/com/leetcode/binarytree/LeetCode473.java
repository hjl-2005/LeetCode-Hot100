package com.leetcode.binarytree;

/// [力扣题解](https://leetcode.cn/problems/path-sum-iii/solutions/1021296/lu-jing-zong-he-iii-by-leetcode-solution-z9td/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode473 {

    /**
     * 递归解法
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int res = rootSum(root, targetSum);
        // 遍历左子树
        res += pathSum(root.left, targetSum);
        // 遍历右子树
        res += pathSum(root.right, targetSum);
        return res;
    }

    /**
     * 表示以root 节点为起点的路径上，和为 targetSum 的路径的数目
     */
    private int rootSum(TreeNode root, int targetSum) {
        int sum = 0;
        if (root == null) return 0;
        if (root.val == targetSum) sum++;
        sum += rootSum(root.left, targetSum - root.val);
        sum += rootSum(root.right, targetSum - root.val);
        return sum;
    }
}
