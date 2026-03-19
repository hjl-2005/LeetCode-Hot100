package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3 {
    /**
     * 优化思路：因为只包含英文字母、数字、符号和空格组成，可以直接用数组来替代Map
     * <pre>{@code
     *public int lengthOfLongestSubstring(String s) {
     *         //ASCII表一共128个字符
     *         Integer[] charIndex = new Integer[129];
     *         int left = 0, maxLen = 0;
     *         int length = s.length();
     *
     *         for (int right = 0; right < length; right++) {
     *             char currentChar = s.charAt(right);
     *             //charIndex[currentChar] >= left：忽略在left后面的字符（因为直接跳转所以数组内一些数据没更新）
     *             if (charIndex[currentChar] != null && charIndex[currentChar] >= left) {
     *                 // 直接跳转左指针至重复字符的下一个位置
     *                 left = charIndex[currentChar] + 1;
     *             }
     *             charIndex[currentChar] = right; // 更新字符位置
     *             maxLen = Math.max(maxLen, right - left + 1);
     *         }
     *         return maxLen;
     *     }
     * }</pre>
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int left = 0, maxLen = 0;
        int length = s.length();

        for (int right = 0; right < length; right++) {
            char currentChar = s.charAt(right);
            //charIndexMap.get(currentChar) >= left：为了确保left不被之前的数据影响
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                left = charIndexMap.get(currentChar) + 1;
            }
            charIndexMap.put(currentChar, right); // 更新字符位置
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
