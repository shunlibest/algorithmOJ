package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2025-02-07 10:27:48
 * 题目名称: 螺旋矩阵 II
 * 题目类型:
 * 思考:
 */


public class Code59_spiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new Code59_spiralMatrixIi().new Solution();
        Object i0 = 3;
        int[][] ints = solution.generateMatrix(1);
        Utils.printTable(ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {

            int[][] res = new int[n][n];

            int top = 0;
            int bottom = n - 1;
            int left = 0;
            int right = n - 1;

            int count = 1;

            while (top <= bottom && left <= right) {

                // 1: 从左到右
                for (int i = left; i <= right; i++) {
                    res[top][i] = count;
                    count++;
                }
                top++;

                // 2: 从上到下
                for (int i = top; i <= bottom; i++) {
                    res[i][right] = count;
                    count++;
                }
                right--;

                // 3: 从右到左
                for (int i = right; i >= left ; i--) {
                    res[bottom][i] = count;
                    count++;
                }
                bottom--;

                // 4: 从下到上
                for (int i = bottom; i >= top ; i--) {
                    res[i][left] = count;
                    count++;
                }
                left++;
            }


            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
