package com.链表;

public class Code141_环形链表 {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
//        listNode2.next = listNode1;
//        listNode3.next = listNode4;
//        listNode4.next = listNode2;


//        ListNode.printNode(listNode1);

        boolean b = hasCycle(listNode1);
        System.out.println(b);
    }

    public static boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }

        ListNode fastNode = head.next;
        ListNode slowNode = head;

        while (fastNode != slowNode) {
            if (fastNode == null || fastNode.next ==null) {
                return false;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        return true;
    }


}


