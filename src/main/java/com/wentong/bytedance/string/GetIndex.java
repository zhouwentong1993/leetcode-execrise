package com.wentong.bytedance.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetIndex {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String str = bf.readLine();
        String[] data = new String[n];
        for (int i = 0; i < n; i++) {
            data[i] = bf.readLine();
            data[i] = data[i].equals("0") ? null : data[i];
        }
        bf.close();
        System.out.println(getIndex(data, str));
    }

    private static int getIndex(String[] data, String str) {

        int left = 0;
        int right = data.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (data[mid] != null && data[mid].equals(str)) {
                result = mid;
                right = mid - 1;
            } else if (data[mid] != null) {
                if (data[mid].compareTo(str) > 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                int i = mid;
                while (data[i] == null && i > left) {
                    i--;
                }
                if (data[i] == null) {
                    left = mid + 1;
                } else {
                    if (data[i].compareTo(str) >= 0) {
                        right = i;
                    } else {
                        left = i + 1;
                    }
                }
            }
        }
        return result;
    }
}
