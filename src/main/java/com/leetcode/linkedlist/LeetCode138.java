package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/// [复制带随机指针的链表](https://leetcode.cn/problems/copy-list-with-random-pointer/solutions/2361362/138-fu-zhi-dai-sui-ji-zhi-zhen-de-lian-b-6jeo/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode138 {
    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomListRecursive(Node head) {
        if (head == null) return null;
        if (!map.containsKey(head)) {
            Node copyNode = new Node(head.val);
            map.put(head, copyNode);
            copyNode.next = copyRandomListRecursive(head.next);
            copyNode.random = copyRandomListRecursive(head.random);
        }
        return map.get(head);
    }

    /**
     * 在原节点后插入复制节点，利用原节点.random.next 定位复制节点的 random，最后拆分。
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // 在每个原节点后插入复制节点，便于通过原节点的 random 找到复制节点的 random
        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }
        // 设置复制节点的 random（注意判空）
        for (Node node = head; node != null; node = node.next.next) {
            Node randomNode = node.random;
            node.next.random = randomNode != null ? randomNode.next : null;
        }
        // 拆分链表
        Node newHead = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node temp = node.next;
            node.next = node.next.next;
            temp.next = temp.next != null ? temp.next.next : null;
        }
        return newHead;
    }
}
