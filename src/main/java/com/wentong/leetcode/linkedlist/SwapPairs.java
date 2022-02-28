package com.wentong.leetcode.linkedlist;

public class SwapPairs {

    // 利用递归思路解决问题。很好。
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode one = head;
        ListNode two = one.next;
        ListNode three = two.next;
        two.next = one;
        one.next = swapPairs(three);
        return two;
    }

}
