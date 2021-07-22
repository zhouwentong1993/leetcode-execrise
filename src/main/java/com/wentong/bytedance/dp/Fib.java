package com.wentong.bytedance.dp;

public class Fib {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int pre2 = 0;
        int pre1 = 1;
        int res = pre1;
        for (int i = 2; i < n + 1; i++) {
            res = pre1 + pre2;
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }
}
