package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-09 16:00:45
 * 题目名称: 零钱兑换 II
 * 题目类型:
 * 思考:
 */
public class Code518_coinChangeIi {
    public static void main(String[] args) {
        Solution solution = new Code518_coinChangeIi().new Solution();

        int[] coins = {1, 2, 5};
        int i = solution.change(5, coins);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int change(int amount, int[] coins) {
            int[] coinsSelect = new int[coins.length + 1];
            System.arraycopy(coins, 0, coinsSelect, 1, coins.length);


            int[][] dp = new int[coins.length + 1][amount + 1];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = 1;
                        continue;
                    }
                    if (i == 0) {
                        continue;
                    }
                    for (int k = 0; j - coinsSelect[i] * k >= 0; k++) {
                        dp[i][j] += getValue(dp, i - 1, j - coinsSelect[i] * k);
                    }
                }
            }

//            Utils.printTable(dp);

            return dp[dp.length - 1][dp[0].length - 1];
        }

        private int getValue(int[][] dp, int x, int y) {
            if (x < 0 || y < 0) {
                return 0;
            }
            return dp[x][y];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
