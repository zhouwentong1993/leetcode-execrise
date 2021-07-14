package com.wentong.bytedance.string;

public class GetCountString {

    private static String getCountString(String str) {
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        sb.append(arr[0]);
        sb.append('_');
        char pre = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            char cur = arr[i];
            if (pre == cur) {
                count++;
            } else {
                sb.append(count);
                sb.append('_');
                sb.append(cur);
                sb.append('_');
                pre = cur;
                count = 1;
            }
        }
        sb.append(count);
        return sb.toString();
    }

}
