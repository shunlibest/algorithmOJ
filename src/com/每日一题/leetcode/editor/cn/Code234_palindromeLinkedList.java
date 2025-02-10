package com.每日一题.leetcode.editor.cn;

import com.Utils;
import com.链表.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * [每日一题] 2024-10-12 16:13:05
 * 题目名称: 回文链表
 * 题目类型:
 * 思考:
 */


public class Code234_palindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new Code234_palindromeLinkedList().new Solution();
        ListNode i0 = ListNode.createNode(1, 2, 2, 1);
        boolean palindrome = solution.isPalindrome(i0);
        System.out.println(palindrome);
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
        public boolean isPalindrome(ListNode head) {
            List<Integer> list = new ArrayList<>();

            while (head != null) {
                list.add(head.val);
                head = head.next;
            }

//            Utils.printTable(list);

            for (int i = 0; i < list.size() / 2; i++) {
                if (list.get(i).intValue() != list.get(list.size() - i - 1).intValue()) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
