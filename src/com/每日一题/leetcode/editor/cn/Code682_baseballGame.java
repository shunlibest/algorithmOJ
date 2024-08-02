package com.每日一题.leetcode.editor.cn;

import java.util.Stack;

/**
 * [每日一题] 2024-07-29 09:49:28
 * 题目名称: 棒球比赛
 * 题目类型:
 * 思考:
 */
public class Code682_baseballGame {
    public static void main(String[] args) {
        Solution solution = new Code682_baseballGame().new Solution();

        String[] array = {"5","2","C","D","+"};

        int i = solution.calPoints(array);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calPoints(String[] operations) {
            Stack<Integer> stack = new Stack<>();


            for (String s : operations) {
                if (s.equals("+")) {
                    Integer first = stack.pop();
                    Integer second = stack.peek();
                    stack.push(first);
                    stack.push(first + second);
                } else if (s.equals("D")) {
                    Integer first = stack.peek();
                    stack.push(first * 2);
                } else if (s.equals("C")) {
                    stack.pop();
                } else {
                    stack.push(Integer.parseInt(s));
                }
            }

            int sum = 0;
            for (Integer value : stack) {
                sum += value;
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
