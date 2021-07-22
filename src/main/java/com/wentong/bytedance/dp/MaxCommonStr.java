package com.wentong.bytedance.dp;

public class MaxCommonStr {

    // 最大公共子串。
    private static String maxCommonStr(String str1, String str2) {
        int max = 0;
        int end = 0;
        int[][] dp = getDp(str1, str2);
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    end = i;
                }
            }
        }
        if (end != 0) {
            return str1.substring(end - max + 1, end + 1);
        } else {
            return "-1";
        }

    }

    private static int[][] getDp(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];
        char c1 = str1.charAt(0);
        char c2 = str2.charAt(0);
        for (int i = 0; i < str1.length(); i++) {
            char s1 = str1.charAt(i);
            if (s1 == c2) {
                dp[i][0] = 1;
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            char s2 = str2.charAt(i);
            if (c1 == s2) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < str1.length(); i++) {
            char s1 = str1.charAt(i);
            for (int j = 1; j < str2.length(); j++) {
                char s2 = str2.charAt(j);
                if (s1 == s2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp;
    }
}
