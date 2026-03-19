package com.leetcode.binarytree;

/// [力扣题解](https://leetcode.cn/problems/invert-binary-tree/solutions/73159/dong-hua-yan-shi-liang-chong-shi-xian-226-fan-zhua/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        // 递归出口
        if(root==null){
            return null;
        }
        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
}
