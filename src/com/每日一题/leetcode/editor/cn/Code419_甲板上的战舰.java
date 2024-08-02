package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-11
 * 题目类型: 二维数组
 * 思考: 刚开始不明白意思. 理解后, 没啥难度, 一次遍历
 */
public class Code419_甲板上的战舰 {
    public static void main(String[] args) {
        Solution solution = new Code419_甲板上的战舰().new Solution();

        char[][] board = new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        int i = solution.countBattleships(board);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBattleships(char[][] board) {
            int sum = 0;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                        sum++;
                    }
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
