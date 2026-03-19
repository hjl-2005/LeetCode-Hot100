package com.leetcode.linkedlist;

import java.util.HashMap;

/// [力扣题解](https://leetcode.cn/problems/copy-list-with-random-pointer/solutions/2361362/138-fu-zhi-dai-sui-ji-zhi-zhen-de-lian-b-6jeo/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode138 {
    public Node copyRandomListWithHash(Node head) {
        // 检验参数
        if (head == null) {
            return null;
        }
        // 构建原节点和对应新节点的Map
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        // 对照原链表来建立新链表的关系
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 空间复杂度O(1)
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // 复制原链表的每一个节点并加在其后面
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        // 完成各个新节点的 random 指向
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 分离原列表和新列表
        Node res = head.next;
        Node pre = head;
        cur = head.next;
        while (pre.next.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;// 单独处理原链表尾节点
        return res;
    }
}
