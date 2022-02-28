package com.wentong.leetcode.linkedlist;

public class DetectCycle {

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            if (fast == null) {
                return null;
            } else {
                fast = fast.next;
            }
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

}
