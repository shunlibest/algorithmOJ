package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-08-12 14:20:24
 * 题目名称: 最长回文子序列
 * 题目类型:
 * 思考:
 */


public class Code516_longestPalindromicSubsequence {
    public static void main(String[] args) {
        Solution solution = new Code516_longestPalindromicSubsequence().new Solution();
        Object i0 = "bbbab";
        int bbbb = solution.longestPalindromeSubseq("bbbab");
        System.out.println(bbbb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindromeSubseq(String s) {
//            if (s.length() == 1) {
//                return 1;
//            }

            int[][] dp = new int[s.length()][s.length()];

            // dp[i][j] 代表 i-j 的最长回文序列长度

            // dp[i][j] =
            //         f[i + 1][j - 1] + 2
            // dp[i][j] =

            for (int i = dp.length - 1; i >= 0; i--) {
                for (int j = i; j < dp[0].length; j++) {
                    if (i == j) {
                        dp[i][j] = 1;
                        continue;
                    }

                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {

                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }


//            Utils.printTable(dp);
            return dp[0][dp.length - 1];
        }

//        private boolean isReverse(String s) {
////            System.out.println(s);
//
//            for (int i = 0; i < s.length() / 2; i++) {
//                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
//                    return false;
//                }
//            }
//            return true;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
