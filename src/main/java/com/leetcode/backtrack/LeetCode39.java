package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode39 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //剪枝的前提条件，有序
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new LinkedList<>());
        return res;
    }

    void backtrack(int[] candidates, int target, int index, LinkedList<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        /*剪枝后不需要
        if (target < 0) {
            return;
        }*/

        for (int i = index; i < candidates.length; i++) {
            //剪枝
            if(target < candidates[i]){
                break;
            }
            path.addLast(candidates[i]);
            backtrack(candidates, target - candidates[i], i, path);
            path.removeLast();
        }

    }
}
