package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-27 11:28:43
 * 题目名称: 统计放置房子的方式数
 * 题目类型:
 * 思考:
 */
public class Code2320_countNumberOfWaysToPlaceHouses {
    public static void main(String[] args) {
        Solution solution = new Code2320_countNumberOfWaysToPlaceHouses().new Solution();

        int i = solution.countHousePlacements(1000);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        final int MOD = 1_000_000_007;

        public int countHousePlacements(int n) {
            long[][] dp = new long[n][4];
            dp[0][0] = 1;
            dp[0][1] = 1;
            dp[0][2] = 1;
            dp[0][3] = 1;

            // 0: 都不放
            // 1: 放上
            // 2: 放下
            // 3: 都放
            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % MOD;
                dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
                dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
                dp[i][3] = (dp[i - 1][0]) % MOD;
            }
            long sum = 0;
            for (int i = 0; i < 4; i++) {
                sum = (sum + dp[dp.length - 1][i]) % MOD;
            }
            return (int) sum;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
