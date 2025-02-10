package com.每日一题.leetcode.editor.cn;

import com.Utils;

import javax.rmi.CORBA.Util;

/**
 * [每日一题] 2024-07-19 11:45:06
 * 题目名称: 正则表达式匹配
 * 题目类型:
 * 思考:
 */
public class Code10_regularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new Code10_regularExpressionMatching().new Solution();


        boolean aa = solution.isMatch("ab", ".*");
        System.out.println(aa);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {

            boolean[][] dp = new boolean[s.length()][p.length()];

            if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
                dp[0][0] = true;
            }

            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {


                    char sChar = s.charAt(i);
                    char pChar = p.charAt(j);

                    if (sChar == pChar) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }

                    if (pChar == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j - 1];
                    }

                    if (pChar == '*') {
                        if (sChar == p.charAt(j - 1)) {
                            dp[i][j] = dp[i][j] || dp[i - 1][j - 1];
                        }

                        if (p.charAt(j - 1) == '.') {
                            dp[i][j] = dp[i][j] || dp[i - 1][j - 1];
                        }
                    }
                }
            }
//            Utils.printTable(dp);

            return dp[dp.length - 1][dp[0].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
