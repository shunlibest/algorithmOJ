package com.链表;

public class Code24_两两交换链表中的节点 {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;

        ListNode.printNode(listNode1);

        System.out.println("");

        ListNode listNode = swapPairs(listNode1);

        ListNode.printNode(listNode);

    }

    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pairA = head;
        ListNode pairB = head.next;

        ListNode save = head.next;


        while (pairA != null && pairB != null) {

            ListNode node3 = pairB.next;
            ListNode node4 = null;

            if (node3 != null) {
                node4 = node3.next;
            }

            if (node4==null){
                pairA.next = node3;
            }else {
                pairA.next = node4;
            }
            pairB.next = pairA;






            pairA = node3;
            pairB = node4;
        }

        return save;
    }

}


