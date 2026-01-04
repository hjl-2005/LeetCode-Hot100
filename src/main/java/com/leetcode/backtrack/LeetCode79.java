package com.leetcode.backtrack;

public class LeetCode79 {
    //上、右、下、左
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] visited;
    int X;
    int Y;
    int LengthW;

    public boolean exist(char[][] board, String word) {
        X = board.length;
        Y = board[0].length;
        LengthW = word.length();
        visited = new boolean[X][Y];
        if(LengthW>X*Y){
            return false;
        }

        int[] cnt = new int[128];
        for (char[] row : board) {
            for (char c : row) {
                cnt[c]++;
            }
        }

        //优化一：网格某字符元素数量<字符串对应元素数量，直接false
        char[] w = word.toCharArray();
        int[] wordCnt = new int[128];
        for (char c : w) {
            if (++wordCnt[c] > cnt[c]) {
                return false;
            }
        }

        //优化二：字符串末尾元素的若比开头元素在网格的数量多，直接反转字符串来匹配
        if (cnt[w[LengthW - 1]] < cnt[w[0]]) {
            word = new StringBuilder(word).reverse().toString();
        }

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (dfs(board, word, 1, i, j))
                        return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int pos, int x, int y) {
        if (pos == LengthW) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny > Y - 1 || nx > X - 1 || ny < 0)
                continue;
            if (!visited[nx][ny] && board[nx][ny] == word.charAt(pos)) {
                visited[nx][ny] = true;
                if (dfs(board, word, pos + 1, nx, ny))
                    return true;
                visited[nx][ny] = false;
            }
        }
        return false;
    }
}
