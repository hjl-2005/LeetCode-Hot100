package com.leetcode.linkedlist;

/// [合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/solutions/226408/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode21 {
    /**
     * 1. 终止条件：若 l1 或 l2 为空，返回另一个。
     * 2. 当前层决策：比较头节点值，选较小者作为当前头。
     * 3. 递归挂载：将选中节点的 next 指向递归（本节点下一节点与另一链表）的返回值，返回当前节点。
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

    /**
     * 定义节点preHead 和 next ，每次比较list1 和 list2 节点，哪个小next就指向谁，然后移动next和刚刚被指向的指针
     * 最后在next再指向剩余的那个节点
     */
    public ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(0);
        ListNode pNext = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pNext.next = list1;
                list1 = list1.next;
            } else {
                pNext.next = list2;
                list2 = list2.next;
            }
            pNext = pNext.next;
        }
        pNext.next = list1 != null ? list1 : list2;
        return preHead.next;
    }
}
