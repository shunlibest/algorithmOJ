package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-08-13 11:13:31
 * 题目名称: 最长回文子串
 * 题目类型:
 * 思考:
 */


public class Code5_longestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new Code5_longestPalindromicSubstring().new Solution();
        Object i0 = "babad";
        String baba = solution.longestPalindrome("a");
        System.out.println(baba);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 1){
                return s;
            }

            boolean[][] dp = new boolean[s.length()][s.length()];

            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    if (i == j) {
                        dp[i][j] = true;
                        continue;
                    }
                    if (s.charAt(i) == s.charAt(j)) {
                        if (i + 1 == j){
                            dp[i][j] = true;
                        }else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }

            int maxLength = -1;
            String res = "";
            for (int i = 0; i < dp.length; i++) {
                for (int j = i; j < dp[0].length; j++) {
                    if (dp[i][j] && j - i > maxLength) {
                        res = s.substring(i, j + 1);

                        maxLength = j - i;
                    }
                }
            }

//            Utils.printTable(dp);

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
