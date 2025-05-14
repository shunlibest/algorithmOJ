package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.Arrays;

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
        String baba = solution.longestPalindrome("bb");
        System.out.println(baba);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 1) {
                return s;
            }


            boolean[][] dp = new boolean[s.length()][s.length()];

            char[] chars = s.toCharArray();


            int maxLength = 0;

            // 以 i 开头 j 结尾的字符串, 是否为回文字符串
            for (int j = 0; j < dp[0].length; j++) {
                for (int i = 0; i <= j; i++) {
                    // 从 i -> j 的回文条件是: chars[i] == chars[j] && chars[i+1] == chars[j-1]
                    if (i == j) {
                        dp[i][j] = true;
                        continue;
                    }
                    if (chars[i] == chars[j]) {
                        dp[i][j] = dp[i + 1][j - 1] || i + 1 == j;
                    }

                    if (dp[i][j]) {
                        maxLength = Math.max(maxLength, j - i);
                    }
                }
            }
//            Utils.printTable(dp);
//            System.out.println("max:" + maxLength);

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (dp[i][j] && j - i == maxLength) {
                        return s.substring(i, i + maxLength + 1);
                    }

                }
            }

//


            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
