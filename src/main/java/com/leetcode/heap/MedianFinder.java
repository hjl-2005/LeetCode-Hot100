package com.leetcode.heap;

import java.util.PriorityQueue;

/// [力扣题解](https://leetcode.cn/problems/find-median-from-data-stream/?envType=study-plan-v2&envId=top-100-liked)
class MedianFinder {
    // 用来存储小于等于中位数的数
    private PriorityQueue<Integer> maxHeap;
    // 用来存储大于中位数的数
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    /**
     * 小于等于中位数的“最大堆”的size 始终跟大于中位数的“最小堆”的size 相等或者大 1；
     * 所以当这个关系不满足的时候要平衡一下
     */
    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
            if (minHeap.size() + 1 < maxHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
        } else {
            minHeap.offer(num);
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek() * 1.0;
        }
    }
}
