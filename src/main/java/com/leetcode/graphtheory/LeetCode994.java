package com.leetcode.graphtheory;

import java.util.LinkedList;
import java.util.Queue;

/// [力扣题解](https://leetcode.cn/problems/rotting-oranges/solutions/129831/li-qing-si-lu-wei-shi-yao-yong-bfsyi-ji-ru-he-xie-/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode994 {
    public int orangesRotting(int[][] grid) {
        // 统计好橘子的数量，并将坏橘子放入队列
        int row = grid.length, col = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) fresh++;
                else if (grid[i][j] == 2) queue.add(new int[]{i, j});
            }
        }
        if (fresh == 0) return 0;

        int time = 0;
        // 右、下、左、上
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                for (int j = 0; j < 4; j++) {
                    int x = cur[0] + dx[j];
                    int y = cur[1] + dy[j];
                    if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] != 1) {
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.add(new int[]{x, y});
                    fresh--;
                }
            }
            time++;
        }
        if (fresh > 0) {
            return -1;
        }
        return time - 1;
    }
}
