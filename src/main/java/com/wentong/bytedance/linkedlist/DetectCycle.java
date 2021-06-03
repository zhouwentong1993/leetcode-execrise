package com.wentong.bytedance.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class DetectCycle {

    public static ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        int index = 0;
        while (head != null) {
            if (head.next == null) {
                return null;
            } else {
                Integer result = map.get(head.next);
                if (result != null) {
                    return head.next;
                } else {
                    map.put(head, index);
                    index++;
                    head = head.next;
                }
            }
        }
        return null;
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
