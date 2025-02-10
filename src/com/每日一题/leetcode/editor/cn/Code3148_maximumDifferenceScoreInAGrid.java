package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.List;

/**
 * [每日一题] 2024-08-12 10:36:20
 * 题目名称: 矩阵中的最大得分
 * 题目类型:
 * 思考:
 */


public class Code3148_maximumDifferenceScoreInAGrid {
    public static void main(String[] args) {
        Solution solution = new Code3148_maximumDifferenceScoreInAGrid().new Solution();

        int i = solution.maxScore(Utils.convertStringToList("[[9,5,7,3],[8,9,6,1],[6,7,14,3],[2,5,3,1]]"));
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxScore(List<List<Integer>> grid) {
            int[][] minDp = new int[grid.size()][grid.get(0).size()];
            int[][] value = new int[grid.size()][grid.get(0).size()];

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < minDp.length; i++) {
                for (int j = 0; j < minDp[0].length; j++) {

                    if (i == 0 && j == 0) {
                        minDp[i][j] = grid.get(i).get(j);
                        value[i][j] = 0;
                        continue;
                    }


                    minDp[i][j] = Math.min(getValue(minDp, i - 1, j), getValue(minDp, i, j - 1));

                    value[i][j] = grid.get(i).get(j) - minDp[i][j];

                    minDp[i][j] = Math.min(minDp[i][j], grid.get(i).get(j));

                    max = Math.max(max, value[i][j]);
                }
            }

//            Utils.printTable(minDp);
//            System.out.println();
//            Utils.printTable(value);

            return max;
        }

        private int getValue(int[][] matrix, int x, int y) {
            if (x < 0 || y < 0) {
                return Integer.MAX_VALUE;
            }

            return matrix[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
