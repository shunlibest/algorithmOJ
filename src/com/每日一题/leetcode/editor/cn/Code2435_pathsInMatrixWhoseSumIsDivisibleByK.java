package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * [每日一题] 2024-07-01 15:23:25
 * 题目名称: 矩阵中和能被 K 整除的路径
 * 题目类型:
 * 思考:
 */
public class Code2435_pathsInMatrixWhoseSumIsDivisibleByK {
    public static void main(String[] args) {
        Solution solution = new Code2435_pathsInMatrixWhoseSumIsDivisibleByK().new Solution();
        int[][] array = Utils.convertStringTo2DArray("[[7,3,4,9],[2,3,6,2],[2,3,7,0]]");
        int i = solution.numberOfPaths(array, 1);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int MOD = 1_000_000_007;

        public int numberOfPaths(int[][] grid, int k) {
            long[][][] dp = new long[grid.length][grid[0].length][k];


            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0][grid[i][j] % k] = 1;
                        continue;
                    }

                    if (i > 0) {
                        for (int l = 0; l < dp[i - 1][j].length; l++) {
                            int index = (l + grid[i][j]) % k;
                            dp[i][j][index] += dp[i - 1][j][l];
                            dp[i][j][index] %= MOD;
                        }
                    }
                    if (j > 0) {
                        for (int l = 0; l < dp[i][j - 1].length; l++) {
                            int index = (l + grid[i][j]) % k;
                            dp[i][j][index] += dp[i][j - 1][l];
                            dp[i][j][index] %= MOD;
                        }
                    }
                }
            }
//
//            for (int i = 0; i < dp.length; i++) {
//                for (int j = 0; j < dp[0].length; j++) {
//
//                    System.out.print(dp[i][j][0] + ",");
//
//                }
//
//                System.out.println();
//            }

            return (int) dp[grid.length - 1][grid[0].length - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
