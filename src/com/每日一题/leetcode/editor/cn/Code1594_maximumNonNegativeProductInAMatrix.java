package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-01 11:42:38
 * 题目名称: 矩阵的最大非负积
 * 题目类型:
 * 思考:
 */
public class Code1594_maximumNonNegativeProductInAMatrix {
    public static void main(String[] args) {
        Solution solution = new Code1594_maximumNonNegativeProductInAMatrix().new Solution();
        int i = solution.maxProductPath(Utils.convertStringTo2DArray("[[1,3],[0,-4]]"));
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int MOD = 1_000_000_007;

        public int maxProductPath(int[][] grid) {
            long[][] positiveDp = new long[grid.length][grid[0].length];
            long[][] negativeDp = new long[grid.length][grid[0].length];


            for (int i = 0; i < positiveDp.length; i++) {
                for (int j = 0; j < positiveDp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        positiveDp[i][j] = grid[0][0];
                        negativeDp[i][j] = grid[0][0];
                        continue;
                    }

                    if (grid[i][j] > 0) {
                        positiveDp[i][j] = Math.max(getValue(positiveDp, i, j - 1, Integer.MIN_VALUE), getValue(positiveDp, i - 1, j, Integer.MIN_VALUE)) * grid[i][j];
                        negativeDp[i][j] = Math.min(getValue(negativeDp, i, j - 1, Integer.MAX_VALUE), getValue(negativeDp, i - 1, j, Integer.MAX_VALUE)) * grid[i][j];
                    } else if (grid[i][j] < 0) {
                        positiveDp[i][j] = Math.min(getValue(negativeDp, i, j - 1, Integer.MAX_VALUE), getValue(negativeDp, i - 1, j, Integer.MAX_VALUE)) * grid[i][j];
                        negativeDp[i][j] = Math.max(getValue(positiveDp, i, j - 1, Integer.MIN_VALUE), getValue(positiveDp, i - 1, j, Integer.MIN_VALUE)) * grid[i][j];
                    } else {
                        positiveDp[i][j] = 0;
                        negativeDp[i][j] = 0;
                    }
                }
            }

//            Utils.print2DArray(positiveDp);
//            System.out.println();
//            Utils.print2DArray(negativeDp);

            long finalValue = positiveDp[positiveDp.length - 1][positiveDp[0].length - 1] % MOD;
            if (finalValue >= 0) {
                return (int) finalValue;
            } else {
                return -1;
            }
        }

        private long getValue(long[][] dp, int x, int y, int defaultValue) {
            if (x < 0 || y < 0 || x >= dp.length || y >= dp[0].length) {
                return defaultValue;
            }
            return dp[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
