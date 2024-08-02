package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-17 14:30:42
 * 题目名称: 两个字符串的最小ASCII删除和
 * 题目类型:
 * 思考:
 */
public class Code712_minimumAsciiDeleteSumForTwoStrings {
    public static void main(String[] args) {
        Solution solution = new Code712_minimumAsciiDeleteSumForTwoStrings().new Solution();

        int i = solution.minimumDeleteSum("sea", "eat");
        System.out.println(i);

        int i1 = 'e' + 's';
        System.out.println(i1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDeleteSum(String s1, String s2) {

            int[][] dp = new int[s1.length() + 1][s2.length() + 1];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = 0;
                        continue;
                    }
                    if (i == 0) {
                        dp[i][j] = dp[i][j - 1] + s2.charAt(j - 1);
                        continue;
                    }

                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + s1.charAt(i - 1);
                        continue;
                    }


                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                    }


                }
            }

//            Utils.printTable(dp);


            return dp[dp.length - 1][dp[0].length - 1];


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
