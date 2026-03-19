package com.leetcode.linkedlist;

/// [力扣题解](https://leetcode.cn/problems/add-two-numbers/solutions/7348/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 检验参数
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        // 设置求和链表起点
        ListNode sumP = new ListNode(-1);
        ListNode cur = sumP;
        // 执行求和逻辑
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            // 计算进位值和要添加进链表的数值
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            // 移动原生链表
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return sumP.next;
    }
}
