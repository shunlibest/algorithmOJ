package com.每日一题.leetcode.editor.cn;

import java.util.Arrays;

/**
 * [每日一题] 2024-06-26 17:34:06
 * 题目名称: 统计构造好字符串的方案数
 * 题目类型:
 * 思考:
 */
public class Code2466_countWaysToBuildGoodStrings {
    public static void main(String[] args) {
        Solution solution = new Code2466_countWaysToBuildGoodStrings().new Solution();
        int i = solution.countGoodStrings(500, 500, 5, 2);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countGoodStrings(int low, int high, int zero, int one) {
            int[] dp = new int[high + 1];
            dp[0] = 1;
            for (int i = 1; i < dp.length; i++) {
                if (i >= zero) {
                    dp[i] += dp[i - zero];
                    dp[i] %= 1_000_000_007;
                }
                if (i >= one) {
                    dp[i] += dp[i - one];
                    dp[i] %= 1_000_000_007;
                }
            }
            System.out.println(Arrays.toString(dp));
            int count = 0;
            for (int i = low; i < high + 1; i++) {
                count += dp[i];
                count %= 1_000_000_007;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
