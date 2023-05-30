package com.链表;


public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public static void printNode(ListNode node) {
        ListNode currentNode = node;
        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }

    public static ListNode createNode(int... values) {
        ListNode head = new ListNode(values[0]);
        ListNode currentNode = head;
        for (int i = 1; i < values.length; i++) {
            currentNode.next = new ListNode(values[i]);
            currentNode = currentNode.next;
        }
        return head;
    }


}