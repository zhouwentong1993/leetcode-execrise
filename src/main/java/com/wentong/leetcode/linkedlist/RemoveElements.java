package com.wentong.leetcode.linkedlist;

public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        ListNode pre = dummy;
        dummy.next = head;
        while (dummy != null) {
            if (dummy.val == val) {
                pre.next = dummy.next;
            } else {
                pre = dummy;
            }
            dummy = dummy.next;
        }
        return temp.next;
    }

}
