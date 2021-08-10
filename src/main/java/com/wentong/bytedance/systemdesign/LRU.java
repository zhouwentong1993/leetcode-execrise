package com.wentong.bytedance.systemdesign;

import java.util.*;

public class LRU {

    public static void main(String[] args) {
        int[][] op = new int[3][];
        op[0] = new int[]{1, 1, 1};
        op[1] = new int[]{1, 1, 2};
        op[2] = new int[]{2, 1};
//        op[3] = new int[]{2, 1};
//        op[4] = new int[]{1, 4, 4};
//        op[5] = new int[]{2, 2};
        int[] lru = new LRU().LRU(op, 3);
        System.out.println(Arrays.toString(lru));
    }

    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    private Map<Integer, Integer> cache = new HashMap<>();
    private LinkedList<Integer> list = new LinkedList<>();

    public int[] LRU(int[][] operators, int k) {
        List<Integer> result = new ArrayList<>();
        for (int[] arr : operators) {
            int opt = arr[0];
            if (opt == 1) {
                Integer key = arr[1];
                int value = arr[2];
                if (cache.containsKey(key)) {
                    list.remove(key);
                } else {
                    if (cache.size() == k) {
                        int removed = list.removeLast();
                        cache.remove(removed);
                    }
                }
                list.addFirst(key);
                cache.put(key, value);
            } else if (opt == 2) {
                Integer key = arr[1];
                int value = cache.getOrDefault(key, -1);
                result.add(value);
                if (value != -1) {
                    list.remove(key);
                    list.addFirst(key);
                }
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

}
