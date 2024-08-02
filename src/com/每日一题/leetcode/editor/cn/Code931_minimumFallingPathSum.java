package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-06-28 17:32:16
 * 题目名称: 下降路径最小和
 * 题目类型:
 * 思考:
 */
public class Code931_minimumFallingPathSum {
    public static void main(String[] args) {
        Solution solution = new Code931_minimumFallingPathSum().new Solution();
        int i = solution.minFallingPathSum(Utils.convertStringTo2DArray("[[1]]"));
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int[][] dp = new int[matrix.length][matrix[0].length];


            for (int i = 0; i < dp[0].length; i++) {
                dp[0][i] = matrix[0][i];
            }
            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    dp[i][j] = min(getValue(dp, i - 1, j - 1), getValue(dp, i - 1, j), getValue(dp, i - 1, j + 1)) + matrix[i][j];
                }
            }
//            Utils.print2DArray(dp);

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < dp[dp.length - 1].length; i++) {
                min = Math.min(min, dp[dp.length - 1][i]);
            }

            return min;
        }

        private int min(int x, int y, int z) {
            return Math.min(Math.min(x, y), z);
        }

        private int getValue(int[][] dp, int x, int y) {
            if (x < 0 || y < 0 || x >= dp.length || y >= dp[0].length) {
                return Integer.MAX_VALUE;
            }
            return dp[x][y];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
