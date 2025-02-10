package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-08-12 11:36:06
 * 题目名称: 恰好移动 k 步到达某一位置的方法数目
 * 题目类型:
 * 思考:
 */


public class Code2400_numberOfWaysToReachAPositionAfterExactlyKSteps {
    public static void main(String[] args) {
        Solution solution = new Code2400_numberOfWaysToReachAPositionAfterExactlyKSteps().new Solution();
        Object i0 = 1;
        Object i1 = 3;
        Object i2 = 5;
        int i = solution.numberOfWays(989, 1000, 99);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfWays(int startPos, int endPos, int k) {
            k++;
            int pos = Math.abs(endPos - startPos);
            long[][] dp = new long[pos + 2 * k + 10][k];


            dp[k][0] = 1;

            int MOD = 1_000_000_007;

            // dp[i][j] =
            for (int i = 1; i < k; i++) {
                for (int j = -i; j <= i; j++) {
                    dp[j + k][i] = dp[j - 1 + k][i - 1] + dp[j + 1 + k][i - 1];

                    dp[j + k][i] %= MOD;
                }
            }
//            Utils.printTable(dp);
            return (int) (dp[pos + k][k - 1] % MOD);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
