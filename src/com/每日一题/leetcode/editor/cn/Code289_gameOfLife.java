package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-09-03 17:05:59
 * 题目名称: 生命游戏
 * 题目类型:
 * 思考:
 */


public class Code289_gameOfLife {
    public static void main(String[] args) {
        Solution solution = new Code289_gameOfLife().new Solution();
        int[][] i0 = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        solution.gameOfLife(i0);

        Utils.printTable(i0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void gameOfLife(int[][] board) {
            int[][] newBoard = new int[board.length][board[0].length];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    int cellNum = getRoundCellNum(board, i, j);
                    if (board[i][j] == 1) {
                        // 活细胞
                        if (cellNum < 2) {
                            newBoard[i][j] = 0;
                        }else if (cellNum < 4){
                            newBoard[i][j] = 1;
                        }else {
                            newBoard[i][j] = 0;
                        }
                    }else {
                        if (cellNum == 3) {
                            newBoard[i][j] = 1;
                        }
                    }

                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    board[i][j] = newBoard[i][j];
                }
            }

        }

        private int getRoundCellNum(int[][] matrix, int a, int b) {
            int sum = 0;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    sum += getValue(matrix, a + i, b + j);
                }
            }

            return sum;


        }

        private int getValue(int[][] matrix, int i, int j) {
            if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
                return 0;
            }
            return matrix[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
