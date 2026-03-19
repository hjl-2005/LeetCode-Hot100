package com.leetcode.substring;

/**
 * <pre>{@code
 * cnt:表示t中每个字符出现的次数 - s中对应字符的出现次数，当等于0时代表，当前窗口的某个字符已经满足了t的要求
 * less:记录当前窗口中，有多少种字符的出现次数 < t中对应字符的出现次数
 * }</pre>
 */
public class LeetCode76 {
    public String minWindow(String S, String t) {
        // 记录 t中每个字符出现的次数
        int[] cnt = new int[128];  // ASCII 字符集大小
        int less = 0;  // 记录当前窗口中，有多少种字符的出现次数 < t中对应字符的出现次数

        // 初始化 cnt数组
        for (char c : t.toCharArray()) {
            if (cnt[c] == 0) {
                less++; // 有 less 种字母的出现次数 < t 中的字母出现次数
            }
            cnt[c]++;  // 记录 t中每个字符需要出现的次数
        }

        char[] s = S.toCharArray();  // 转为字符数组便于访问
        int m = s.length;  // 主串 S的长度
        int ansLeft = -1;  // 记录最小窗口的左边界
        int ansRight = m;  // 记录最小窗口的右边界，初始化为最大可能值

        int left = 0;  // 滑动窗口左指针

        // 遍历主串S，移动窗口右边界
        for (int right = 0; right < m; right++) {
            char c = s[right]; // 当前右边界字符
            cnt[c]--; // 右边界字符进入窗口，对应需要次数减1

            // 如果cnt[c] == 0，说明这个字符在窗口中的出现次数
            // 刚好达到t中要求的最小次数
            if (cnt[c] == 0) {
                less--;  // 满足条件的字符种类数减少
            }

            // 当less == 0时，表示当前窗口包含了t的所有字符
            while (less == 0) {
                // 如果找到更短的窗口
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left; // 记录此时的左右端点
                    ansRight = right;
                }

                char x = s[left]; // 左边界字符
                if (cnt[x] == 0) {
                    // 在移出x之前，如果窗口内x的出现次数正好满足t的要求
                    // 那么移出x后，x就不够次数了
                    less++;  // 不满足条件的字符种类数增加
                }
                cnt[x]++; // 左边界字符移出窗口，对应需要次数加1
                left++;  // 左指针右移
            }
        }
        // 如果找到了有效窗口，返回子串；否则返回空字符串
        return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
    }
}
