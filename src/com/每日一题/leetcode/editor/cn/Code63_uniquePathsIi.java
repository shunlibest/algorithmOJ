package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-06-28 16:56:34
 * 题目名称: 不同路径 II
 * 题目类型:
 * 思考:
 */
public class Code63_uniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new Code63_uniquePathsIi().new Solution();
        int i = solution.uniquePathsWithObstacles(Utils.convertStringTo2DArray("[[0,0,0],[0,1,0],[0,0,0]]"));
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];


            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        if (i == 0 && j == 0) {
                            dp[i][j] = 1;
                            continue;
                        }
                        dp[i][j] = getValue(dp, i - 1, j) + getValue(dp, i, j - 1);
                    }
                }
            }

//            Utils.print2DArray(dp);

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
