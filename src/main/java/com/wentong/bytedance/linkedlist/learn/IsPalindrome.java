package com.wentong.bytedance.linkedlist.learn;

import com.wentong.bytedance.linkedlist.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        boolean palindrome = isPalindrome.isPalindrome(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1)))));
        System.out.println(palindrome);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        Deque<ListNode> stack = new LinkedList<>();
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = slow.next;
        while (slow != null) {
            stack.push(new ListNode(slow.val));
            slow = slow.next;
        }
        fast = head;
        while (!stack.isEmpty()) {
            if (stack.pop().val != fast.val) {
                return false;
            }
            fast = fast.next;
        }
        return true;
    }


}
