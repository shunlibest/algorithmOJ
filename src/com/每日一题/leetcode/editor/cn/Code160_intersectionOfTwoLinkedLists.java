package com.每日一题.leetcode.editor.cn;

import com.链表.ListNode;

/**
 * [每日一题] 2024-10-12 14:01:02
 * 题目名称: 相交链表
 * 题目类型:
 * 思考:
 */


public class Code160_intersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new Code160_intersectionOfTwoLinkedLists().new Solution();

        ListNode headA = ListNode.createNode(4, 1, 8, 4, 5);
        ListNode headB = ListNode.createNode(5, 6, 1, 8, 4, 5);
        Object i7 = 2;
        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);

        ListNode.printNode(intersectionNode);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode currentA = headA;
            ListNode currentB = headB;
            int aSize = 0;
            while (currentA != null) {
                currentA = currentA.next;
                aSize++;
            }

            int bSize = 0;
            while (currentB != null) {
                currentB = currentB.next;
                bSize++;
            }
            currentA = headA;
            currentB = headB;
            if (aSize > bSize) {
                for (int i = 0; i < aSize - bSize; i++) {
                    currentA = currentA.next;
                }
            } else {
                for (int i = 0; i < bSize - aSize; i++) {
                    currentB = currentB.next;
                }
            }
            while (currentA != null) {
                if (currentA == currentB) {
                    return currentA;
                }
                currentA = currentA.next;
                currentB = currentB.next;
            }

            return null;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
