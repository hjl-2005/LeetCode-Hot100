package com.leetcode.linkedlist;

/// [排序链表](https://leetcode.cn/problems/sort-list/solutions/13728/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode148 {
    /**
     * 采用归并的算法，时间复杂度为O(nlogn)
     * 自顶向下地去归并
     */
    public ListNode sortListRecursive(ListNode head) {
        // 递归出口
        if (head == null || head.next == null) {
            return head;
        }
        // 找中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 每层递归的决策：从中点切分成左右两部分，分别递归排序后合并，返回排序后的头节点。
        ListNode head2 = slow.next;
        slow.next = null;
        return merged(sortListRecursive(head), sortListRecursive(head2));
    }

    /**
     * 采用归并的算法，时间复杂度为O(nlogn)
     * 自底向上地去归并，相较于自顶向下空间复杂度可以从O(logn)降到O(1)
     * 统计链表的总长度。每轮相较于上轮，合并的有序数组的长度 <<2，如果长度大于等于总长度，总体就有序了
     */
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        // 获取链表总长度
        int length = 0;
        ListNode count = head;
        while (count != null) {
            length++;
            count = count.next;
        }

        ListNode dummy = new ListNode(-1, head);
        for (int curLength = 1; curLength < length; curLength <<= 1) {
            ListNode cur = dummy.next;
            ListNode pre = dummy; // 两合并链表的前继节点
            while (cur != null) {
                // 确认两两合并的头节点，并断开其链尾
                ListNode head1 = cur;
                for (int i = 1; i < curLength && cur.next != null; ++i) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null; // 断开head1链表的末尾
                cur = head2;
                for (int i = 1; i < curLength && cur != null && cur.next != null; ++i) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null; // 断开head2链表的末尾
                }
                // 合并两条链表
                pre.next = merged(head1, head2);
                // 设置pre、cur，准备下一次合并
                cur = next;
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }
        return dummy.next;
    }

    public static ListNode merged(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode node1 = head1;
        ListNode node2 = head2;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        cur.next = node1 != null ? node1 : node2;
        return dummy.next;
    }
}
