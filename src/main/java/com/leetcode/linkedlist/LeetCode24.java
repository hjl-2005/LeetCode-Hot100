package com.leetcode.linkedlist;

/// [两两交换链表中的节点](https://leetcode.cn/problems/swap-nodes-in-pairs/solutions/444474/liang-liang-jiao-huan-lian-biao-zhong-de-jie-di-91/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            // 两两交换结点
            node1.next = node2.next;
            node2.next = node1;
            cur.next = node2;
            cur = node1;
        }
        return dummy.next;
    }

    /**
     * 递归两两交换链表节点。
     * 1. 边界条件：head 为空或只剩一个节点，无法交换，直接返回 head。
     * 2. 当前层决策：记录 newHead = head.next，先递归处理 newHead.next 之后的子链表，将结果赋给 head.next，再将 newHead.next 指向 head，完成当前两个节点的交换。
     * 3. 返回值：返回 newHead 作为交换后的新链表头（供上层递归挂载）。
     */
    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairsRecursive(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
