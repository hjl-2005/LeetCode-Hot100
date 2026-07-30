package com.leetcode.linkedlist;

/// [回文链表](https://leetcode.cn/problems/palindrome-linked-list/solutions/457059/hui-wen-lian-biao-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode234 {
    /**
     * 先利用快慢指针，找到中点
     * 反转后半段链表后就可以同时移动两个指针判断是否是回文链表了
     */
    public boolean isPalindrome(ListNode head) {
        // 找链表的中点：slow
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转后半段链表，最终 pre 指向尾节点
        ListNode pre = slow;
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // 判断是不是回文链表
        ListNode left = head;
        ListNode right = pre;
        while (right != slow) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
