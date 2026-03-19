package com.leetcode.linkedlist;

import java.util.PriorityQueue;

/// [力扣题解](https://leetcode.cn/problems/merge-k-sorted-lists/solutions/219756/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode23 {
    /**
     * 这里使用优先队列
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 边界值处理
        if (lists == null || lists.length == 0) return null;
        // 降序排序
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        // 将每个链表的头节点加入优先队列
        for (ListNode list : lists) {
            if (list != null) pq.offer(list);
        }
        // 维护一个结果链表
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if(node.next != null){
                pq.offer(node.next);
            }
        }
        return res.next;
    }
}
