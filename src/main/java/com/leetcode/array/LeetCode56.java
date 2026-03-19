package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //以每个区间的左端点进行排序
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            //判断准备加入集合的数组左端点和集合中最后一个数组的右端点的大小
            if (merged.size() == 0 || merged.getLast()[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                //将集合中最后一个数组的右端点改为较大值
                merged.getLast()[1] = Math.max(merged.getLast()[1], R);
            }
        }
        return  merged.toArray(new int[merged.size()][]);
    }
}
