package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-08-09 16:24:00
 * 题目名称: 多米诺和托米诺平铺
 * 题目类型:
 * 思考:
 */


public class Code790_dominoAndTrominoTiling {
    public static void main(String[] args) {
        Solution solution = new Code790_dominoAndTrominoTiling().new Solution();

        int i = solution.numTilings(4);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTilings(int n) {
            long[][] dp = new long[n][3];

            if (n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            }
            dp[0][0] = 1;
            dp[1][0] = 2;
            dp[1][1] = 1;
            dp[1][2] = 1;
            int MOD = 1_000_000_007;

            for (int i = 2; i < dp.length; i++) {
                // 最后形成1 条不空
                dp[i][0] += dp[i - 1][0];
                dp[i][0] += dp[i - 2][0];

                // 从右下角(:`)空 + 1个 .:
                dp[i][0] += dp[i - 1][1];
                dp[i][0] += dp[i - 1][2];

                dp[i][0] %= MOD;
                // 最后形成 :`
                dp[i][1] += dp[i - 2][0];
                dp[i][1] += dp[i - 1][2];
                dp[i][1] %= MOD;

                // 最后形成 :.
                dp[i][2] += dp[i - 2][0];
                dp[i][2] += dp[i - 1][1];
                dp[i][2] %= MOD;


            }

//            Utils.printTable(dp);
            return (int) (dp[dp.length - 1][0] % MOD);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
