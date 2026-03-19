package com.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/// [力扣题解](https://leetcode.cn/problems/maximum-depth-of-binary-tree/solutions/349250/er-cha-shu-de-zui-da-shen-du-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode104 {
    public int maxDepthWithDFS(TreeNode root) {
        // 递归出口
        if (root == null) return 0;
        else {
            int leftHeight = maxDepthWithDFS(root.left);
            int rightHeight = maxDepthWithDFS(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public int maxDepthWithBFS(TreeNode root) {
        // 边界值判断
        if (root == null) return 0;
        // 维护一个队列来进行广度优先搜索
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            ans++;
        }
        return ans;
    }
}
