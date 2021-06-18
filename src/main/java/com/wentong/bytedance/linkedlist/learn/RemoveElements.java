package com.wentong.bytedance.linkedlist.learn;

import com.wentong.bytedance.linkedlist.ListNode;

public class RemoveElements {

    public static void main(String[] args) {
        RemoveElements r = new RemoveElements();
        r.removeElements(new ListNode(1, new ListNode(2, new ListNode(3))), 6);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        while (head != null) {
            if (head.val != val) {
                start.next = new ListNode(head.val);
                start = start.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

}
