package com.wentong.bytedance.linkedlist.review;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode start = result;
        ListNode prev = result;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + result.val;
            result.val = sum % 10;
            result.next = new ListNode(sum / 10);
            l1 = l1.next;
            l2 = l2.next;
            prev = result;
            result = result.next;
        }

        while (l1 != null) {
            int sum = result.val + l1.val;
            result.val = sum % 10;
            result.next = new ListNode(sum / 10);
            l1 = l1.next;
            prev = result;
            result = result.next;
        }

        while (l2 != null) {
            int sum = result.val + l2.val;
            result.val = sum % 10;
            result.next = new ListNode(sum / 10);
            l2 = l2.next;
            prev = result;
            result = result.next;
        }

        if (result.val == 0) {
            prev.next = null;
        }

        return start;
    }

    private static class ListNode {
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
