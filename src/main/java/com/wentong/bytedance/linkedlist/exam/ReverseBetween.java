package com.wentong.bytedance.linkedlist.exam;

import com.wentong.bytedance.linkedlist.ListNode;

public class ReverseBetween {

    public static void main(String[] args) {
        new ReverseBetween().reverseBetween(new ListNode(3, new ListNode(5)), 1, 2);
//        new ReverseBetween().reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        // write code here
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode res = dummyNode;
        int counter = 1;
        while (counter < left) {
            dummyNode = dummyNode.next;
            counter++;
        }

        ListNode sen = dummyNode;
        ListNode prev = dummyNode.next;
        ListNode cur = dummyNode.next.next;
        counter = left;
        while (counter <= right - 1) {
            ListNode next = cur.next;
            cur.next = sen.next;
            sen.next = cur;
            prev.next = next;
            cur = next;
            counter++;
        }

        return res.next;
    }

}
