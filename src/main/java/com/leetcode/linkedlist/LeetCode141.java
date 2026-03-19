package com.leetcode.linkedlist;

/**
 * 直接使用快慢指针来实现（当然，使用哈希表就非常简单了
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        // 判断链表是否为空
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
