package com.leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

/// [力扣题解](https://leetcode.cn/problems/partition-labels/solutions/455703/hua-fen-zi-mu-qu-jian-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode763 {
    public List<Integer> partitionLabels(String s) {
        // 记录每个字母最后出现的位置
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); ++i) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}
