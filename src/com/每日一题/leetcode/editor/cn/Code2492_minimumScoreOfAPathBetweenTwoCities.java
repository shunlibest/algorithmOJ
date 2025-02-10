package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * [每日一题] 2024-08-26 14:33:43
 * 题目名称: 两个城市间路径的最小分数
 * 题目类型:
 * 思考:
 */


public class Code2492_minimumScoreOfAPathBetweenTwoCities {
    public static void main(String[] args) {
        Solution solution = new Code2492_minimumScoreOfAPathBetweenTwoCities().new Solution();
        Object i0 = 4;
        Object i1 = 4;
        int i = solution.minScore(4, Utils.convertStringTo2DArray("[[1,2,9],[2,3,6],[2,4,5],[1,4,7]]"));
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minScore(int n, int[][] roads) {

            List<List<Integer>> edge = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                edge.add(i, new ArrayList<>());
            }

            for (int[] connection : roads) {
                edge.get(connection[0] - 1).add(connection[1] - 1);
                edge.get(connection[1] - 1).add(connection[0] - 1);
            }

            boolean[] visited = new boolean[n];

            dfs(edge, 0, visited);

//            Utils.printTable(visited);

            int res = Integer.MAX_VALUE;
            for (int[] connection : roads) {
                if (visited[connection[0] - 1] || visited[connection[1] - 1]) {
                    res = Math.min(res, connection[2]);
                }

            }


            return res;
        }

        private void dfs(List<List<Integer>> edges, int currentNode, boolean[] visited) {
            for (int nextNode : edges.get(currentNode)) {
                if (visited[nextNode]) {
                    continue;
                }
                visited[nextNode] = true;
                dfs(edges, nextNode, visited);
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
