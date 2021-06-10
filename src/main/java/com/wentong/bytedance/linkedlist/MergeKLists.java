package com.wentong.bytedance.linkedlist;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode result = null;
        ListNode listNode = mergeTwoLists(lists[0], result);
        for (int i = 1; i < lists.length; i++) {
            listNode = mergeTwoLists(lists[i], listNode);
            print(listNode);
        }
        return listNode;
    }

    private void print(ListNode result) {
        while (result != null) {
//            System.out.print(result.val + "-");
            result = result.next;
        }
    }

    private ListNode mergeTwoLists(ListNode first, ListNode second) {
        ListNode prev = new ListNode(-1);
        ListNode start = prev;
        while (first != null && second != null) {
            if (first.val < second.val) {
                prev.next = new ListNode(first.val);
                first = first.next;
            } else {
                prev.next = new ListNode(second.val);
                second = second.next;
            }
            prev = prev.next;
        }
        if (first != null) {
            prev.next = first;
        }
        if (second != null) {
            prev.next = second;
        }
        return start.next;
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
