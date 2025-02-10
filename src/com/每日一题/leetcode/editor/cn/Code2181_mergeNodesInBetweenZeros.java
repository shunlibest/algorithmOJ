package com.每日一题.leetcode.editor.cn;

import com.链表.ListNode;

/**
 * [每日一题] 2024-09-09 09:59:49
 * 题目名称: 合并零之间的节点
 * 题目类型:
 * 思考:
 */


public class Code2181_mergeNodesInBetweenZeros {
    public static void main(String[] args) {
        Solution solution = new Code2181_mergeNodesInBetweenZeros().new Solution();
        int[] i0 = {0, 1, 0, 3, 0, 2, 2, 0};
        ListNode node = solution.mergeNodes(ListNode.createNode(i0));

        ListNode.printNode(node);
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
        public ListNode mergeNodes(ListNode head) {

            ListNode current = head;

            int sum = 0;
            ListNode rootNode = new ListNode(-1);
            ListNode currentResultNode = rootNode;

            while (current != null) {
                if (current.val == 0) {
                    currentResultNode.next = new ListNode(sum);
                    currentResultNode = currentResultNode.next;

                    sum = 0;
                } else {
                    sum += current.val;
                }

                current = current.next;
            }
            return rootNode.next.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
