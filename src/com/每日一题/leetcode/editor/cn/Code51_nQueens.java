package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [每日一题] 2025-02-11 14:34:33
 * 题目名称: N 皇后
 * 题目类型:
 * 思考:
 */


public class Code51_nQueens {
    public static void main(String[] args) {
        Solution solution = new Code51_nQueens().new Solution();
        Object i0 = 4;
        List<List<String>> lists = solution.solveNQueens(10);

        Utils.printTable(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {


            char[][] res = new char[n][n];
            for (char[] re : res) {
                Arrays.fill(re, '.');
            }

            int[][] visitedCount = new int[n][n];

            List<List<String>> result = new ArrayList<>();
            reverse(result, res, visitedCount, 0, 0);


            return result;
        }

        void reverse(List<List<String>> result, char[][] matrix, int[][] visitedCount, int queenCount, int lineNum) {
            if (queenCount == matrix.length) {
//                Utils.printTable(matrix);
//                System.out.println();

                List<String> value = new ArrayList<>(matrix.length);

                for (int i = 0; i < matrix.length; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < matrix[0].length; j++) {
                        sb.append(matrix[i][j]);
                    }
                    value.add(sb.toString());
                }
                result.add(value);
                return;
            }


//            for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visitedCount[lineNum][j] != 0) {
                    continue;
                }

                for (int k = 0; k < matrix.length; k++) {
                    visitedCount[k][j]++;
                }

                for (int k = 0; k < matrix.length; k++) {
                    visitedCount[lineNum][k]++;
                }

                for (int k = -matrix.length; k < matrix.length; k++) {
                    if (checkValid(lineNum + k, matrix.length) && checkValid(j + k, matrix.length)) {
                        visitedCount[lineNum + k][j + k]++;
                    }
                }

                for (int k = -matrix.length; k < matrix.length; k++) {
                    if (checkValid(lineNum + k, matrix.length) && checkValid(j - k, matrix.length)) {
                        visitedCount[lineNum + k][j - k]++;
                    }
                }
                matrix[lineNum][j] = 'Q';
                visitedCount[lineNum][j] = 1;

                // 递归
                reverse(result, matrix, visitedCount, queenCount + 1, lineNum + 1);


                // 回溯: 恢复
                for (int k = 0; k < matrix.length; k++) {
                    visitedCount[k][j]--;
                }

                for (int k = 0; k < matrix.length; k++) {
                    visitedCount[lineNum][k]--;
                }

                for (int k = -matrix.length; k < matrix.length; k++) {
                    if (checkValid(lineNum + k, matrix.length) && checkValid(j + k, matrix.length)) {
                        visitedCount[lineNum + k][j + k]--;
                    }
                }

                for (int k = -matrix.length; k < matrix.length; k++) {
                    if (checkValid(lineNum + k, matrix.length) && checkValid(j - k, matrix.length)) {
                        visitedCount[lineNum + k][j - k]--;
                    }
                }
                matrix[lineNum][j] = '.';
                visitedCount[lineNum][j] = 0;

//                    Utils.printTable(visitedCount);
            }
        }

        private boolean checkValid(int num, int max) {
            return num >= 0 && num < max;
        }
    }



//leetcode submit region end(Prohibit modification and deletion)

}
