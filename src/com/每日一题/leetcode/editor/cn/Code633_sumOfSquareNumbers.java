package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-11-04 10:24:46
 * 题目名称: 平方数之和
 * 题目类型:
 * 思考:
 */


public class Code633_sumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new Code633_sumOfSquareNumbers().new Solution();
        Object i0 = 5;
        boolean b = solution.judgeSquareSum(2147483600);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {

            long left = 0;
            long right = (int) Math.sqrt(c);

            while (left <= right) {
                long res = left * left + right * right;

                if (res < c) {
                    left++;
                } else if (res > c) {
                    right--;
                } else {
//                    System.out.println(left + "," + right);
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
