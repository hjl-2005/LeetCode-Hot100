package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode78 {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0,new LinkedList<>());
        return res;
    }

    /**
     * 递归回溯的另一种写法：
     *<pre>{@code
     *void backtrack(int[] nums, int start, LinkedList<Integer> path) {
     *         res.add(new ArrayList<>(path)); // 这一步是先提交不包含当前元素的子集
     *         for (int i = start; i < nums.length; i++) {
     *             path.add(nums[i]);           // 做出选择
     *             backtrack(nums, i + 1, path); // 进入下一层
     *             path.removeLast();          // 撤销选择
     *         }
     *     }
     * }</pre>
     */
    void backtrack(int[] nums, int index, LinkedList<Integer> path) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 分支一：不选当前元素
        backtrack(nums, index + 1, path);
        // 分支二：选当前元素
        path.add(nums[index]);
        backtrack(nums, index + 1, path);
        path.removeLast(); // 回溯
    }
}
