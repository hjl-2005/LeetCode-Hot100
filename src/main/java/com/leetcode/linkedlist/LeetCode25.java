package com.leetcode.linkedlist;

/// [K 个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group/solutions/248591/k-ge-yi-zu-fan-zhuan-lian-biao-by-leetcode-solutio/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode25 {
    public ListNode reverseKGroupRecursive(ListNode head, int k) {
        // 边界条件，链表长度小于k直接返回head
        ListNode pNext = head;
        for (int i = 0; i < k; ++i) {
            if (pNext == null) {
                return head;
            }
            pNext = pNext.next;
        }
        // 反转 k 个链表。递归返回反转后的newHead，并连接上一层递归返回的头结点
        int time = k;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null && time-- > 0) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = reverseKGroupRecursive(cur, k);
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy; // pre：代表当前翻转链表的前继节点
        ListNode end = dummy; // end：代表当前翻转链表的尾节点
        while (end.next != null) {
            // 确认当前未翻转链表的长度是否有k
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            // 获取当前翻转链表的头节点并将end.next保存起来置于空，以便执行翻转链表逻辑
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverseList(start);
            // 恢复已翻转链表和未翻转链表的链接
            start.next = next;
            // 设置下一次的pre和end节点
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
