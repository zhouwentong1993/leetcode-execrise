package com.wentong.bytedance;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1012/
public class LongestSubString {
    public static void main(String[] args) {
        int count = lengthOfLongestSubstring("uqinntq");
        System.out.println(count);
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        int length = s.length();
        Map<Character,Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                left = Math.max(left, map.get(key) + 1);
            }
            map.put(key, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
