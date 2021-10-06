package com.链表;

public class Code328_奇偶链表 {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;

        ListNode.printNode(listNode1);

        System.out.println("");

        ListNode listNode = oddEvenList(null);

        ListNode.printNode(listNode);

    }

    public static ListNode oddEvenList(ListNode head) {

        if (head==null || head.next==null){
            return head;
        }


        ListNode oddNum = head;
        ListNode evenNum = head.next;
        ListNode saveOdd = head;
        ListNode saveEven = head.next;

        ListNode currentNode = head.next.next;

        while (currentNode != null) {
            oddNum.next = currentNode;
            evenNum.next = currentNode.next;

            oddNum = oddNum.next;
            evenNum = evenNum.next;

            if (currentNode.next == null) {
                currentNode = null;

            } else {
                currentNode = currentNode.next.next;

            }
        }

        oddNum.next = saveEven;


        return saveOdd;
    }
}


