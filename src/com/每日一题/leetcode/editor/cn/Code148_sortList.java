package com.每日一题.leetcode.editor.cn;

import com.链表.ListNode;

/**
 * [每日一题] 2024-09-02 17:32:12
 * 题目名称: 排序链表
 * 题目类型:
 * 思考:
 */


public class Code148_sortList {
    public static void main(String[] args) {
        Solution solution = new Code148_sortList().new Solution();
//        Object i0 = {4, 2, 1, 3};
//        Object i1 = {};
        ListNode node = ListNode.createNode(-1,5,3,4,0);

        ListNode node1 = solution.sortList(node);

        ListNode.printNode(node1);


    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode sortList(ListNode head) {

            ListNode current = head;

            ListNode newListNode = new ListNode(Integer.MIN_VALUE);


            while (current != null) {
                insert(newListNode, new ListNode(current.val));
                current = current.next;
            }

            return newListNode.next;
        }


        private void insert(ListNode newListNode, ListNode node) {
            ListNode current = newListNode;
//            ListNode before = newListNode;

            while (current != null) {
                if (current.next == null) {
                    current.next = node;
                    break;
                }

                if (current.next.val > node.val) {
                    ListNode temp = current.next;
                    current.next = node;
                    node.next = temp;
                    break;
                }
                current = current.next;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
