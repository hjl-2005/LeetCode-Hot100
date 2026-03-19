package com.leetcode.binarytree;

import java.util.HashMap;
import java.util.Map;

/// [力扣题解](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/255811/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/?envType=study-plan-v2&envId=top-100-liked)
/// #### 解题思路：
/// 1. 首先通过前序遍历的数组来确认根节点
/// 2. 利用hashMap 快速定位其在中序遍历数组里的位置，即可确认左子树和右子树的范围了
/// 3. 递归地恢复二叉树
public class LeetCode105 {
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildBinaryTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    /**
     * @param preorder_left  当前子树在前序数组中的起始索引
     * @param preorder_right 当前子树在前序数组中的结束索引
     * @param inorder_left   当前子树在中序数组中的起始索引
     * @param inorder_right  当前子树在中序数组中的结束索引
     */
    public TreeNode buildBinaryTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder[preorder_left];
        // 在中序遍历中定位根节点位置
        int inorder_root_index = indexMap.get(preorder_root);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder_root);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root_index - inorder_left;
        // 递归地构造左子树，并连接到根节点
        root.left = buildBinaryTree(preorder, inorder,
                preorder_left + 1, preorder_left + size_left_subtree,
                inorder_left, inorder_root_index - 1);
        // 递归地构造右子树，并连接到根节点
        root.right = buildBinaryTree(preorder, inorder,
                preorder_left + size_left_subtree + 1, preorder_right,
                inorder_root_index + 1, inorder_right);
        return root;
    }
}
