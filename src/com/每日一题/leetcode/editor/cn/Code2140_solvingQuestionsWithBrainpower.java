package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-08-07 16:13:49
 * 题目名称: 解决智力问题
 * 题目类型:
 * 思考:
 */
public class Code2140_solvingQuestionsWithBrainpower {
    public static void main(String[] args) {
        Solution solution = new Code2140_solvingQuestionsWithBrainpower().new Solution();


        long l = solution.mostPoints(Utils.convertStringTo2DArray("[[1,1],[2,2],[3,3],[4,4],[5,5]]"));

        System.out.println(l);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long mostPoints(int[][] questions) {
            int[][] dp = new int[questions.length][2];


            dp[0][0] = 0;
            dp[0][1] = questions[0][0];

            for (int i = 1; i < dp.length; i++) {

                // 0 : 不做当前题目
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                // 1: 做当前题目

//                dp[i][1] =
                int maxValue = 0;
                for (int j = 0; j < i; j++) {
                    if (j + questions[j][1] < i) {
                        maxValue = Math.max(maxValue, dp[j][1]);
                    } else {
//                        maxValue = Math.max(maxValue, dp[j][0]);
                    }
                }
                dp[i][1] = maxValue + questions[i][0];
            }

//            Utils.printTable(dp);

            return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
