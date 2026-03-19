package com.leetcode.binarysearch;

/// [力扣题解](https://leetcode.cn/problems/search-a-2d-matrix/solutions/688117/sou-suo-er-wei-ju-zhen-by-leetcode-solut-vxui/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2; // 若left + right > 2^31 - 1，会溢出，要使用int mid = (high - low) / 2 + low;
            if (matrix[mid / n][mid % n] < target) {
                left = mid + 1;
            } else if (matrix[mid / n][mid % n] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
