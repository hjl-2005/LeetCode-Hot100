package com.leetcode.linkedlist;

import static com.leetcode.linkedlist.LeetCode148.merged;

/// [合并 K 个升序链表](https://leetcode.cn/problems/merge-k-sorted-lists/solutions/219756/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode23 {
    /**
     * 采用迭代分治的方法去合并，减少比较次数
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int count = lists.length;
        if (count == 0) return null;
        // step 表示每个待合并子链表包含的原始链表个数
        for (int step = 1; step < count; step <<= 1) {
            // i 的步长 2*step 就是要跳过的配对数（因为每次合并一对，占两个 step 大小的子链表）
            for (int i = 0; i + step < count; i += (step << 1)) {
                lists[i] = merged(lists[i], lists[i + step]);
            }
        }
        return lists[0];
    }
}
