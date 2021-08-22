package com.leetcode;

//https://leetcode-cn.com/problems/add-two-numbers/
public class Code2_两数相加_M2 {

    public static void main(String[] args) {
        ListNode node2 = new ListNode(1);
        ListNode node4 = new ListNode(8);
//        ListNode node3 = new ListNode(9);
        node2.next = node4;
//        node4.next = node3;

        ListNode node5 = new ListNode(0);
//        ListNode node6 = new ListNode(9);
//        ListNode node44 = new ListNode(9);
//        node5.next = node6;
//        node6.next = node44;

        Code2_两数相加_M2 a = new Code2_两数相加_M2();
        ListNode listNode = a.addTwoNumbers(node2, node5);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rootNode = new ListNode(0);
        ListNode resNode = rootNode;

        int needAddOne = 0;
        while ((l1 != null || l2 != null) || needAddOne == 1) {
            int v1 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }

            int v2 = 0;
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int i = v1 + v2 + needAddOne;
            if (i >= 10) {
                needAddOne = 1;
                i -= 10;
            } else {
                needAddOne = 0;
            }
            resNode.next = new ListNode(i);
            resNode = resNode.next;
        }
        if (rootNode.next != null) {
            rootNode = rootNode.next;
        }
        getNum(rootNode);
        return rootNode;
    }


    private long getNum(ListNode node) {
        long num = 0;
        long i = 1;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
        return num;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
