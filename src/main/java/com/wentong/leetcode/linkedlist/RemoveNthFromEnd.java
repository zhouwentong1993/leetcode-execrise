package com.wentong.leetcode.linkedlist;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = slow;
        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev == slow) {
            return head.next;
        }
        prev.next = slow.next;

        return head;
    }

}
