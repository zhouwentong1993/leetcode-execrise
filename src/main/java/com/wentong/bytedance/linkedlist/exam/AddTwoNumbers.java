package com.wentong.bytedance.linkedlist.exam;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode prev = l;
        ListNode start = l;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + l.val;
            if (sum > 9) {
                l.val = sum % 10;
                l.next = new ListNode(1);
            } else {
                l.val = sum;
                l.next = new ListNode(0);
            }
            l1 = l1.next;
            l2 = l2.next;
            prev = l;
            l = l.next;
        }
        if (l1 != null) {
            prev = add(l1, l, prev);
        } else if (l2 != null) {
            prev = add(l2, l, prev);
        }
        if (prev.next.val == 0) {
            prev.next = null;
        }
        return start;
    }

    private static ListNode add(ListNode l1, ListNode l, ListNode prev) {
        while (l1 != null) {
            int sum = l.val + l1.val;
            if (sum > 9) {
                l.val = sum % 10;
                l.next = new ListNode(1);
            } else {
                l.val = sum;
                l.next = new ListNode(0);
            }
            l1 = l1.next;
            prev = l;
            l = l.next;
        }
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
