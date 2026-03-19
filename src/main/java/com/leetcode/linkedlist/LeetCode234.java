package com.leetcode.linkedlist;

/// [力扣题解](https://leetcode.cn/problems/palindrome-linked-list/solutions/457059/hui-wen-lian-biao-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode234 {
    /**
     * 采用快慢指针一次遍历找到中心点
     */
    public boolean isPalindrome(ListNode head) {
        // 检查链表是否为空或只包含头节点
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        // 寻找中心点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转后半段链表
        ListNode pre = null;
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // 判断是否是回文链表
        ListNode front = head;
        ListNode back = pre;
        while (back != null) {
            if (front.val != back.val) {
                return false;
            }
            front = front.next;
            back = back.next;
        }
        return true;
    }
}
