package com.wentong.bytedance.linkedlist.exam;

import com.wentong.bytedance.linkedlist.ListNode;

public class Partition {

    /**
     * 分隔数组，通过四个变量来记住上下界
     * 然后再把它们依次拼接起来就行了
     * 分成三份也没有问题，只不过再加一个就行
     */
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = null;
        ListNode leftTail = null;
        ListNode rightHead = null;
        ListNode rightTail = null;

        if (head == null || head.next == null) {
            return head;
        }

        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                if (leftHead == null) {
                    leftHead = head;
                    leftTail = head;
                } else {
                    leftTail.next = head;
                    leftTail = head;
                }
            } else {
                if (rightHead == null) {
                    rightHead = head;
                    rightTail = head;
                } else {
                    rightTail.next = head;
                    rightTail = head;
                }
            }
            head = next;
        }

        if (leftHead != null) {
            leftTail.next = rightHead;
            return leftHead;
        } else {
            return rightHead;
        }
    }

}
