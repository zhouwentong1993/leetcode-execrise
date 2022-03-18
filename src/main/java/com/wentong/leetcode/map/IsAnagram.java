package com.wentong.leetcode.map;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.merge(c, 1, Integer::sum);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = s.charAt(i);
            Integer times = map.get(c);
            if (times == null) {
                return false;
            } else if (times == 1){
                map.remove(c);
            } else {
                map.put(c, times - 1);
            }
        }
        if (map.size() != 0) {
            return false;
        }
        return true;
    }
}
