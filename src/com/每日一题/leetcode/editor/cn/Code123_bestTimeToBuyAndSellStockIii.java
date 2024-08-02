package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.Arrays;

/**
 * [每日一题] 2024-07-22 14:51:09
 * 题目名称: 买卖股票的最佳时机 III
 * 题目类型:
 * 思考:
 */
public class Code123_bestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new Code123_bestTimeToBuyAndSellStockIii().new Solution();

        int[] array = {1, 2, 3, 4, 5};
        int i = solution.maxProfit(array);
        System.out.println(i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {

            int[][] dp = new int[prices.length][4];

            // 0: 第一次买入
            // 1: 第一次卖出
            // 2: 第二次买入
            // 3: 第二次卖出


            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], Integer.MIN_VALUE);
                if (i == 0) {
                    dp[0][0] = -prices[0];
                    dp[0][1] = 0;
                    dp[0][2] = -prices[0];
                    dp[0][3] = 0;
                    continue;
                }

                dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);

            }

//            Utils.printTable(dp);

            return Math.max(dp[dp.length - 1][1], dp[dp.length - 1][3]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
