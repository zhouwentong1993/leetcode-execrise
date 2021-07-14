package com.wentong.bytedance.string;

public class Convert {

    public static void main(String[] args) {
        boolean ab = isValidStr("-0");
        System.out.println(ab);
    }

    public static int convert(String str) {
        if (!isValidStr(str)) {
            return 0;
        }
        char[] arr = str.toCharArray();
        boolean positive = arr[0] != '-';
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int result = 0;
        int cur = 0;
        for (int i = positive ? 0 : 1; i < arr.length; i++) {
            cur = '0' - arr[i];
            if (result < minq || (result == minq && cur < minr)) {
                return 0;
            }
            result = 10 * result + cur;
        }
        if (positive && result == Integer.MIN_VALUE) {
            return 0;
        }
        return positive ? -result : result;
    }

    private static boolean isValidStr(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            int ci = c - '0';
            if (c != '-' && (ci > 9 || ci < 0)) {
                return false;
            }
            if (i == 0 && (ci == 0 || (c == '-' && (length == 1 || str.charAt(1) == '0')))) {
                return false;
            }
            if (i != 0 && c == '-') {
                return false;
            }
        }
        return true;
    }

}
