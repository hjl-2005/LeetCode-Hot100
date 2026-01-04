package com.leetcode.backtrack;

import java.util.*;

public class LeetCode131 {
    List<List<String>> res = new ArrayList<>();
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        int length = s.length();
        dp = new boolean[length][length];
        if (length == 0) {
            return res;
        }
        backtrack(s.toCharArray(), 0, new ArrayList<>());
        return res;
    }

    void backtrack(char[] s, int index, ArrayList<String> path) {
        if (index == s.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length; i++) {
            if (isPalindrome(s, index, i)) {
                path.addLast(new String(s, index, i + 1 - index));
                backtrack(s, i + 1, path);
                path.removeLast();
            }
        }

    }

    //palindromic number:回文数
    boolean isPalindrome(char[] s, int start, int end) {
        if (dp[start][end]) {
            return true;
        }
        while (start < end) {
            if (s[start] != s[end]) {
                return false;
            }
            start++;
            end--;
        }
        dp[start][end] = true;
        return true;
    }
}
