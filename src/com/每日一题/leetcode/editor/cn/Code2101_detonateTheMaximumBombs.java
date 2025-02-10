package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * [每日一题] 2024-07-22 10:19:48
 * 题目名称: 引爆最多的炸弹
 * 题目类型:
 * 思考:
 */
public class Code2101_detonateTheMaximumBombs {
    public static void main(String[] args) {
        Solution solution = new Code2101_detonateTheMaximumBombs().new Solution();

        int i = solution.maximumDetonation(Utils.convertStringTo2DArray("[[1,1,100000],[100000,100000,1]]"));

        System.out.println(i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumDetonation(int[][] bombs) {
            // 建图
            List<List<Integer>> edges = new ArrayList<>(bombs.length);
            for (int i = 0; i < bombs.length; i++) {
                edges.add(i, new ArrayList<>());
            }

            for (int i = 0; i < bombs.length; i++) {
                for (int j = 0; j < bombs.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    long x = bombs[i][0] - bombs[j][0];
                    long y = bombs[i][1] - bombs[j][1];
                    long r = bombs[i][2];

                    if (x * x + y * y > r * r) {
                        continue;
                    }
                    edges.get(i).add(j);
                }
            }

//            Utils.printDrawMap(Utils.convertToAdjacencyMatrix(edges, edges.size()));


//            boolean[] visited = new boolean[bombs.length];

//
            int maxDetonations = 0;
            for (int i = 0; i < edges.size(); i++) {
                boolean[] visited = new boolean[edges.size()];
                visited[i] = true;
                maxDetonations = Math.max(maxDetonations, dfs(edges, i, visited));
            }

            return maxDetonations;
        }

        private int dfs(List<List<Integer>> edges, int currentNode, boolean[] visited) {

//            System.out.println("遍历:" + currentNode);

            int sum = 1;
            for (int nextNode : edges.get(currentNode)) {
                if (visited[nextNode]) {
                    continue;
                }


                visited[nextNode] = true;
                sum += dfs(edges, nextNode, visited);
//                visited[nextNode] = false;
            }

//            System.out.println("回溯");
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
