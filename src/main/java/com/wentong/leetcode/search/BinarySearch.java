package com.wentong.leetcode.search;

public class BinarySearch {

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int num = nums[mid];
            if (num > target) {
                right = mid - 1;
            } else if (num < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
