package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-17 15:40:05
 * 题目名称: 交错字符串
 * 题目类型:
 * 思考:
 */
public class Code97_interleavingString {
    public static void main(String[] args) {
        Solution solution = new Code97_interleavingString().new Solution();

        boolean interleave = solution.isInterleave("db", "b", "cbb");
        System.out.println(interleave);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {

            boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = true;
                        continue;
                    }

                    if (i == 0) {
                        dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                        continue;
                    }

                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                        continue;
                    }

                    if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] = dp[i][j] | dp[i][j - 1];
                    }

                }
            }
//            Utils.printTable(dp);


            return dp[dp.length - 1][dp[0].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
