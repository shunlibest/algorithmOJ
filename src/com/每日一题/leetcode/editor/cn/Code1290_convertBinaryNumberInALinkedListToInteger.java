package com.每日一题.leetcode.editor.cn;

import com.链表.ListNode;

/**
 * [每日一题] 2025-07-14 10:25:54
 * 题目名称: 二进制链表转整数
 * 题目类型:
 * 思考:
 */


public class Code1290_convertBinaryNumberInALinkedListToInteger {
    public static void main(String[] args) {
        Solution solution = new Code1290_convertBinaryNumberInALinkedListToInteger().new Solution();
        int[] i0 = {1,0,0,1,0,0,1,1,1,0,0,0,0,0,0};
        ListNode node = ListNode.createNode(i0);

        int decimalValue = solution.getDecimalValue(node);
        System.out.println(decimalValue);
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
        public int getDecimalValue(ListNode head) {

            ListNode currentNode = head;
            int currentValue = 0;

            while (currentNode != null) {
                currentValue = currentValue * 2 + currentNode.val;

                currentNode = currentNode.next;
            }

            return currentValue;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
