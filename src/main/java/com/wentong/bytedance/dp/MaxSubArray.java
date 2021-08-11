package com.wentong.bytedance.dp;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int pre = nums[0];
        int cur = pre;
        int max = cur;
        for (int i = 1; i < nums.length; i++) {
            cur = pre < 0 ? nums[i] : pre + nums[i];
            max = Math.max(max, cur);
            pre = cur;
        }
        return max;

    }
}
