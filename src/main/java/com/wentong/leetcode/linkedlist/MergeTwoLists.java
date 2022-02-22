package com.wentong.leetcode.linkedlist;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                head.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            head = head.next;
        }
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return dummy.next;
    }

}
