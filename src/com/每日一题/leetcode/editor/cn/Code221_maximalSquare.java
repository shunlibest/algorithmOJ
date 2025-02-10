package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-08-12 10:54:17
 * 题目名称: 最大正方形
 * 题目类型:
 * 思考:
 */


public class Code221_maximalSquare {
    public static void main(String[] args) {
        Solution solution = new Code221_maximalSquare().new Solution();
        char[][] characters = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int i = solution.maximalSquare(characters);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int[][] dp = new int[matrix.length][matrix[0].length];
            int[][] left = new int[matrix.length][matrix[0].length];
            int[][] top = new int[matrix.length][matrix[0].length];


            int max = 0;
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {


                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                        left[i][j] = 0;
                        top[i][j] = 0;
                    } else {
                        if (i == 0 || j == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = min(dp[i - 1][j - 1], left[i][j - 1], top[i - 1][j]) + 1;
                        }

                        if (j == 0) {
                            left[i][j] = 1;
                        } else {
                            left[i][j] = left[i][j - 1] + 1;
                        }

                        if (i == 0) {
                            top[i][j] = 1;
                        } else {
                            top[i][j] = top[i - 1][j] + 1;
                        }
                    }

                    max = Math.max(max, dp[i][j]);
                }
            }

//            Utils.printTable(dp);
//
//            Utils.printTable(left);
//
//            Utils.printTable(top);

            return max * max;
        }

        private int min(int x, int y, int z) {
            return Math.min(x, Math.min(y, z));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
