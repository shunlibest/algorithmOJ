package com.每日一题.leetcode.editor.cn;

import com.Utils;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * [每日一题] 2024-10-18 11:44:13
 * 题目名称: 腐烂的橘子
 * 题目类型:
 * 思考:
 */


public class Code994_rottingOranges {
    public static void main(String[] args) {
        Solution solution = new Code994_rottingOranges().new Solution();
//        int[][] i0 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] i0 = {{0}};
        int i = solution.orangesRotting(i0);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orangesRotting(int[][] grid) {

            int[][] visited = new int[grid.length][grid[0].length];

            Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        queue.add(new Pair<>(i, j));
                        visited[i][j] = 1;
                    }
                }
            }

            while (!queue.isEmpty()) {
                Pair<Integer, Integer> poll = queue.poll();
                int x = poll.getKey();
                int y = poll.getValue();
                addRound(queue, grid, visited, x, y, visited[x][y]);
            }

//            Utils.printTable(visited);
            int result = 1;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) {
                        continue;
                    }

                    if (visited[i][j] == 0) {
                        return -1;
                    }
                    result = Math.max(result, visited[i][j]);
                }
            }

            return result - 1;
        }

        private void addRound(Queue<Pair<Integer, Integer>> queue, int[][] grid, int[][] visited, int x, int y, int num) {
            for (int i = 0; i < 2; i++) {
                for (int j = -1; j <= 1; j++) {
                    int xx, yy;
                    if (i == 0) {
                        xx = x + j;
                        yy = y;
                    } else {
                        xx = x;
                        yy = y + j;
                    }
                    if (getValue(grid, xx, yy) == 1 && visited[xx][yy] == 0) {
                        queue.add(new Pair<>(xx, yy));
                        visited[xx][yy] = num + 1;
                    }
                }
            }
        }

        int getValue(int[][] matrix, int x, int y) {
            if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
                return 0;
            }
            return matrix[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
