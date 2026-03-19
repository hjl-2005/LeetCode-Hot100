package com.leetcode.linkedlist;

/// [力扣题解](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/solutions/450350/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode19 {
    /**
     * 使用快慢指针一次遍历定位倒数第N个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 根据n 设置快慢指针的出发时间
        ListNode front = head;
        // 为了back停留在第N-1个节点上（方便删除第N个节点
        // 也巧妙地处理了清理节点为倒数第一个节点时，back.next节点会越界的情况
        ListNode layBack = new ListNode(0, head);
        ListNode back = layBack;
        for (int i = 0; i < n; i++) {
            front = front.next;
        }
        // 找到倒数第n 个节点
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        // 删除第n 个节点
        back.next = back.next.next;
        return layBack.next;
    }
}
