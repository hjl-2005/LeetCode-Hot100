package com.leetcode.linkedlist;

/// [力扣递归详解](https://leetcode.cn/problems/merge-two-sorted-lists/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 递归结束条件
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
