package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-03 17:40:05
 * 题目名称: 零钱兑换
 * 题目类型:
 * 思考:
 */
public class Code322_coinChange {
    public static void main(String[] args) {
        Solution solution = new Code322_coinChange().new Solution();
        int[] coins = {1, 2, 5};
        int i = solution.coinChange(coins, 11);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] coinsSelect = new int[coins.length + 1];
            System.arraycopy(coins, 0, coinsSelect, 1, coins.length);


            int[][] dp = new int[coins.length + 1][amount + 1];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = 0;
                        continue;
                    }
                    if (i == 0) {
                        dp[i][j] = -1;
                        continue;
                    }

                    if (j == 0) {
                        dp[i][j] = 0;
                        continue;
                    }

                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; j - coinsSelect[i] * k >= 0; k++) {
                        int count = getValue(dp, i - 1, j - coinsSelect[i] * k);
                        if (count >= 0) {
                            dp[i][j] = Math.min(dp[i][j], count + k);
                        }
                    }
                    if (dp[i][j] == Integer.MAX_VALUE) {
                        dp[i][j] = -1;
                    }
                }
            }

//            Utils.printTable(dp);
            return dp[dp.length - 1][dp[0].length - 1];
        }

        private int getValue(int[][] dp, int x, int y) {
            if (x < 0 || y < 0) {
                return -1;
            }
            return dp[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
