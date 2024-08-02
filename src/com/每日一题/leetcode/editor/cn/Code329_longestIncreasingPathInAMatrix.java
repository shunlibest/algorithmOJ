package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * [每日一题] 2024-07-01 17:10:27
 * 题目名称: 矩阵中的最长递增路径
 * 题目类型:
 * 思考:
 */
public class Code329_longestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new Code329_longestIncreasingPathInAMatrix().new Solution();

        int i = solution.longestIncreasingPath(Utils.convertStringTo2DArray("[[1]]"));

        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestIncreasingPath(int[][] matrix) {
            List<Item> list = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    list.add(new Item(matrix[i][j], i, j));
                }
            }

            list.sort(Comparator.comparingInt(o -> o.value));

            int[][] dp = new int[matrix.length][matrix[0].length];

            int max = Integer.MIN_VALUE;
            for (Item item : list) {
                int top = getValue(matrix, item.i - 1, item.j, dp, item.value);
                int bottom = getValue(matrix, item.i + 1, item.j, dp, item.value);
                int left = getValue(matrix, item.i, item.j - 1, dp, item.value);
                int right = getValue(matrix, item.i, item.j + 1, dp, item.value);

                dp[item.i][item.j] = max(top, bottom, left, right) + 1;

//                        System.out.println(item.value);
                max = Math.max(max, dp[item.i][item.j]);
            }

//            Utils.print2DArray(dp);

            return max;
        }

        private int getValue(int[][] matrix, int x, int y, int[][] dp, int atLeast) {
            if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
                return 0;
            }
            if (matrix[x][y] < atLeast) {
                return dp[x][y];
            }

            return 0;
        }

        private int max(int a, int b, int c, int d) {
            return Math.max(Math.max(a, b), Math.max(c, d));
        }
        private class Item {
            public int value;
            public int i;
            public int j;

            public Item(int value, int i, int j) {
                this.value = value;
                this.i = i;
                this.j = j;
            }
        }
    }




//leetcode submit region end(Prohibit modification and deletion)

}
