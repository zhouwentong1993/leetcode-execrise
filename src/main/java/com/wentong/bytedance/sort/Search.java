package com.wentong.bytedance.sort;

public class Search {

    public static void main(String[] args) {
        System.out.println(new Search().search(new int[]{1}, 1));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 1 : 0;
        }
        int index = binarySearch(nums, target, 0, nums.length);
        if (index == -1) {
            return 0;
        }
        int r = index;
        index--;
        r++;
        int count = 1;
        while (index >= 0 && nums[index] == target) {
            count++;
            index--;
        }
        while (r < nums.length && nums[r] == target) {
            count++;
            r++;
        }
        return count;
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if (left >= right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = nums[mid];
        if (target > midValue) {
            return binarySearch(nums, target, mid + 1, right);
        } else if (target < midValue) {
            return binarySearch(nums, target, left, mid - 1);
        } else {
            return mid;
        }
    }
}
