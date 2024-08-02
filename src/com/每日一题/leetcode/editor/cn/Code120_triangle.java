package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.List;

/**
 * [每日一题] 2024-06-28 17:11:35
 * 题目名称: 三角形最小路径和
 * 题目类型:
 * 思考:
 */
public class Code120_triangle {
    public static void main(String[] args) {
        Solution solution = new Code120_triangle().new Solution();
        int i = solution.minimumTotal(Utils.convertStringToList("[[2],[3,4],[6,5,7],[4,1,8,3]]"));
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];


            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
//                    System.out.println("i:" + i + ",j:" + j);
                    if (i == 0 && j == 0) {
                        dp[0][0] = triangle.get(0).get(0);
                    } else {
                        dp[i][j] = Math.min(getValue(dp, i - 1, j), getValue(dp, i - 1, j - 1)) + triangle.get(i).get(j);
                    }

                    if (j >= i) {
                        break;
                    }

                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < dp[0].length; i++) {
                min = Math.min(min, dp[dp.length - 1][i]);
            }

//            Utils.print2DArray(dp);

            return min;
        }

        private int getValue(int[][] dp, int x, int y) {
            if (y > x) {
                return Integer.MAX_VALUE;
            }

            if (x < 0 || y < 0) {
                return Integer.MAX_VALUE;
            }

            return dp[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
