package com.wentong.bytedance.linkedlist.learn;

import com.wentong.bytedance.linkedlist.ListNode;

public class RemoveNthFromEnd {

    // 通过快慢指针，快指针负责探测链表长度，慢指针可能有用，也可能没用
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int index = 0;
        int size = 0;

        while (fast != null) {
            if (fast.next == null) {
                size = index * 2 + 1;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
            index++;
            if (fast == null) {
                size = index * 2;
                break;
            }
        }
        if (n > size || size == 1) {
            return null;
        }
        if (size - n > index + 1) {
            while (size - n > index + 1) {
                slow = slow.next;
                index++;
            }
            slow.next = slow.next.next;
        } else {
            index = 0;
            fast = head;
            if (size - n == 0) {
                return head.next;
            }
            while (index + 1 < size - n) {
                fast = fast.next;
                index++;
            }
            fast.next = fast.next.next;
        }
        return head;
    }

    // 利用真正的快慢指针
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        // 先让 first 和 second 拉开 n 个距离
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
