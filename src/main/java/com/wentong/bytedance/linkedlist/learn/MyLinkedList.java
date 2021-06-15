package com.wentong.bytedance.linkedlist.learn;


import org.jcp.xml.dsig.internal.SignerOutputStream;

/*
在链表类中实现这些功能：

get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。

 */
public class MyLinkedList {
//["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
//[[],              [7],        [2],        [1],        [3,0],          [2],            [6],        [4],    [4],    [4],        [5,0],          [6]]
    public static void main(String[] args) {
        MyLinkedList l = new MyLinkedList();
        l.addAtHead(7);
        l.addAtHead(2);
        l.addAtHead(1);
        l.addAtIndex(3, 0);
        l.deleteAtIndex(2);
        l.addAtHead(6);
        l.addAtTail(4);
        System.out.println(l.get(4));
        l.addAtHead(4);
        l.addAtIndex(5, 0);
        l.addAtHead(6);
    }


    /**
     * Initialize your data structure here.
     */
    private Node head;

    class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        Node(int val) {
            this.val = val;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node temp = head;
        if (temp == null || index < 0) {
            return -1;
        }
        int counter = 0;
        while (temp != null) {
            if (index == counter) {
                return temp.val;
            }
            temp = temp.next;
            counter++;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        this.head = new Node(val, head);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     * 1,2
     */
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        int counter = 0;
        Node temp = head;
        while (temp != null) {
            if (index - 1 == counter) {
                if (temp.next != null) {
                    Node toNext = new Node(val, temp.next.next);
                    Node tt = temp.next;
                    temp.next = toNext;
                    toNext.next = tt;
                } else {
                    temp.next = new Node(val, null);
                }
                return;
            }
            counter++;
            temp = temp.next;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            this.head = head.next;
        } else {
            Node temp = head;
            int counter = 0;
            while (temp != null) {
                if (index - 1 == counter) {
                    if (temp.next != null) {
                        temp.next = temp.next.next;
                    }
                    return;
                }
                counter++;
                temp = temp.next;
            }
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
