package com.wentong.bytedance.linkedlist.exam;

import com.wentong.bytedance.linkedlist.ListNode;

//https://www.nowcoder.com/practice/3d281dc0b3704347846a110bf561ef6b?tpId=46&&tqId=29037&rp=1&ru=/ta/classic-code&qru=/ta/classic-code/question-ranking
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        slow = slow.next;
        mid.next = null;


        ListNode slowTmp = slow;
        if (slow.next != null) {
            ListNode cur = slow.next;
            ListNode tmp;
            while (cur != null) {
                tmp = cur.next;
                cur.next = slow;
                slow = cur;
                cur = tmp;
            }
            slowTmp.next = null;
        }
        while (slow != null) {
            ListNode sn = slow.next;
            ListNode hn = head.next;
            head.next = slow;
            slow.next = hn;
            head = hn;
            slow = sn;
        }
    }

}
