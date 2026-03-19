package com.leetcode.matrix;

/**
 * 将矩阵逆时针旋转45度，会发现从顶点向下看可以看作一颗二叉搜索树，后面问题就迎刃而解了
 */
public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //从左下角开始
        int row = matrix.length, col = matrix[0].length;
        int i = row - 1, j = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            }
        }
        return false;
    }
}
