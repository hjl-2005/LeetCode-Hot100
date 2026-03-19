package com.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/// [力扣题解](https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solutions/356853/er-cha-shu-zhan-kai-wei-lian-biao-by-leetcode-solu/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode114 {
    /**
     * 先前序遍历到链表里，再将其展开
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            TreeNode node = list.get(i);
            node.right = list.get(i + 1);
            node.left = null;
        }
    }

    private void preOrder(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }
}
