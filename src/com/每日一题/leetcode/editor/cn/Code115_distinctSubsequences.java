package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-17 16:12:09
 * 题目名称: 不同的子序列
 * 题目类型:
 * 思考:
 */
public class Code115_distinctSubsequences {
    public static void main(String[] args) {
        Solution solution = new Code115_distinctSubsequences().new Solution();

        int i = solution.numDistinct("rabbbit", "rabbit");
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinct(String s, String t) {

            int[][] dp = new int[s.length() + 1][t.length() + 1];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = 1;
                        continue;
                    }

                    if (i == 0) {
                        dp[i][j] = 0;
                        continue;
                    }

                    if (j == 0) {
                        dp[i][j] = 1;
                        continue;
                    }

                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }


                }
            }

//            Utils.printTable(dp);
            return dp[dp.length - 1][dp[0].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
