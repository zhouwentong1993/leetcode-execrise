package com.wentong.bytedance.linkedlist2;

public class ReverseList {

    public ListNode reverseList(ListNode prev) {
        if (prev == null || prev.next == null) {
            return prev;
        }
        ListNode start = prev;
        ListNode next = prev.next;
        while (next != null) {
            ListNode temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
        }
        start.next = null;
        return prev;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
