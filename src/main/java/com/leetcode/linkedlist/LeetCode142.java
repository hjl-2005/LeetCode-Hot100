package com.leetcode.linkedlist;

/// 还是使用快慢指针，因为空间复杂度为O(1)。（哈希表实现将会非常简单
/// [力扣题解](https://leetcode.cn/problems/linked-list-cycle-ii/solutions/441131/huan-xing-lian-biao-ii-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        // 检验链表是否为空
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 通过数学推断，得出：相遇后，安排一个从头节点开始移动的节点和慢指针一起移动，他们相遇的点就是环的入口
            if (slow == fast) {
                ListNode pre = head;
                while (pre != slow) {
                    pre = pre.next;
                    slow = slow.next;
                }
                return pre;
            }
        }
        return null;
    }
}
