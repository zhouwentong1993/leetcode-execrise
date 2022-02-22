package com.wentong.leetcode.linkedlist;

import java.util.List;

public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        int sum = 0;

        while (l1 != null && l2 != null) {
            head.next = new ListNode();
            head = head.next;
            int temp = l1.val + l2.val + sum;
            sum = temp / 10;
            head.val = temp % 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            head.next = new ListNode();
            head = head.next;
            int temp = l1.val + sum;
            sum = temp / 10;
            head.val = temp % 10;
            l1 = l1.next;

        }
        while (l2 != null) {
            head.next = new ListNode();
            head = head.next;
            int temp = l2.val + sum;
            sum = temp / 10;
            head.val = temp % 10;
            l2 = l2.next;
        }
        if (sum != 0) {
            head.next = new ListNode(1);
        }

        return result.next;
    }

}
