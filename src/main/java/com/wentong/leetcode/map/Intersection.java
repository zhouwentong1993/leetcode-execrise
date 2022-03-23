package com.wentong.leetcode.map;

import java.util.HashSet;
import java.util.Set;

public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> n1Set = new HashSet<>();
        Set<Integer> n2Set = new HashSet<>();
        for (int i : nums1) {
            n1Set.add(i);
        }
        for (int i : nums2) {
            if (n1Set.contains(i)) {
                n2Set.add(i);
            }
        }
        int[] result = new int[n2Set.size()];
        int index = 0;
        for (Integer i : n2Set) {
            result[index] = i;
            index++;
        }
        return result;
    }

}
