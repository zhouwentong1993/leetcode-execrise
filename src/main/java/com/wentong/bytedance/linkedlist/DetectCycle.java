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

    // 双指针判断环
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // 用死循环的原因是：
        // 1. 要么无环，fast == null 时 return。
        // 2. 要么有环，双指针最终会相遇
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            // 代表 fast 已经遍历结束了，肯定没有环。如果有环，fast 会一直死循环
            if (fast == null) {
                return null;
            }
            slow = slow.next;

            // 代表快慢指针相遇，代表此时有环
            if (fast == slow) {
                break;
            }
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
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
