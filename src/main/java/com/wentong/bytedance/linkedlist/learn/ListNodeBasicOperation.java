package com.wentong.bytedance.linkedlist.learn;

public class ListNodeBasicOperation {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode tail = new ListNode(5);
        ListNode listNode = addNodeToTail(head, tail);
        System.out.println(listNode);
        System.out.println(dropNodeFromTail(listNode));
    }

    public static ListNode addNodeToTail(ListNode head, ListNode tail) {
        ListNode start = head;
        if (head == null) {
            return tail;
        }
        while (head.next != null) {
            head = head.next;
        }
        head.next = tail;
        return start;
    }

    public static ListNode dropNodeFromTail(ListNode head) {
        ListNode start = head;
        if (head == null || head.next == null) {
            return null;
        }
        while (head.next.next != null) {
            head = head.next;
        }
        head.next = null;
        return start;
    }

}
