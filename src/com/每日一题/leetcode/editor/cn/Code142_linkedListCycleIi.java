package com.每日一题.leetcode.editor.cn;

import com.链表.ListNode;

/**
 * [每日一题] 2024-10-12 16:29:37
 * 题目名称: 环形链表 II
 * 题目类型:
 * 思考:
 */


public class Code142_linkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new Code142_linkedListCycleIi().new Solution();

        ListNode i0 = ListNode.createNode(3, 2, 0, -4);

        ListNode node = solution.detectCycle(i0);
        ListNode.printNode(node);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fastNode = head;
            ListNode slowNode = head;

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
