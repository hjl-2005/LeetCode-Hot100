package com.leetcode.linkedlist;

/// [环形链表](https://leetcode.cn/problems/linked-list-cycle/solutions/440042/huan-xing-lian-biao-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode141 {
    /**
     * 快慢指针，秒了
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
