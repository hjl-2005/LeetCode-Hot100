package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LeetCode146 {
    class LRUCache {

        class LinkedNode {
            int key;
            int value;
            LinkedNode prev;
            LinkedNode next;

            public LinkedNode() {
            }

            public LinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final int capacity; // 最大容量
        private int size; // 当前大小
        private final LinkedNode head;
        private final LinkedNode tail;
        private final Map<Integer, LinkedNode> cache = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            // 使用伪头部和伪尾部节点（在添加节点和删除节点的时候就不需要检查相邻的节点是否存在
            this.head = new LinkedNode();
            this.tail = new LinkedNode();
            this.head.next = tail;
            this.tail.prev = head;
        }

        public int get(int key) {
            LinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 移动当前节点到链表首部
            removeNode(node);
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            LinkedNode node = cache.get(key);
            if (node == null) {
                // 创建新节点
                LinkedNode newNode = new LinkedNode(key, value);
                cache.put(key, newNode);
                moveToHead(newNode); // 添加到头节点
                size++;
                // 是否超过容量
                if (size > capacity) {
                    // 如果超出容量，删除双向链表的尾部节点
                    LinkedNode tail = removeTail();
                    // 删除哈希表中对应的项
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                node.value = value;
                removeNode(node);
                moveToHead(node);
            }
        }

        private void moveToHead(LinkedNode node) {
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;
        }

        private void removeNode(LinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private LinkedNode removeTail() {
            LinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }
    }
}
