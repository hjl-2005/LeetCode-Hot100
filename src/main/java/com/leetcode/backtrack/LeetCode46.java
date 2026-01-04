package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode46 {
    List<List<Integer>> res =new ArrayList<>();

    void backtrack(int[] nums, LinkedList<Integer> path, boolean[] s){
        if(path.size()==nums.length){
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(s[i])
                continue;
            path.addLast(nums[i]);
            s[i]=true;
            backtrack(nums,path,s);
            s[i]=false;
            path.removeLast();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] status =new boolean[nums.length];
        backtrack(nums,new LinkedList<Integer>(),status);
        return res;
    }
}
