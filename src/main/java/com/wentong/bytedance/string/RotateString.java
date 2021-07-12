package com.wentong.bytedance.string;

public class RotateString {

    // 绕轴旋转特性。
    public boolean rotateString(String s, String goal) {
        if (s == null || goal == null || s.length() != goal.length()) {
            return false;
        }
        String newGoal = goal + goal;
        return newGoal.contains(s);
    }

}
