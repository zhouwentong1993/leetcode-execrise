package com.wentong.bytedance.linkedlist.exam;

public class MergeKLists {

    // 循环赋值
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode listNode = null;
        for (int i = 1; i < lists.length; i++) {
            listNode = mergeTwoLists(lists[i], listNode);
        }
        return listNode;
    }

    // 采用分治法，将任务分割，类似于二分法
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    private ListNode mergeTwoLists(ListNode first, ListNode second) {
        ListNode prev = new ListNode(-1);
        ListNode start = prev;
        while (first != null && second != null) {
            if (first.val < second.val) {
                prev.next = first;
                first = first.next;
            } else {
                prev.next = second;
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
