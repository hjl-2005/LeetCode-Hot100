package com.leetcode.linkedlist;

/// [删除链表的倒数第 N 个结点](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/solutions/450350/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode19 {
    /**
     * 双指针法：定义两个指针，先将前面的指针向前移动 n 个结点，然后两个指针同时向后移动；当前面的指针指向 null 时，后面的指针正好指向倒数第 n 个结点的前驱结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode back = dummy;
        ListNode front = head;
        for (int i = 0; i < n; ++i) {
            front = front.next;
        }

        while (front != null) {
            back = back.next;
            front = front.next;
        }
        back.next = back.next.next;
        return dummy.next;
    }
}
