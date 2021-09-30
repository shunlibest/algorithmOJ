package com.链表;

public class Code206_反转链表 {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode.printNode(listNode1);


        ListNode listNode = reverseList(listNode1);

        ListNode.printNode(listNode);

    }

    public static ListNode reverseList(ListNode head) {
        ListNode previewNode = null;
        ListNode currentNode = head;


        while (currentNode != null) {
            ListNode temp = currentNode.next;

            currentNode.next = previewNode;
            previewNode = currentNode;
            currentNode = temp;
        }
        return previewNode;
    }




}


