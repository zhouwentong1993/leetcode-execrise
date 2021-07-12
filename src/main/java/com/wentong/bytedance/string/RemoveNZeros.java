package com.wentong.bytedance.string;

public class RemoveNZeros {

    public static void main(String[] args) {
        String s = new RemoveNZeros().removeKZeros("A0000B000", 3);
        System.out.println(s);

    }

    public String removeNZeros(String str, int n) {
        if (str == null || n == 0) {
            return str;
        }
        int counter = 0;
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == '0') {
                counter++;
            } else {
                if (counter == n) {
                    for (int j = i; j > i - n - 1; j--) {
                        cs[j] = 0;
                    }
                }
                counter = 0;
            }
            cs[i] = c;
        }
        if (counter == n) {
            for (int j = cs.length - n; j < cs.length; j++) {
                cs[j] = 0;
            }
        }
        return String.valueOf(cs);
    }

    public String removeKZeros(String str, int k) {
        if (str == null || k < 1) {
            return str;
        }
        char[] chas = str.toCharArray();
        int count = 0, start = -1;
        for (int i = 0; i != chas.length; i++) {
            if (chas[i] == '0') {
                count++;
                start = start == -1 ? i : start;
            } else {
                if (count == k) {
                    while (count-- != 0) {
                        chas[start++] = 0;
                    }
                }
                count = 0;
                start = -1;
            }
        }
        if (count == k) {
            while (count-- != 0) {
                chas[start++] = 0;
            }
        }
        return String.valueOf(chas);
    }
}
