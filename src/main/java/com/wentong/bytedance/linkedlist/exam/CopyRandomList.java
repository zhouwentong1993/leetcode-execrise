package com.wentong.bytedance.linkedlist.exam;


// https://leetcode-cn.com/problems/copy-list-with-random-pointer/
public class CopyRandomList {

    // 分为三步：
    // 1. 将所有结点复制一份，放到当前结点后  1->2->3->4->null  ===>  1->1'->2->2'->3->3'->4->4'->null
    // 2. 将新连接结点的 random 指针赋值，新结点的 random = 老结点的 random.next 或者 null（如果老结点指向 null，新结点也要指向 null）
    // 3. 将所有结点拆分，将新老节点拆分开，不能改变原有结点。
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node next;
        Node temp = head;
        Node temp2 = head;
        while (head != null) {
            next = head.next;
            head.next = new Node(head.val);
            head.next.next = next;
            head = next;
        }
        while (temp != null) {
            if (temp.random == null) {
                temp.next.random = null;
            } else {
                temp.next.random = temp.random.next;
            }

            temp = temp.next.next;
        }
        Node s = temp2.next;
        Node cur;
        while (temp2 != null) {
            next = temp2.next.next;
            cur = temp2.next;
            temp2.next = next;
            cur.next = next != null ? next.next : null;
            temp2 = temp2.next;
        }
        return s;
    }

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
