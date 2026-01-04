package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 要满足两个条件：<br>
 * 1.左括号要等与右括号<br>
 * 2.任一字符串前缀：左括号>=右括号
 */
public class LeetCode22 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(),0,0,n);
        return res;
    }
    void backtrack(StringBuilder sb,int left,int right,int n){
        if(left==n&&right==n){
            res.add(sb.toString());
            return;
        }
        if(left<n){
            sb.append('(');
            backtrack(sb,left+1,right,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left){
            sb.append(')');
            backtrack(sb,left,right+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
