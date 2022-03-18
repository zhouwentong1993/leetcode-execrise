package com.wentong.leetcode.search;

public class MinSubArrayLen {


    /**
     * 滑动窗口实现
     */
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int right = 0;
        int left = 0;
        int sum = 0;
        for (right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
