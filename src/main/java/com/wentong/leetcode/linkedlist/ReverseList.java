package com.wentong.leetcode.linkedlist;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode temp;
        ListNode cur = head;
        while (next != null) {
            temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        head.next = null;
        return cur;
    }

}
