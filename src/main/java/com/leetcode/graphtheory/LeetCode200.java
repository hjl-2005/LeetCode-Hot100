package com.leetcode.graphtheory;

import java.util.LinkedList;
import java.util.Queue;

/// [力扣题解](https://leetcode.cn/problems/number-of-islands/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode200 {
    public int numIslands(char[][] grid) {
        // 获取网格的横，纵长度
        int row = grid.length;
        int col = grid[0].length;

        int res = 0;
        int[] dx = new int[]{0, 1, 0, -1}; // 右、下、左、上
        int[] dy = new int[]{1, 0, -1, 0};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0'; // 变为水，替代标记数组的作用
                    res++;
                    // 创建队列，实现BFS 遍历
                    Queue<int[]> neighbors = new LinkedList<>(); // 使用int[] 存储坐标
                    neighbors.add(new int[]{i, j});
                    while (!neighbors.isEmpty()) {
                        int[] coordinate = neighbors.remove();
                        for (int n = 0; n < 4; n++) {
                            int x = coordinate[0] + dx[n];
                            int y = coordinate[1] + dy[n];
                            if (x < 0 || x >= row || y < 0 || y >= col) {
                                continue;
                            } else if (grid[x][y] == '0') {
                                continue;
                            }
                            neighbors.add(new int[]{x, y});
                            grid[x][y] = '0';
                        }
                    }
                }
            }
        }
        return res;
    }
}
