package com.wentong.bytedance.string;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    public static void main(String[] args) {
        boolean anagram = new IsAnagram().isAnagram("aacc", "ccca");
        System.out.println(anagram);
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCounter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer counter = charCounter.get(c);
            if (counter != null) {
                charCounter.put(c, ++counter);
            } else {
                charCounter.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer counter = charCounter.get(c);
            if (counter == null || counter == 0) {
                return false;
            } else {
                charCounter.put(c, --counter);
            }
        }

        return true;
    }

}
