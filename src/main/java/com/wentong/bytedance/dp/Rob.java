package com.wentong.bytedance.dp;

//https://leetcode-cn.com/problems/house-robber/
public class Rob {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int pre1 = nums[0];
        int pre2 = Math.max(pre1, nums[1]);
        int res = pre2;
        for (int i = 2; i < nums.length; i++) {
            res = Math.max(pre2, pre1 + nums[i]);
            pre1 = pre2;
            pre2 = res;
        }
        return res;
    }
}
