package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2025-02-11 17:34:33
 * 题目名称: 单词搜索
 * 题目类型:
 * 思考:
 */


public class Code79_wordSearch {
    public static void main(String[] args) {
        Solution solution = new Code79_wordSearch().new Solution();
        char[][] i0 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        Object i1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        Object i2 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean abcced = solution.exist(i0, "ABCCED");
        System.out.println(abcced);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {

            boolean[][] visited = new boolean[board.length][board[0].length];


            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        visited[i][j] = true;
                        boolean reverse = reverse(board, word.toCharArray(), visited, 1, i, j);
                        if (reverse){
                            return true;
                        }
                        visited[i][j] = false;
                    }
                }
            }

            return false;
        }

        private boolean reverse(char[][] board, char[] word, boolean[][] visited, int aimIndex, int currentX, int currentY) {
            if (word.length == aimIndex){
//                System.out.println("x");
                return true;
            }

            int[][] moveIndex = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] index : moveIndex) {
                Character matrixValue = getMatrixValue(board, currentX + index[0], currentY + index[1]);
                if (matrixValue == null || matrixValue != word[aimIndex]) {
                    continue;
                }
                if (visited[currentX + index[0]][currentY + index[1]]) {
                    continue;
                }

                // 递归进入
                visited[currentX + index[0]][currentY + index[1]] = true;
                boolean reverse = reverse(board, word, visited, aimIndex + 1, currentX + index[0], currentY + index[1]);
                if (reverse){
                    return true;
                }

                // 回溯出来
                visited[currentX + index[0]][currentY + index[1]] = false;


            }

            return false;

        }

        private Character getMatrixValue(char[][] board, int x, int y) {
            if (x < 0 || y < 0) {
                return null;
            }
            if (x >= board.length || y >= board[0].length) {
                return null;
            }
            return board[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
