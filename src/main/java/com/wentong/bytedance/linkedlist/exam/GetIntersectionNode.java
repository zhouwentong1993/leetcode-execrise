package com.wentong.bytedance.linkedlist.exam;

import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode {

    // 最简单方式，先遍历一个链表，将所有元素保存。然后遍历另外一个，借助于 set 来完成数据匹配。
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    // 考虑特殊情况，两个链表不一样长。
    // 如何遍历能够让他们一样长呢？
    // 很简单，每个都遍历两次就行了。假设 A 链表为 a 长，B 链表为 b 长，公共部分为 c。
    // 则 a + (b - c) = b + (a - c)，此时 c 就是交汇点。
    // 当 c == 0 时，也就是两者都完整地遍历完全部两条链表，不相交。
    // 当 c != 0 时，c 就是交汇点。
    // 时间复杂度为最多 a + b。也就是不相交，需要遍历两次。
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        if (headA == headB) {
            return headA;
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
