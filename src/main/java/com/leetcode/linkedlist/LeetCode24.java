package com.leetcode.linkedlist;

/// [力扣题解](https://leetcode.cn/problems/swap-nodes-in-pairs/solutions/444474/liang-liang-jiao-huan-lian-biao-zhong-de-jie-di-91/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        // 创建dummy 头节点
        ListNode dummyHead = new ListNode(-1, head);
        ListNode cur = dummyHead;
        // 两两交换节点
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            // 当前节点先指向第二个节点（即交换后在当前节点下一个的节点
            cur.next = second;
            // 第一个节点交换后应该指向第二个节点的next
            first.next = second.next;
            // 第二个节点指向第一个节点
            second.next = first;
            // 改变当前节点为第一个节点（即交换后的第二个节点
            cur = first;
        }
        return dummyHead.next;
    }
}
