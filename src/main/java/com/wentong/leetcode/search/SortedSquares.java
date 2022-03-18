package com.wentong.leetcode.search;

public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = right;
        while (left <= right) {
            if (nums[left] * nums[left] >= nums[right] * nums[right]) {
                result[index] = nums[left] * nums[left];
                index--;
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                index--;
                right--;
            }
        }

        return result;
    }

}
