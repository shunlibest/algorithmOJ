package com.每日一题.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * [每日一题] 2024-06-24 10:40:05
 * 题目名称: 下一个更大元素 II
 * 题目类型:
 * 思考:
 */
public class Code503_nextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new Code503_nextGreaterElementIi().new Solution();
    }

    /**
     * class Solution {
     * public int[] nextGreaterElements(int[] nums) {
     * int n = nums.length;
     * int[] ret = new int[n];
     * Arrays.fill(ret, -1);
     * Deque<Integer> stack = new LinkedList<Integer>();
     * for (int i = 0; i < n * 2 - 1; i++) {
     * while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
     * ret[stack.pop()] = nums[i % n];
     * }
     * stack.push(i % n);
     * }
     * return ret;
     * }
     * }
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int[] res = new int[nums.length];
            Arrays.fill(res, -1);
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < nums.length * 2 - 1; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                    res[stack.pop()] = nums[i % nums.length];
                }
                stack.push(i % nums.length);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
