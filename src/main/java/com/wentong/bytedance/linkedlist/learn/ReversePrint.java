package com.wentong.bytedance.linkedlist.learn;

import com.wentong.bytedance.linkedlist.ListNode;

// https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/submissions/
public class ReversePrint {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(3, new ListNode(2)));
        System.out.println(new ReversePrint().reversePrint(listNode));
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        ListNode h = head;
        ListNode cur = head.next;
        ListNode prev = head;
        int count = 0;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            count++;
        }
        h.next = null;
        int[] ans = new int[count + 1];
        int i = 0;
        while (prev != null) {
            ans[i] = prev.val;
            prev = prev.next;
            i++;
        }
        return ans;
    }
}
