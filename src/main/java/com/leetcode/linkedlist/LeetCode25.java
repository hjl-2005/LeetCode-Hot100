package com.leetcode.linkedlist;

public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 创建dummy 头节点
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
