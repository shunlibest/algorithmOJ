package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * [每日一题] 2024-09-10 09:58:38
 * 题目名称: 螺旋矩阵
 * 题目类型:
 * 思考:
 */


public class Code54_spiralMatrix {
    public static void main(String[] args) {
        Solution solution = new Code54_spiralMatrix().new Solution();
        int[][] i0 = Utils.convertStringTo2DArray("[[1,2],[3,4]]");
        List<Integer> integers = solution.spiralOrder(i0);

        Utils.printTable(integers);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {


//            int round = 0;
            List<Integer> result = new ArrayList<>();
//
//            if (matrix.length == 1) {
//                for (int i : matrix[0]) {
//                    result.add(i);
//                }
//                return result;
//            }
//
//            if (matrix[0].length == 1) {
//                for (int[] i : matrix) {
//                    result.add(i[0]);
//                }
//                return result;
//            }


            int maxRound = (Math.min(matrix.length, matrix[0].length) + 2) / 2;

            for (int round = 0; round < maxRound; round++) {
                for (int i = round; i < matrix[0].length - round - 1; i++) {
                    result.add(matrix[round][i]);
                }
                for (int i = round; i < matrix.length - round - 1; i++) {
                    result.add(matrix[i][matrix[0].length - round - 1]);
                }
                for (int i = matrix[0].length - round - 1; i >= round + 1; i--) {
                    result.add(matrix[matrix.length - round - 1][i]);
                }
                for (int i = matrix.length - round - 1; i >= round + 1; i--) {
                    result.add(matrix[i][round]);
                }
            }

            if (matrix.length == matrix[0].length && matrix.length % 2 == 1) {
                result.add(matrix[matrix.length / 2][matrix[0].length / 2]);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
