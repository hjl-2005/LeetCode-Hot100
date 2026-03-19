package com.leetcode.linkedlist;

/// [力扣题解](https://leetcode.cn/problems/sort-list/solutions/13728/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode148 {
    public ListNode sortListWithRecursion(ListNode head) {
        // 递归出口
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针找中点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        } // slow：奇数指向中点；偶数指向中点左侧
        // 平分后的链表分别递归
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortListWithRecursion(head);
        ListNode right = sortListWithRecursion(mid);
        // 合并两个有序列表
        ListNode cur = new ListNode(0);
        ListNode res = cur;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return res.next;
    }

    public ListNode sortList(ListNode head) {
        // 检验参数
        if (head == null || head.next == null) {
            return head;
        }
        // 获取链表长度
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        // 每一次拆分比上一次长度翻一倍
        ListNode dummyHead = new ListNode(0, head);
        for (int subLen = 1; subLen < len; subLen <<= 1) {
            ListNode prev = dummyHead; // 用于连接已排序的子链表和未排序的子链表
            cur = dummyHead.next;
            while (cur != null) {
                // 准备排序的第一个链表
                ListNode head1 = cur;
                for (int i = 1; i < subLen && cur.next != null; i++) {
                    cur = cur.next;
                }
                // 准备排序的第二个链表（有可能为null
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLen && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                // 未排序子链表头部
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                // 合并两个有序列表
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                } // 指向已排序子链表尾部
                cur = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
