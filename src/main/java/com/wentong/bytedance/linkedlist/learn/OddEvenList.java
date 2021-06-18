package com.wentong.bytedance.linkedlist.learn;

public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode oddHead = odd;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            if (even.next.next == null) {
                break;
            }
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        even.next = null;
        return oddHead;
    }

}
