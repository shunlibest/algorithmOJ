package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-01 10:18:25
 * 题目名称: 下降路径最小和  II
 * 题目类型:
 * 思考:
 */
public class Code1289_minimumFallingPathSumIi {
    public static void main(String[] args) {
        Solution solution = new Code1289_minimumFallingPathSumIi().new Solution();

        int i = solution.minFallingPathSum(Utils.convertStringTo2DArray("[[-37,51,-36,34,-22],[82,4,30,14,38],[-68,-52,-92,65,-85],[-49,-3,-77,8,-19],[-60,-71,-21,-62,-73]]"));
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] grid) {
            int[][] dp = new int[grid.length][grid[0].length];

            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;
            for (int i = 0; i < dp[0].length; i++) {
                dp[0][i] = grid[0][i];
                if (minValue > dp[0][i]){
                    minIndex = i;
                    secondMin = minValue;
                    minValue = dp[0][i];
                }else if (dp[0][i] < secondMin){
                    secondMin = dp[0][i];
                }
            }



            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (j == minIndex){
                        dp[i][j] = secondMin + grid[i][j];
                    }else {
                        dp[i][j] = minValue + grid[i][j];
                    }
                }

                minIndex = -1;
                minValue = Integer.MAX_VALUE;
                secondMin = Integer.MAX_VALUE;

                for (int j = 0; j < dp[0].length; j++) {
                    if (minValue > dp[i][j]){
                        minIndex = j;
                        secondMin = minValue;
                        minValue = dp[i][j];
                    }else if (dp[i][j] < secondMin){
                        secondMin = dp[i][j];
                    }
                }


//                System.out.println("minValue:"+minValue +",second:"+secondMin);
            }

//            Utils.print2DArray(dp);

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < dp[dp.length - 1].length; i++) {
                min = Math.min(min, dp[dp.length - 1][i]);
            }

            return min;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
