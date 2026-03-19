package com.leetcode.binarytree;

import java.util.*;

/// [力扣题解](https://leetcode.cn/problems/binary-tree-right-side-view/solutions/213494/er-cha-shu-de-you-shi-tu-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode199 {
    /**
     * 这里使用 BFS
     */
    public List<Integer> rightSideView(TreeNode root) {
        // 准备好需要的Map和Queue，并记录最大深度
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        int maxDepth = 0;

        nodeQueue.offer(root);
        depthQueue.offer(1);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int depth = depthQueue.poll();
            if (node != null) {
                // 更新最大深度
                maxDepth = Math.max(maxDepth, depth);
                // 由于每一层最后一个访问到的节点才是我们要的答案，因此不断更新对应深度的信息即可
                rightmostValueAtDepth.put(depth, node.val);

                nodeQueue.offer(node.left);
                nodeQueue.offer(node.right);
                depthQueue.offer(depth + 1);
                depthQueue.offer(depth + 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= maxDepth; i++) {
            ans.add(rightmostValueAtDepth.get(i));
        }
        return ans;
    }
}
