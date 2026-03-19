package com.leetcode.substring;

import java.util.HashMap;
import java.util.Map;

public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        int count=0,prefixSum=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for (int num : nums) {
            prefixSum += num;
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}
