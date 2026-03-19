package com.leetcode.binarytree;

/// [力扣题解](https://leetcode.cn/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode124 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    /**
     * 表示以root 节点为起点的最大路径贡献：也就是以root 节点为起点的最大路径和
     */
    private int maxGain(TreeNode root) {
        if(root ==null) return 0;

        // 左子树的最大贡献
        int leftGain = Math.max(maxGain(root.left), 0);
        // 右子树最大贡献
        int rightGain = Math.max(maxGain(root.right), 0);

        // 即经过root 节点的最大路径
        int priceNewPath = root.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, priceNewPath);

        // 返回以root 节点为起点的最大贡献，不能分叉，所以只能选一条路径
        return root.val + Math.max(leftGain, rightGain);
    }
}
