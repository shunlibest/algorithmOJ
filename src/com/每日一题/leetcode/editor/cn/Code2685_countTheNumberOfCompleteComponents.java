package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * [每日一题] 2024-08-26 14:49:05
 * 题目名称: 统计完全连通分量的数量
 * 题目类型:
 * 思考:
 */


public class Code2685_countTheNumberOfCompleteComponents {
    public static void main(String[] args) {
        Solution solution = new Code2685_countTheNumberOfCompleteComponents().new Solution();
        Object i0 = 6;
        Object i1 = 6;
        int i = solution.countCompleteComponents(4, Utils.convertStringTo2DArray("[[1,0],[2,0],[2,1],[3,0],[3,1],[3,2]]"));
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countCompleteComponents(int n, int[][] edges) {

            // 队列转边
            List<List<Integer>> edgeList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                edgeList.add(i, new ArrayList<>());
            }
            for (int[] connection : edges) {
                edgeList.get(connection[0]).add(connection[1]);
                edgeList.get(connection[1]).add(connection[0]);
            }

            boolean[] visited = new boolean[n];

            int result = 0;
            // 非联通图
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;

                Data count = dfs(edgeList, i, visited);

                int node = count.node;
                int needEdge = node * (node - 1);

//                System.out.println(needEdge);

//                if ()

                if (needEdge == count.edge || node == 1) {
                    result++;
                }

//                System.out.println(count);
            }

            return result;

        }


        private Data dfs(List<List<Integer>> edges, int currentNode, boolean[] visited) {

            Data result = new Data();
            result.node = 1;
            result.edge = edges.get(currentNode).size();

            for (int nextNode : edges.get(currentNode)) {
                if (visited[nextNode]) {
                    continue;
                }
                visited[nextNode] = true;
                Data data = dfs(edges, nextNode, visited);

                result.node = result.node + data.node;
                result.edge = result.edge + data.edge;

            }

            return result;
        }

        private class Data {
            public int node;
            public int edge;

            @Override
            public String toString() {
                return "节点:" + node + ", 边:" + edge;
            }
        }

        public int circulation(int n) {
            int sum = 1; // 必须是1 乘积不变，这里应该是long型，而不是int型，因为阶乘值可能超过int的范围
            //    for循环 相乘累计和
            for (int i = 1; i <= n; i++) {
                sum *= i;
            }
            return sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
