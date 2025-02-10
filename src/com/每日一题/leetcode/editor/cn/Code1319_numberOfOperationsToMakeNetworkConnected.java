package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * [每日一题] 2024-08-26 13:55:22
 * 题目名称: 连通网络的操作次数
 * 题目类型:
 * 思考:
 */


public class Code1319_numberOfOperationsToMakeNetworkConnected {
    public static void main(String[] args) {
        Solution solution = new Code1319_numberOfOperationsToMakeNetworkConnected().new Solution();
        Object i0 = 4;
        Object i1 = 6;
        Object i2 = 6;
        int i = solution.makeConnected(4, Utils.convertStringTo2DArray("[[0,1],[0,2],[1,2]]"));
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int makeConnected(int n, int[][] connections) {

            List<List<Integer>> edges = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                edges.add(i, new ArrayList<>());
            }

            for (int[] connection : connections) {
                edges.get(connection[0]).add(connection[1]);
                edges.get(connection[1]).add(connection[0]);
            }

            boolean[] visited = new boolean[n];

            int isLandCount = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                isLandCount++;
                visited[i] = true;

                dfs(edges, i, visited);
            }

//            System.out.println(isLandCount);


            // 线材数量
            int lineNum = connections.length;

//            System.out.println("线材数量:" + lineNum);
//            System.out.println("节点数量:" + n);

            if (lineNum < n - 1) {
                return -1;
            }


            return isLandCount - 1;
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
