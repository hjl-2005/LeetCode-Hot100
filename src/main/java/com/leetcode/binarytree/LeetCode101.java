package com.leetcode.binarytree;

/// [力扣题解](https://leetcode.cn/problems/symmetric-tree/solutions/268109/dui-cheng-er-cha-shu-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
}
