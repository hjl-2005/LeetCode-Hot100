package com.leetcode.binarytree;

/// [力扣题解](https://leetcode.cn/problems/diameter-of-binary-tree/solutions/139683/er-cha-shu-de-zhi-jing-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode543 {
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    private int depth(TreeNode node) {
        // 递归出口
        if (node == null) return 0;
        int l = depth(node.left);
        int r = depth(node.right);
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1;
    }

}
