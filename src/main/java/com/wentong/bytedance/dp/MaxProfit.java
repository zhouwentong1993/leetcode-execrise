package com.wentong.bytedance.dp;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int pre = prices[1] > prices[0] ? prices[1] - prices[0] : 0;
        int min = Math.min(prices[0], prices[1]);
        int maxProfit = pre;
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit = Math.max(pre, prices[i] - min);
                pre = maxProfit;
            } else {
                min = Math.min(min, prices[i]);
            }
        }
        return maxProfit;
    }
}
