package com.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet=new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest=0;
        //这里直接遍历Set，起到一个去重的作用
        for (int num : numSet) {
           if(!numSet.contains(num-1)){
               int currentLongest=1;
               int currentNum=num;
               while(numSet.contains(currentNum+1)){
                   currentLongest++;
                   currentNum++;
               }
               longest=Math.max(currentLongest,longest);
           }
        }
        return longest;
    }
}
