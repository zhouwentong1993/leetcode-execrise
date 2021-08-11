package com.wentong.bytedance.dp;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        String s1 = text1.substring(0, 1);
        String s2 = text2.substring(0, 1);
        for (int i = 0; i < text1.length(); i++) {
            dp[i][0] = text1.substring(0, i + 1).contains(s2) ? 1 : 0;
        }
        for (int i = 0; i < text2.length(); i++) {
            dp[0][i] = text2.substring(0, i + 1).contains(s1) ? 1 : 0;
        }
        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }
}
