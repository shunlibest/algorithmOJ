package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-07-22 14:45:51
 * 题目名称: 买卖股票的最佳时机 II
 * 题目类型:
 * 思考:
 */
public class Code122_bestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new Code122_bestTimeToBuyAndSellStockIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {


            int[][] dp = new int[prices.length][2];


            for (int i = 0; i < dp.length; i++) {

                if (i == 0) {
                    dp[0][0] = 0;
                    dp[0][1] = -prices[0];
                    continue;
                }
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }

            return dp[dp.length - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
