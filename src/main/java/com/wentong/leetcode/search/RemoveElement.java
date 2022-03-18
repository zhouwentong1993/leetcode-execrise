package com.wentong.leetcode.search;

public class RemoveElement {

    /**
     * 使用快慢指针完成功能。
     * https://leetcode-cn.com/problems/remove-element/submissions/
     */
    public int removeElement(int[] nums, int val) {
        int fastIndex = 0;
        int slowIndex = 0;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

}
