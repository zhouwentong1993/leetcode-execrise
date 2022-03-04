package com.wentong.leetcode.heap;

import java.util.LinkedList;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        LinkedList<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.poll();
        System.out.println(deque.peek());
        System.out.println(deque.peekLast());
        System.out.println(deque);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);

            if (queue.peek() <= i - k) {
                queue.poll();
            }
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }

}
