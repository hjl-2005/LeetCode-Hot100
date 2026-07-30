package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/// [LRU (最近最少使用) 缓存 ](https://leetcode.cn/problems/lru-cache/solutions/259678/lruhuan-cun-ji-zhi-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
/// 使用哈希表 + 双向链表实现
public class LRUCache {
    private static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private final int capacity;
    private final Map<Integer, DLinkedNode> map;
    private final DLinkedNode dummyHead;
    private final DLinkedNode dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        dummyHead = new DLinkedNode();
        dummyTail = new DLinkedNode();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) return -1;
        // node 本身就是头节点直接返回
        if (dummyHead.next == node) return node.value;

        // 摘除 node
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // node 移动到 dummyHead 后
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node != null) {
            node.value = value;
            if (dummyHead.next == node) return;
            // 更新值，并从原位置摘除
            node.prev.next = node.next;
            node.next.prev = node.prev;
        } else {
            node = new DLinkedNode(key, value);
            map.put(key, node);
        }
        // 将 node 插入到头部
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;

        // 容量超出，移除dummyTail前的结点
        if (map.size() > capacity) {
            map.remove(dummyTail.prev.key);
            dummyTail.prev = dummyTail.prev.prev;
            dummyTail.prev.next = dummyTail;
        }
    }
}