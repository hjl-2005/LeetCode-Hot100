package com.leetcode.matrix;

/**
 * 为了实现原地算法：空间复杂度为O(1)，使用第0行和第0列来存储每行、列是否包含0。额外使用两个变量来记录
 * 第0行、列原本是否包含0
 */
public class LeetCode73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //"row" 通常指的是行，而"column" 则指的是列
        boolean rowZero = false;
        boolean colZero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colZero = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                rowZero = true;
                break;
            }
        }
        //记录0出现的行、列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        //根据第0行、列更新矩阵
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (colZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (rowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
