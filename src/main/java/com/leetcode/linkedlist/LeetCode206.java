package com.leetcode.linkedlist;

/// [力扣题解](https://leetcode.cn/problems/reverse-linked-list/solutions/99711/fan-zhuan-lian-biao-shuang-zhi-zhen-di-gui-yao-mo-/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode206 {

    public ListNode reverseListWithRecursion(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
    // 迭代版本
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }
}
