package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-07-03 15:04:28
 * 题目名称: 盈利计划
 * 题目类型:
 * 思考:
 */
public class Code879_profitableSchemes {
    public static void main(String[] args) {
        Solution solution = new Code879_profitableSchemes().new Solution();

        int n = 100, minProfit = 100;
        int[] group = {2, 5, 36, 2, 5, 5, 14, 1, 12, 1, 14, 15, 1, 1, 27, 13, 6, 59, 6, 1, 7, 1, 2, 7, 6, 1, 6, 1, 3, 1, 2, 11, 3, 39, 21, 20, 1, 27, 26, 22, 11, 17, 3, 2, 4, 5, 6, 18, 4, 14, 1, 1, 1, 3, 12, 9, 7, 3, 16, 5, 1, 19, 4, 8, 6, 3, 2, 7, 3, 5, 12, 6, 15, 2, 11, 12, 12, 21, 5, 1, 13, 2, 29, 38, 10, 17, 1, 14, 1, 62, 7, 1, 14, 6, 4, 16, 6, 4, 32, 48};

        int[] profit = {21, 4, 9, 12, 5, 8, 8, 5, 14, 18, 43, 24, 3, 0, 20, 9, 0, 24, 4, 0, 0, 7, 3, 13, 6, 5, 19, 6, 3, 14, 9, 5, 5, 6, 4, 7, 20, 2, 13, 0, 1, 19, 4, 0, 11, 9, 6, 15, 15, 7, 1, 25, 17, 4, 4, 3, 43, 46, 82, 15, 12, 4, 1, 8, 24, 3, 15, 3, 6, 3, 0, 8, 10, 8, 10, 1, 21, 13, 10, 28, 11, 27, 17, 1, 13, 10, 11, 4, 36, 26, 4, 2, 2, 2, 10, 0, 11, 5, 22, 6};

        int i = solution.profitableSchemes(n, minProfit, group, profit);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int MOD = 1_000_000_007;

        public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

            int profitSum = 0;

            int[] selectGroup = new int[group.length + 1];
            int[] selectProfit = new int[group.length + 1];

            System.arraycopy(group, 0, selectGroup, 1, group.length);
            System.arraycopy(profit, 0, selectProfit, 1, group.length);

            for (int pro : profit) {
                profitSum += pro;
            }

            int[][][] dp = new int[group.length + 1][n + 1][profitSum + 1];

//            int
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    for (int k = 0; k < dp[0][0].length; k++) {
                        if (i == 0 && j == 0 && k == 0) {
                            dp[i][j][k] = 1;
                            continue;
                        }
                        dp[i][j][k] = getValue(dp, i - 1, j, k) + getValue(dp, i - 1, j - selectGroup[i], k - selectProfit[i]);
                        dp[i][j][k] %= MOD;
                    }
                }
            }

            long sum = 0;
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = minProfit; k < dp[0][0].length; k++) {
                    sum += dp[dp.length - 1][j][k];

                    sum %= MOD;
                }
            }

            return (int) sum;
        }


        private int getValue(int[] item, int index) {
            if (index < 0) {
                return 0;
            }

            return item[index];
        }

        private int getValue(int[][][] dp, int x, int y, int z) {
            if (x < 0 || y < 0 || z < 0) {
                return 0;
            }
            return dp[x][y][z];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
