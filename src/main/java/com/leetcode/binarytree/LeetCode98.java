package com.leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/// [力扣题解](https://leetcode.cn/problems/validate-binary-search-tree/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long lower, long upper) {
        // 递归出口
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    /**
     * BST的中序遍历是升序的，所以中序遍历BT，如果一直是升序，代表是BST
     */
    public boolean isValidBSTWithInorder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        long inorder = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
