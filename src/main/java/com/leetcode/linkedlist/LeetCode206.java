package com.leetcode.linkedlist;

/// [反转链表](https://leetcode.cn/problems/reverse-linked-list/solutions/99711/fan-zhuan-lian-biao-shuang-zhi-zhen-di-gui-yao-mo-/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode206 {

    /**
     * 递归：递归返回后，head.next 已经变成反转后子链表的尾节点，我们只需让它（head.next）的 next 指向 head，就把当前节点接到末尾了
     * 递归出口：当前节点的next节点为null
     */
    public ListNode reverseList(ListNode head) {
        // head == null 是处理边界条件
        if (head == null || head.next == null) {
            return head;
        }
        // 返回值就是原来链表的尾节点，一路向上传递就行
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // 迭代版本
    public ListNode reverseListIterative(ListNode head) {
        ListNode current = head;
        ListNode next = null;
        ListNode pre = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
