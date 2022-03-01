package com.wentong.leetcode.heap;

import java.util.PriorityQueue;

public class KthLargest {

    private PriorityQueue<Integer> queue;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }

    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.add(val);
        } else {
            if (queue.peek() < val) {
                queue.poll();
                queue.add(val);
            }
        }
        return queue.peek();
    }

}
