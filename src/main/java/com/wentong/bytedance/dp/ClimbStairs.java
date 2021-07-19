package com.wentong.bytedance.dp;

// https://leetcode-cn.com/problems/climbing-stairs/
// 爬楼梯。
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 3;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n-1];
    }
}
