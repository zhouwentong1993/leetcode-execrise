package com.wentong.bytedance;


// https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1014/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String s = "bab";
        System.out.println(s.startsWith(""));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String sentinel = strs[0];
        for (String str : strs) {
            while (!str.startsWith(sentinel)) {
                sentinel = sentinel.substring(0, sentinel.length() - 1);
            }
        }
        return sentinel;
    }
}
