package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-02 16:32:50
 * 题目名称: 将一个数字表示成幂的和的方案数
 * 题目类型:
 * 思考:
 */
public class Code2787_waysToExpressAnIntegerAsSumOfPowers {
    public static void main(String[] args) {
        Solution solution = new Code2787_waysToExpressAnIntegerAsSumOfPowers().new Solution();
        int i = solution.numberOfWays(10, 2);
        System.out.println(i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final static int MOD = 1_000_000_007;

        public int numberOfWays(int n, int x) {

            long[][] dp = new long[n + 1][n + 1];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = 1;
                        continue;
                    }
                    dp[i][j] = getValue(dp, i - 1, j) + getValue(dp, i - 1, (int) (j - Math.pow(i, x)));
                    dp[i][j] %= MOD;
                }
            }

//            Utils.printTable(dp);

            return (int) dp[dp.length - 1][dp[0].length - 1];

        }

        private long getValue(long[][] dp, int x, int y) {
            if (x < 0 || y < 0 || x >= dp.length || y >= dp[0].length) {
                return 0;
            }
            return dp[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
