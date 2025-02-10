package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-08-07 11:45:12
 * 题目名称: 购买水果需要的最少金币数
 * 题目类型:
 * 思考:
 */
public class Code2944_minimumNumberOfCoinsForFruits {
    public static void main(String[] args) {
        Solution solution = new Code2944_minimumNumberOfCoinsForFruits().new Solution();

        int[] array = {26, 18, 6, 12, 49, 7, 45, 45};
        int i = solution.minimumCoins(array);
        System.out.println(i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumCoins(int[] prices) {
            int[][] dp = new int[prices.length][2];

            dp[0][0] = Integer.MAX_VALUE;
            dp[0][1] = prices[0];
            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = Integer.MAX_VALUE;
                dp[i][1] = Integer.MAX_VALUE;

                // 1 : 购买第i个
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + prices[i];
                // 0: 不购买 赠送的情况
                for (int j = i / 2; j < i; j++) {
                    dp[i][0] = Math.min(dp[i][0], dp[j][1]);
                }
            }

//            Utils.printTable(dp);

            return Math.min(dp[dp.length - 1][0], dp[dp.length - 1][1]);
            //

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
