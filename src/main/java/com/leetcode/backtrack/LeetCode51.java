package com.leetcode.backtrack;

import java.util.*;

public class LeetCode51 {
    List<List<String>> res = new ArrayList<>();
    //表示每个皇后在每行的第几列
    int[] queens;
    boolean[] columns;
    boolean[] diagonals1;
    boolean[] diagonals2 ;


    public List<List<String>> solveNQueens(int n) {
        columns = new boolean[n];
        diagonals1 = new boolean[2*n];
        diagonals2 = new boolean[2*n];
        queens = new int[n];
        backtrack(n,0);
        return res;
    }

    void backtrack(int n,int row) {
        if(row==n){
            res.add(generateList(queens));
            return;
        }
        for(int i=0;i<n;i++){
            int d1 = row - i + n - 1; // 计算主对角线索引，避免负数
            int d2 = row + i;
            if(columns[i]||diagonals1[d1]||diagonals2[d2]){
                continue;
            }
            queens[row] = i;
            columns[i]=true;
            diagonals1[d1]=true;
            diagonals2[d2]=true;
            backtrack(n,row+1);
            columns[i]=false;
            diagonals1[d1]=false;
            diagonals2[d2]=false;
        }

    }
    List<String> generateList(int[] queens) {
        List<String> list = new ArrayList<>();
        int n = queens.length;
        for (int queen : queens) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queen] = 'Q';
            list.add(new String(row));
        }
        return list;
    }
}
