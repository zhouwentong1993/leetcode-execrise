package com.wentong.leetcode.map;

import java.util.HashSet;
import java.util.Set;


// https://leetcode-cn.com/problems/happy-number/

// 如果计算和的过程中再次出现了之前的结果，就代表出现死循环了。
// 查找的问题一般通过 hashmap 实现，于是题目就变成了用 set 找重复，每次计算 sum，放入 set 中就行了。
public class IsHappy {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNum(n);
        }
        return n == 1;
    }

    private int getNextNum(int n) {
        int result = 0;
        while (n > 0) {
            int temp = n % 10;
            result += temp * temp;
            n = n / 10;
        }
        return result;
    }

}
