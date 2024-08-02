package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-22 16:26:40
 * 题目名称: 买卖股票的最佳时机含手续费
 * 题目类型:
 * 思考:
 */
public class Code714_bestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        Solution solution = new Code714_bestTimeToBuyAndSellStockWithTransactionFee().new Solution();

        int[] prices = {1, 3, 2, 8, 4, 9};
        int i = solution.maxProfit(prices, 2);

        System.out.println(i);

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices, int fee) {

            int[][] dp = new int[prices.length][2];


            // 0: 卖出
            // 1: 买入
            for (int i = 0; i < dp.length; i++) {
                if (i == 0) {
                    dp[0][0] = 0;
                    dp[0][1] = -prices[0];
                    continue;
                }
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }


//            Utils.printTable(dp);
            return dp[dp.length - 1][0];


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
