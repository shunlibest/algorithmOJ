package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-01 16:29:50
 * 题目名称: 地下城游戏
 * 题目类型:
 * 思考:
 */
public class Code174_dungeonGame {
    public static void main(String[] args) {
        Solution solution = new Code174_dungeonGame().new Solution();

        int i = solution.calculateMinimumHP(Utils.convertStringTo2DArray("[[1,-3,3],[0,-2,0],[-3,-3,-3]]"));

        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            int[][] dp = new int[dungeon.length][dungeon[0].length];
            int[][] minDp = new int[dungeon.length][dungeon[0].length];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = dungeon[0][0];
                        minDp[0][0] = dungeon[0][0];
                        continue;
                    }

                    if (getValue(minDp, i - 1, j) > getValue(minDp, i, j - 1)) {
                        dp[i][j] = dp[i - 1][j] + dungeon[i][j];
                        minDp[i][j] = Math.min(minDp[i - 1][j], dp[i][j]);

                    } else {
                        dp[i][j] = dp[i][j - 1] + dungeon[i][j];
                        minDp[i][j] = Math.min(minDp[i][j - 1], dp[i][j]);
                    }
                }
            }

            Utils.print2DArray(dp);
            System.out.println();
            Utils.print2DArray(minDp);

            if (minDp[minDp.length - 1][minDp[0].length - 1] >= 1){
                return 1;
            }

            return -minDp[minDp.length - 1][minDp[0].length - 1] + 1;

        }

        private int getValue(int[][] dp, int x, int y) {
            if (x < 0 || y < 0 || x >= dp.length || y >= dp[0].length) {
                return Integer.MIN_VALUE;
            }
            return dp[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
