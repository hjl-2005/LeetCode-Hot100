package com.leetcode.linkedlist;

/// [环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii/solutions/441131/huan-xing-lian-biao-ii-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode142 {
    /**
     * 快慢指针求环入口。
     * 设 a = 起点到环入口距离，b = 环长。慢指针每次1步，快指针每次2步。
     * 1. 首次相遇时，慢指针在环内走 x 步，快指针比慢指针多走 nb 步（n 为正整数）。
     * 2. 由路程关系：2(a + x) = a + nb + x，化简得 a + x = nb。
     * 3. 该等式表明：从相遇点继续前进 a 步，恰好到达环入口。
     * 4. 据此，取一新指针置于起点，与相遇点的慢指针同速移动，二者再次相遇的位置即为环入口。
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }
}
