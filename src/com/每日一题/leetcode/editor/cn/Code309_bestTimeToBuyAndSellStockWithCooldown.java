package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.Arrays;

/**
 * [每日一题] 2024-07-22 16:08:46
 * 题目名称: 买卖股票的最佳时机含冷冻期
 * 题目类型:
 * 思考:
 */
public class Code309_bestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new Code309_bestTimeToBuyAndSellStockWithCooldown().new Solution();

        int[] array = {2, 6, 8, 7, 8, 7, 9, 4, 1, 2, 4, 5, 8};
        int i = solution.maxProfit(array);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][3];

            // 0: 要卖入股票了
            // 1: 卖出
            // 2: 冷静期


            for (int i = 0; i < dp.length; i++) {
                if (i == 0) {
                    dp[0][0] = -prices[0];
                    dp[0][1] = 0;
                    dp[0][2] = 0;
                    continue;
                }

                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
            }

//            Utils.printTable(dp);

            return dp[dp.length - 1][1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
