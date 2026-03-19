package com.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用层级的概念来代替 visited数组
 */
public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // 初始化上下左右四个方向的边界
        int leftLimt = 0;
        int downLimit = row - 1;
        int rightLimit = col - 1;
        int upLimit = 0;
        List<Integer> res = new ArrayList<>();

        while (true) {
            // 依次按照right -> down -> left -> up的顺序， 每个方向移动后边界值会变化
            // 终止条件为res中装了row * col个元素
            // 向右
            for (int j = leftLimt; j <= rightLimit; j++) {
                res.add(matrix[upLimit][j]);
            }
            upLimit++;
            if (res.size() == row * col) return res;
            // 向下
            for (int i = upLimit; i <= downLimit; i++) {
                res.add(matrix[i][rightLimit]);
            }
            rightLimit--;
            if (res.size() == row * col) return res;
            // 向左
            for (int j = rightLimit; j >= leftLimt; j--) {
                res.add(matrix[downLimit][j]);
            }
            downLimit--;
            if (res.size() == row * col) return res;
            // 向上
            for (int i = downLimit; i >= upLimit; i--) {
                res.add(matrix[i][leftLimt]);
            }
            leftLimt++;
            if (res.size() == row * col) return res;
        }
    }
}
