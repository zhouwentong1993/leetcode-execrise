package com.wentong.bytedance.linkedlist.exam;

import com.wentong.bytedance.linkedlist.ListNode;

import java.util.concurrent.TimeUnit;

public class Partition {

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        },"t1").start();
        TimeUnit.MICROSECONDS.sleep(100);
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        },"t2").start();

    }

    /**
     * 分隔数组，通过四个变量来记住上下界
     * 然后再把它们依次拼接起来就行了
     * 分成三份也没有问题，只不过再加一个就行
     */
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = null;
        ListNode leftTail = null;
        ListNode rightHead = null;
        ListNode rightTail = null;

        if (head == null || head.next == null) {
            return head;
        }

        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                if (leftHead == null) {
                    leftHead = head;
                    leftTail = head;
                } else {
                    leftTail.next = head;
                    leftTail = head;
                }
            } else {
                if (rightHead == null) {
                    rightHead = head;
                    rightTail = head;
                } else {
                    rightTail.next = head;
                    rightTail = head;
                }
            }
            head = next;
        }

        if (leftHead != null) {
            leftTail.next = rightHead;
            return leftHead;
        } else {
            return rightHead;
        }
    }

}
