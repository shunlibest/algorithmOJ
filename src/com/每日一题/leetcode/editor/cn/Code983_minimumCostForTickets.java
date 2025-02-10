package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-08-07 17:10:42
 * 题目名称: 最低票价
 * 题目类型:
 * 思考:
 */
public class Code983_minimumCostForTickets {
    public static void main(String[] args) {
        Solution solution = new Code983_minimumCostForTickets().new Solution();
        int[] days = {1,2,3,4,6,8,9,10,13,14,16,17,19,21,24,26,27,28,29};
        int[] costs = {3,14,50};
        int i = solution.mincostTickets(days, costs);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int[][] dp = new int[days.length][4];

            dp[0][0] = Integer.MAX_VALUE;
            dp[0][1] = costs[0];
            dp[0][2] = costs[1];
            dp[0][3] = costs[2];

            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = Integer.MAX_VALUE;
                // case0: 不购票
                for (int j = i - 1; j >= 0; j--) {
                    if (days[i] - days[j] >= 1) {
                        break;
                    }
                    dp[i][0] = min(dp[i][0], dp[j][1], dp[j][2], dp[j][3]);
//                    dp[i][0] = Math.min(dp[i][0], );
//                    dp[i][0] = Math.min(dp[i][0], dp[j][3]);
                }
                for (int j = i - 1; j >= 0; j--) {
                    if (days[i] - days[j] >= 7) {
                        break;
                    }
                    dp[i][0] = min(dp[i][0], dp[j][2], dp[j][3]);
                }
                for (int j = i - 1; j >= 0; j--) {
                    if (days[i] - days[j] >= 30) {
                        break;
                    }
                    dp[i][0] = Math.min(dp[i][0], dp[j][3]);
                }
                // 购票
                dp[i][1] = min(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2], dp[i - 1][3]) + costs[0];
                dp[i][2] = min(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2], dp[i - 1][3]) + costs[1];
                dp[i][3] = min(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2], dp[i - 1][3]) + costs[2];
            }

//            Utils.printTable(dp);
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < 4; i++) {
                min = Math.min(min, dp[dp.length - 1][i]);
            }
            return min;
        }

        int min(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
        }

        int min(int a, int b, int c, int d) {
            return Math.min(Math.min(a, b), Math.min(c, d));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
