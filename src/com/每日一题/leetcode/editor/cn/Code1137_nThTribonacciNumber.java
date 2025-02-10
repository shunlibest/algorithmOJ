package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-08-09 14:39:25
 * 题目名称: 第 N 个泰波那契数
 * 题目类型:
 * 思考:
 */


public class Code1137_nThTribonacciNumber {
    public static void main(String[] args) {
        Solution solution = new Code1137_nThTribonacciNumber().new Solution();
//        Object i0 = 4;
        int tribonacci = solution.tribonacci(0);

        System.out.println(tribonacci);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tribonacci(int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1 || n == 2) {
                return 1;
            }
            int[] dp = new int[n + 1];

            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i < dp.length; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            return dp[dp.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
