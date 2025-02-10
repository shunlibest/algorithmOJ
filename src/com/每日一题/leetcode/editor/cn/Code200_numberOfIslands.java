package com.每日一题.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * [每日一题] 2024-10-17 17:17:19
 * 题目名称: 岛屿数量
 * 题目类型:
 * 思考:
 */


public class Code200_numberOfIslands {
    public static void main(String[] args) {
        Solution solution = new Code200_numberOfIslands().new Solution();
        char[][] i0 = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        int i = solution.numIslands(i0);

        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {

            boolean[][] visited = new boolean[grid.length][grid[0].length];

//            List<List<Integer>> mapList = new ArrayList<>();

//            for (int i = 0; i < grid.length; i++) {
//                List<Integer> arrived = new ArrayList<>();
//                for (int j = 0; j < grid[0].length; j++) {
//                    if (grid[i][j] == '1') {
//                        arrived.add(j);
//                    }
//                }
//                mapList.add(arrived);
//            }
            int size = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (visited[i][j] || grid[i][j] == '0') {
                        continue;
                    }
                    size++;
                    bfs(grid, visited, i, j);
                }

            }
            return size;
        }

        private void bfs(char[][] grid, boolean[][] visited, int x, int y) {
            Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();

            visited[x][y] = true;
            addRound(queue, grid, visited, x, y);

            while (!queue.isEmpty()) {
                Pair<Integer, Integer> poll = queue.poll();
                int xx = poll.getKey();
                int yy = poll.getValue();
                if (visited[xx][yy]) {
                    continue;
                }
                visited[xx][yy] = true;
                addRound(queue, grid, visited, xx, yy);
            }
        }

        private void addRound(Queue<Pair<Integer, Integer>> queue, char[][] grid, boolean[][] visited, int x, int y) {

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
                    if (getValue(grid, xx, yy) == '1' && !visited[xx][yy]) {
                        queue.add(new Pair<>(xx, yy));
                    }
                }
            }
        }

        char getValue(char[][] matrix, int x, int y) {
            if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
                return '0';
            }
            return matrix[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
