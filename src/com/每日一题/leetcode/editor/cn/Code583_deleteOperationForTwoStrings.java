package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-17 14:14:15
 * 题目名称: 两个字符串的删除操作
 * 题目类型:
 * 思考:
 */
public class Code583_deleteOperationForTwoStrings {
    public static void main(String[] args) {
        Solution solution = new Code583_deleteOperationForTwoStrings().new Solution();

        int i = solution.minDistance("sea", "eat");
        System.out.println(i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];


            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 || j == 0) {
                        dp[0][0] = 0;
                        continue;
                    }
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

//            Utils.printTable(dp);

            return word1.length() + word2.length() - dp[dp.length - 1][dp[0].length - 1] * 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
