package com.wentong.leetcode.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                int target = -(nums[i] + nums[i1]);
                Integer value = map.get(target);
                if (value != null && value >= i1) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(nums[i]);
                    list1.add(nums[i1]);
                    list1.add(target);
                    list.add(list1);
                } else {
                    map.put(nums[i], i);
                    map.put(nums[i1], i1);
                }
            }
        }
        return list;
    }

}
