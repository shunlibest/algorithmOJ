package com.链表;

import static com.链表.ListNode.createNode;

public class Code142_环形链表2 {
    public static void main(String[] args) {
        ListNode node = createNode(3, 2, 0, -4);

        ListNode tail = node.next.next.next;
        tail.next = node;
        ListNode node1 = new Code142_环形链表2().detectCycle(node);
        System.out.println(node1.val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        int index = 0;

        while (fastNode.next.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;

            if (slowNode == fastNode) {
                return slowNode;
            }

        }
        return null;
    }
}
