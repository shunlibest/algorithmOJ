package com.leetcode;

//https://leetcode-cn.com/problems/add-two-numbers/
public class Code2_两数相加 {

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node2.next = node4;
        node4.next = node3;

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node44 = new ListNode(4);
        node5.next = node6;
        node6.next = node44;

        Code2_两数相加 a = new Code2_两数相加();
        ListNode listNode = a.addTwoNumbers(node2, node5);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = getNum(l1);
        long num2 = getNum(l2);
        long sum = num1 + num2;

//        [9]
//[1,9,9,9,9,9,9,9,9,9]

        ListNode rootNode = new ListNode(0);
        ListNode res = rootNode;
        while (sum != 0) {
            int val = (int) (sum % 10);
            sum /= 10;
            res.next = new ListNode(val);
            res = res.next;
        }
        if (rootNode.next != null) {
            rootNode = rootNode.next;
        }
        long root = getNum(rootNode);


        System.out.println(root);
        return rootNode;
    }

    private long getNum(ListNode node) {
        long num = 0;
        long i = 1;
        while (node != null) {
            num = num + node.val * i;
            node = node.next;
            i *= 10;
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
