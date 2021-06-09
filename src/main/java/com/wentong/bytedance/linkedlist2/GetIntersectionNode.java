package com.wentong.bytedance.linkedlist2;

public class GetIntersectionNode {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB) {
            return headA;
        }
        if (headA == null || headB == null) {
            return null;
        }
        ListNode A = headA;
        ListNode B = headB;
        while (true) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
            if (A == B) {
                return A;
            }
        }
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
