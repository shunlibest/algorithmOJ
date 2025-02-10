package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * [每日一题] 2024-08-27 17:29:35
 * 题目名称: 图中的最短环
 * 题目类型:
 * 思考:
 */


public class Code2608_shortestCycleInAGraph {
    public static void main(String[] args) {
        Solution solution = new Code2608_shortestCycleInAGraph().new Solution();
        Object i0 = 7;
        Object i1 = 4;

        int shortestCycle = solution.findShortestCycle(4, Utils.convertStringTo2DArray("[[1,2],[0,1],[3,2],[1,3]]"));
        System.out.println(shortestCycle);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findShortestCycle(int n, int[][] edges) {

            // 队列转边
            List<List<Integer>> edgeList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                edgeList.add(i, new ArrayList<>());
            }
            for (int[] connection : edges) {
                edgeList.get(connection[0]).add(connection[1]);
                edgeList.get(connection[1]).add(connection[0]);
            }

//            Utils.printDrawMap(edgeList);

            boolean[] visited = new boolean[n];
            int minLoop = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
//                if (visited[i]) {
//                    continue;
//                }
                int bfs = bfs(edgeList, i, visited);
//                System.out.println(bfs);
                minLoop = Math.min(minLoop, bfs);
            }

            if (minLoop == Integer.MAX_VALUE) {
                return -1;
            }

            return minLoop;

        }

        private int bfs(List<List<Integer>> edge, int start, boolean[] globalVisited) {

            int minLoop = Integer.MAX_VALUE;
            Queue<Data> queue = new ArrayDeque<>();


            boolean[] visited = new boolean[globalVisited.length];
            visited[start] = true;
            globalVisited[start] = true;
            queue.add(new Data(start, 0));

            int[] visitedDeep = new int[globalVisited.length];
            visitedDeep[start] = 0;

            while (!queue.isEmpty()) {
                Data currentNode = queue.poll();

                for (int nextNode : edge.get(currentNode.node)) {
                    if (visited[nextNode]) {
                        int loop = currentNode.deep - visitedDeep[nextNode];

                        if (loop == 1) {
                            continue;
                        }

                        int ll = currentNode.deep + visitedDeep[nextNode] + 1;

                        minLoop = Math.min(minLoop, ll);
                        continue;
                    }
                    visited[nextNode] = true;
                    globalVisited[nextNode] = true;
                    visitedDeep[nextNode] = currentNode.deep + 1;

                    queue.add(new Data(nextNode, currentNode.deep + 1));
                }

            }

            return minLoop;

        }

        private class Data {
            public int node;
            public int deep;

            public Data(int node, int deep) {
                this.node = node;
                this.deep = deep;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
