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
        while (left < right) {
            int mid = (right - left) / 2;
            while (data[mid] == null) {
                mid++;
            }
            if (data[mid].equals(str)) {
                int last = mid;
                while (mid >= 0) {
                    if (data[mid] == null) {
                        mid--;
                    }
                    if (data[mid].equals(str)) {
                        last = mid;
                        mid--;
                    } else {
                        return last;
                    }

                }
                return last;
            }

            if (data[mid].compareTo(str) > 0) {
                right = mid;
            } else if (data[mid].compareTo(str) == 0) {
                return mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }
}
