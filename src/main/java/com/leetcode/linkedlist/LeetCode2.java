package com.leetcode.linkedlist;

/// [两数相加](https://leetcode.cn/problems/add-two-numbers/solutions/7348/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0; // 进位标志
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
