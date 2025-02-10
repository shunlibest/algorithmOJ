package com.每日一题.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * [每日一题] 2024-08-13 16:54:22
 * 题目名称: 所有可能的路径
 * 题目类型:
 * 思考:
 */


public class Code797_allPathsFromSourceToTarget {
    public static void main(String[] args) {
        Solution solution = new Code797_allPathsFromSourceToTarget().new Solution();
        int[][] i0 = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> lists = solution.allPathsSourceTarget(i0);


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 深度优先遍历
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            boolean[] visited = new boolean[graph.length];

            List<List<Integer>> res = new ArrayList<>();
            List<Integer> currentLine = new ArrayList<>();
            currentLine.add(0);
            dfs(graph, visited, res, currentLine, 0);

            return res;
        }


        /* 深度优先遍历辅助函数 */
        void dfs(int[][] graph, boolean[] visited, List<List<Integer>> res, List<Integer> currentLine, int currentVert) {


//            visited[currentVert] = true; // 标记该顶点已被访问

            // 结束递归
            if (currentVert == graph.length - 1) {
                res.add(new ArrayList<>(currentLine));
//                System.out.println(currentVert);
                return;
            }

            // 进行操作
            // 操作完成

            // 遍历该顶点的所有邻接顶点
            for (int nextVert : graph[currentVert]) {
//                if (visited[nextVert]) {
//                    // 已经访问过的, 不能再进行访问
//                    continue;
//                }
//                // 递归访问邻接顶点
                currentLine.add(nextVert);
                dfs(graph, visited, res, currentLine, nextVert);
                currentLine.remove(currentLine.size() - 1);
            }
        }

//            public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //
//            boolean[] visited = new boolean[graph.length];
////            int[] visitCount = new int[graph.length];
//
//
//            List<List<Integer>> res = new ArrayList<>();
//
//            Queue<Integer> queue = new LinkedList<>();
//            // 找到起始点
//            queue.add(0);
////
//
//            // 开始进行遍历
//            while (!queue.isEmpty()) {
//                int currentVert = queue.poll();
//                // 取出第一个节点进行遍历
//                // 做一些操作
//                for (int next : graph[currentVert]) {
//                    visitCount[next] += visitCount[currentVert];
//                }
//
//                // 操作完成
//                // 开始遍历下一个元素
//                for (int next : graph[currentVert]) {
//                    if (visited[next]) {
//                        continue;
//                    }
//                    queue.add(next);
//                    visited[next] = true;
//                }
//            }

//            return v
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
