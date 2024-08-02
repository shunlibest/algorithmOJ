package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.Arrays;

/**
 * [每日一题] 2024-07-05 10:21:08
 * 题目名称: 修改矩阵
 * 题目类型:
 * 思考:
 */
public class Code3033_modifyTheMatrix {
    public static void main(String[] args) {
        Solution solution = new Code3033_modifyTheMatrix().new Solution();

        int[][] ints = solution.modifiedMatrix(Utils.convertStringTo2DArray("[[3,-1],[5,2]]"));

        Utils.printTable(ints);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] modifiedMatrix(int[][] matrix) {

            int[] maxColum = new int[matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    maxColum[j] = Math.max(maxColum[j], matrix[i][j]);
                }
            }

//            System.out.println(Arrays.toString(maxColum));

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == -1){
                        matrix[i][j] = maxColum[j];
                    }
                }
            }
            return matrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
