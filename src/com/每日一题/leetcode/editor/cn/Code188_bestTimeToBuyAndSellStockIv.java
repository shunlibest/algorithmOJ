package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.Arrays;

/**
 * [每日一题] 2024-07-22 15:43:20
 * 题目名称: 买卖股票的最佳时机 IV
 * 题目类型:
 * 思考:
 */
public class Code188_bestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        Solution solution = new Code188_bestTimeToBuyAndSellStockIv().new Solution();

        int[] array = {3, 2, 6, 5, 0, 3};
        int i = solution.maxProfit(2, array);

        System.out.println(i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {


            int[][] dp = new int[prices.length][k * 2];

            // k: 第k次买入
            // k+1: 第k次卖出


            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    int bug = j % 2 == 0 ? -1 : 1;

                    if (i == 0) {
                        dp[i][j] = Math.min(bug * prices[i], 0);
                        continue;
                    }
                    if (j == 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], bug * prices[i]);
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + (bug * prices[i]));
                }
            }

//            Utils.printTable(dp);
            return dp[dp.length - 1][dp[0].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
