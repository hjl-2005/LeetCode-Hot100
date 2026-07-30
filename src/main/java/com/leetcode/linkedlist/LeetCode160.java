package com.leetcode.linkedlist;

/// [相交链表](https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/811625/xiang-jiao-lian-biao-by-leetcode-solutio-a8jn/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode160 {
    /**
     * 可以哈希，但空间复杂度为O(m)
     * <p>
     * 空间复杂度为常数的方法为使用双指针去同步遍历，到达自己链路尽头就到对方链路的起点继续遍历。推理思路如下；
     * - 链路A、B的长度分别为m、n
     * - 如果相交：相交部分的长度为c，不相交的部分分别为a、b。
     *  - a == b：双方在第一次到达相交节点的时候就可以相遇了
     *  - a != b：双方都在第二次经过相交节点时相遇，因为：a + c + b == b + c + a
     * - 如果A、B本来都不相交，会在都走过 m + n个节点后同时指向 null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA != null ? pA.next : headB;
            pB = pB != null ? pB.next : headA;
        }
        return pA;
    }
}
