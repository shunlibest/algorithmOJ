package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-17 15:06:06
 * 题目名称: 编辑距离
 * 题目类型:
 * 思考:
 */
public class Code72_editDistance {
    public static void main(String[] args) {
        Solution solution = new Code72_editDistance().new Solution();

        int i = solution.minDistance("horse", "ros");
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {

            int[][] dp = new int[word1.length() + 1][word2.length() + 1];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = 0;
                        continue;
                    }

                    if (i == 0) {
                        dp[i][j] = j;
                        continue;
                    }

                    if (j == 0) {
                        dp[i][j] = i;
                        continue;
                    }

                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                    }

                }
            }
//            Utils.printTable(dp);

            return dp[dp.length - 1][dp[0].length - 1];
        }

        int min(int x, int y, int z) {
            return Math.min(Math.min(x, y), z);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
