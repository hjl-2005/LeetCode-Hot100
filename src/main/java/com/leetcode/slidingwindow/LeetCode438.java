package com.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] count = new int[26];
        int sLen = s.length(), pLen = p.length();

        // 初始化窗口
        for (int i = 0; i < pLen; i++) {
            count[p.charAt(i) - 'a']--;
            count[s.charAt(i) - 'a']++;
        }

        int diff = 0;
        for (int c : count) {
            if (c != 0) diff++;
        }

        if (diff == 0) result.add(0);

        // 滑动窗口
        for (int i = 0; i < sLen - pLen; i++) {
            int left = s.charAt(i) - 'a';
            int right = s.charAt(i + pLen) - 'a';

            // 移除左侧字符
            if (count[left] == 1) diff--;
            else if (count[left] == 0) diff++;
            count[left]--;

            // 添加右侧字符
            if (count[right] == -1) diff--;
            else if (count[right] == 0) diff++;
            count[right]++;

            if (diff == 0) result.add(i + 1);
        }

        return result;
    }
}
