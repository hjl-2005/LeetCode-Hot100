package com.leetcode.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/// [力扣题解](https://leetcode.cn/problems/binary-tree-inorder-traversal/solutions/412886/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode94 {

    /**
     * 迭代实现
     */
    public List<Integer> inorderTraversalWithLiteration(TreeNode root) {
        // 维护一个结果集合和一个栈
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            // 从栈中取出节点
            TreeNode node = stk.pop();
            res.add(node.val);
            root = node.right; // 按照：左->中->右
        }
        return res;
    }

    /**
     * 递归实现
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /**
     * Morris 算法：节省空间的关键在于用predecessor的右节点记录了下一个节点的去向（在遍历完左子树后
     */
    public List<Integer> inorderTraversalWithMorris(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode predecessor = null;
        while (root != null) {
            // 1. 无左节点，将当前节点加入结果集合，并 root = root.right
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            } else {
                // 2. 有左节点，寻找左子树的最右节点：predecessor
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                // 3. predecessor 没有右节点（即第一次到达这个点），建立好与root的连接，root = root.left（进入左子树，因为已经铺垫好了回头路
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    // 4. predecessor 有右节点（代表才从前继节点回来），添加当前节点进入结果列表并断开predecessor连接，root = root.right
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }

            }
        }
        return res;
    }

}
