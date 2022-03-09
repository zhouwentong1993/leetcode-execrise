package com.wentong.leetcode.map;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer key = map.get(target - nums[i]);
            if (key != null) {
                return new int[]{i, key};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

}
