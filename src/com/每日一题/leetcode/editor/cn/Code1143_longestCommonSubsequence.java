package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-17 11:39:26
 * 题目名称: 最长公共子序列
 * 题目类型:
 * 思考:
 */
public class Code1143_longestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new Code1143_longestCommonSubsequence().new Solution();

        int i = solution.longestCommonSubsequence("abcde", "ace");
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];


            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 || j == 0) {
                        dp[0][0] = 0;
                        continue;
                    }
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
//            Utils.printTable(dp);

            return dp[dp.length - 1][dp[0].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
