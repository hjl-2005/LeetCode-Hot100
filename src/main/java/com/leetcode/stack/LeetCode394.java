package com.leetcode.stack;

import java.util.*;

/// [力扣题解](https://leetcode.cn/problems/decode-string/solutions/264391/zi-fu-chuan-jie-ma-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode394 {
    public String decodeString(String s) {
        // 使用LinkedList 来做为队列，可以人为控制以链表尾部为栈口，这样顺序遍历就跟本来字符串的顺序一致
        // 若使用Deque 的push(),pop()方法，默认是以链表头为栈口
        LinkedList<String> stk = new LinkedList<>();
        int length = s.length();
        int ptr = 0;

        while (ptr < length) {
            char ch = s.charAt(ptr);
            // 若为数字（范围是1-300），入栈
            if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (Character.isDigit(s.charAt(ptr))) {
                    sb.append(s.charAt(ptr++));
                }
                stk.addLast(sb.toString());
            } else if (Character.isLetter(ch) || ch == '[') {
                // 若为字母和 "[" ,入栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ptr++; // 跳过"]"
                // 为"]" ,出栈到遇见的第一个"[",并将解码的字符串重新入栈
                // 这里使用LinkedList 来拼接字符串，不使用StringBuilder（因为不适配嵌套的情况，自己细品
                List<String> sub = new LinkedList<>();
                while (!"[".equals(stk.peekLast())) {
                    sub.add(stk.removeLast());
                }
                stk.removeLast(); // 弹出"["
                Collections.reverse(sub);
                String subString = getString(sub);

                int time = Integer.parseInt(stk.removeLast());
                StringBuilder sb = new StringBuilder();
                while (time-- > 0) {
                    sb.append(subString);
                }
                stk.addLast(sb.toString());
            }
        }
        return getString(stk);
    }

    private String getString(List<String> c) {
        StringBuilder sb = new StringBuilder();
        for (String str : c) {
            sb.append(str);
        }
        return sb.toString();
    }
}
