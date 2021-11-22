package com.wentong.bytedance.string;

public class CountSubstrings {

    public static void main(String[] args) {
        System.out.println(new CountSubstrings().countSubstrings("abc"));
    }

    public int countSubstrings(String s) {
        int counter = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String substring = s.substring(i, j);
                System.out.println(substring);
                if (isSubstring(substring)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private boolean isSubstring(String s) {
        if (s.length() == 1) {
            return true;
        }
        int length = s.length();
        int mid = length / 2;
        for (int i = 0; i < mid; i++) {
            char cs = s.charAt(i);
            char ce = s.charAt(length - i - 1);
            if (cs != ce) {
                return false;
            }
        }
        return true;
    }

}
