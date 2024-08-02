package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-28 16:45:44
 * 题目名称: 不同路径
 * 题目类型:
 * 思考:
 */
public class Code62_uniquePaths {
    public static void main(String[] args) {
        Solution solution = new Code62_uniquePaths().new Solution();
        int i = solution.uniquePaths(1, 1);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            dp[0][0] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    dp[i][j] = getValue(dp, i - 1, j) + getValue(dp, i, j - 1);
                }
            }

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
