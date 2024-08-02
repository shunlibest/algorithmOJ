package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-06-28 17:04:41
 * 题目名称: 最小路径和
 * 题目类型:
 * 思考:
 */
public class Code64_minimumPathSum {
    public static void main(String[] args) {
        Solution solution = new Code64_minimumPathSum().new Solution();
        int i = solution.minPathSum(Utils.convertStringTo2DArray("[[1,2,3],[4,5,6]]"));
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {

            int[][] dp = new int[grid.length][grid[0].length];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = grid[i][j];
                    } else {
                        dp[i][j] = Math.min(getValue(dp, i - 1, j), getValue(dp, i, j - 1)) + grid[i][j];
                    }
                }
            }

//            Utils.print2DArray(dp);

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
