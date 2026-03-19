package com.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/// [力扣题解](https://leetcode.cn/problems/top-k-frequent-elements/solutions/402568/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 用hashMap记录每个元素出现的次数
        HashMap<Integer, Integer> recordCount = new HashMap<>();
        for (int num : nums) {
            recordCount.put(num, recordCount.getOrDefault(num, 0) + 1);
        }

        // 用最小堆来实现前k个高频元素的筛选
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> entry : recordCount.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            // 维持最小堆的大小一直为k ，最后剩下的就是前k 个高频元素
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
}
