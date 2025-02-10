package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.*;

/**
 * [每日一题] 2024-08-29 10:17:12
 * 题目名称: 网络延迟时间
 * 题目类型:
 * 思考:
 */


public class Code743_networkDelayTime {
    public static void main(String[] args) {
        Solution solution = new Code743_networkDelayTime().new Solution();
//        Object i0 = {{2,1,1},{2,3,1},{3,4,1}};
//        Object i1 = 2;
//        Object i2 = 2;
//        Object i3 = {{1,2,1}};
//        Object i4 = 2;
        int[][] times = Utils.convertStringTo2DArray("[[1,2,1],[2,3,2],[1,3,4]]");
        int i = solution.networkDelayTime(times, 3, 1);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            // 队列转边
            List<List<Edge>> edges = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                edges.add(i, new ArrayList<>());
            }
            for (int[] connection : times) {
                edges.get(connection[0] - 1).add(new Edge(connection[1] - 1, connection[2]));
            }

//            Utils.printDrawMapDistance(times);

            int[] dijkstra = dijkstra(edges, k - 1);

            for (int q : dijkstra) {
                if (q == Integer.MAX_VALUE) {
                    return -1;
                }
            }

            int asInt = Arrays.stream(dijkstra).max().getAsInt();

            return asInt;
        }


        private int[] dijkstra(List<List<Edge>> edges, int startNode) {
            // 存储到起点的距离
            int[] dist = new int[edges.size()];
            // 初始化为无穷远(不可达)
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[startNode] = 0;
            boolean[] visited = new boolean[edges.size()];


            Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(v -> dist[v]));
            // 使用贪心算法, 每次找距离最近的点
            queue.add(startNode);


            while (!queue.isEmpty()) {
                int currentNode = queue.poll();
                if (visited[currentNode]) {
                    continue;
                }
                visited[currentNode] = true;
                for (Edge nextNode : edges.get(currentNode)) {
                    if (visited[nextNode.target]) {
                        continue;
                    }

                    // 如果距离更小, 则更新数据
                    if (dist[currentNode] + nextNode.weight < dist[nextNode.target]) {
                        dist[nextNode.target] = dist[currentNode] + nextNode.weight;
                        queue.add(nextNode.target);
                    }
                }
            }
//            Utils.printTable(dist);
            return dist;
        }

//        public class Edge {
//            int target;
//            int weight;
//
//            Edge(int target, int weight) {
//                this.target = target;
//                this.weight = weight;
//            }
//        }


    }

    public class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
