package com.wentong.bytedance.string;

public class NumSum {

    public static void main(String[] args) {
        int res = new NumSum().numSum("A-1BC-12");
        int res1 = new NumSum().numSum("A1CD2E33");
        int res2 = new NumSum().numSum("A-1B--2C--D6E");
        int res3 = new NumSum().numSum("A-1B-2C--D6E12");
        System.out.println(res3);
    }

    public int numSum(String str) {
        if (str == null) {
            return 0;
        }
        boolean positive = true;
        int result = 0;
        int cur = 0;
        for (int i = 0; i < str.length(); i++) {
            char c1 = str.charAt(i);
            int c = c1 - '0';
            if (c1 == '-') {
                positive = !positive;
            } else if (c > 0 && c < 9) {
                cur = cur * 10 + c;
            } else {
                if (cur != 0) {
                    cur = positive ? cur : -cur;
                    result = result + cur;
                    cur = 0;
                    positive = true;
                }
            }
        }
        return result + (positive ? cur : -cur);
    }
}
