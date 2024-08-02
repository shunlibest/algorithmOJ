package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-09 16:10:50
 * 题目名称: 完全平方数
 * 题目类型:
 * 思考:
 */
public class Code279_perfectSquares {
    public static void main(String[] args) {
        Solution solution = new Code279_perfectSquares().new Solution();
        int i = solution.numSquares(10000);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {

            int sqrt = (int) Math.sqrt(n);

            int[][] dp = new int[sqrt + 1][n + 1];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = 0;
                        continue;
                    }
                    if (i == 0) {
                        dp[i][j] = Integer.MAX_VALUE;
                        continue;
                    }

                    if (j == 0) {
                        dp[i][j] = 0;
                        continue;
                    }

                    dp[i][j] = Integer.MAX_VALUE;

                    int pow = i * i;

                    int count = getValue(dp, i, j - pow);
                    if (count != Integer.MAX_VALUE) {
                        count += 1;
                    }

                    dp[i][j] = Math.min(dp[i - 1][j], count);
                }
            }

//            Utils.printTable(dp);
            return dp[dp.length - 1][dp[0].length - 1];
        }

        private int getValue(int[][] dp, int x, int y) {
            if (x < 0 || y < 0) {
                return Integer.MAX_VALUE;
            }
            return dp[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
