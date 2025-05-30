package com.每日一题.leetcode.editor.cn;

import com.Utils;
import javafx.util.Pair;

import java.util.*;

/**
 * [每日一题] 2024-08-29 14:20:58
 * 题目名称: 概率最大的路径
 * 题目类型:
 * 思考:
 */


public class Code1514_pathWithMaximumProbability {
    public static void main(String[] args) {
        Solution solution = new Code1514_pathWithMaximumProbability().new Solution();
        Object i0 = 3;
//        Object i1 = {0.5,0.5,0.2};
//        Object i2 = 2;
//        Object i3 = {{0,1},{1,2},{0,2}};
//        Object i4 = 0;
//        Object i5 = 3;
//        Object i6 = {0.5};
        Object i7 = 2;

        int[][] edges = Utils.convertStringTo2DArray("[[0,9],[6,11],[4,17],[8,12],[14,17],[4,0],[8,19],[2,8],[7,3],[10,17],[12,19],[13,1],[0,16],[1,12],[6,10],[9,14],[2,3],[1,11],[17,19],[4,18],[11,4],[0,7],[2,10],[7,12],[5,10],[12,14],[14,19],[9,10],[10,12],[19,10],[10,13],[19,3],[15,11],[16,2],[15,7],[13,9],[16,3],[15,1],[13,18],[9,5],[0,8],[6,4],[1,2],[0,11],[7,2],[17,8],[10,18],[5,12],[6,7],[7,16],[14,11],[12,13],[6,8],[2,6],[9,11],[16,10],[13,6],[3,8],[14,4],[15,6],[15,18],[1,4],[4,8],[3,9],[5,3],[4,12],[11,7],[10,0],[14,1],[2,0],[12,6],[1,0],[5,16],[2,5],[10,4],[10,11],[2,18],[15,5],[19,9],[8,9],[17,1],[2,15],[15,10],[6,16],[5,14],[3,6],[8,10],[12,18],[6,1],[18,0],[15,8],[11,16],[5,19],[0,19],[17,3],[9,17],[16,15],[3,11],[12,9],[4,2],[14,7],[19,16],[2,14],[18,7],[3,13],[5,1],[1,7],[9,1],[1,16],[7,13],[16,8],[5,6],[13,2],[15,3],[14,10],[3,18],[0,15],[14,16],[5,18],[16,4],[0,14],[7,19],[6,19],[18,19],[8,18],[17,16],[11,5],[5,4],[2,11],[19,11],[0,13],[6,0],[9,2],[18,16],[11,18],[2,17],[7,8],[7,5],[11,17],[3,4],[9,4],[13,14],[13,15],[19,15],[1,10],[18,9],[9,7],[4,15],[14,8],[1,8],[3,10],[19,4],[19,2],[8,5],[0,17],[11,8],[15,12],[12,0],[0,3],[17,5],[17,12],[1,19],[5,0],[7,17],[13,11],[10,7],[6,17],[11,12],[13,4],[18,17],[16,9],[13,8],[15,9],[13,5],[15,14],[18,14],[13,16],[1,3],[1,18],[14,6],[16,12],[6,18],[6,9]]");
        double[] succProb = {0.8034, 0.4845, 0.9491, 0.275, 0.4748, 0.6327, 0.204, 0.141, 0.2436, 0.1634, 0.6329, 0.9277, 0.8033, 0.8569, 0.7035, 0.6623, 0.9642, 0.2587, 0.493, 0.9525, 0.8741, 0.1064, 0.1258, 0.5924, 0.4279, 0.7027, 0.1997, 0.6898, 0.3876, 0.4882, 0.755, 0.8104, 0.2179, 0.4137, 0.7009, 0.1513, 0.0125, 0.9724, 0.1166, 0.2216, 0.746, 0.3061, 0.8231, 0.8261, 0.0872, 0.7748, 0.6571, 0.2954, 0.2594, 0.9896, 0.2086, 0.8478, 0.0801, 0.8931, 0.5456, 0.6698, 0.3146, 0.0913, 0.4775, 0.5485, 0.5276, 0.2652, 0.0003, 0.9899, 0.7481, 0.1121, 0.3518, 0.9968, 0.0462, 0.8877, 0.4986, 0.6148, 0.7025, 0.4006, 0.5022, 0.5113, 0.7362, 0.7995, 0.3859, 0.3093, 0.9112, 0.7292, 0.2118, 0.1951, 0.4578, 0.12, 0.7304, 0.0004, 0.9045, 0.3064, 0.7647, 0.694, 0.9022, 0.0632, 0.9982, 0.5049, 0.98, 0.0235, 0.068, 0.0751, 0.8295, 0.0834, 0.5588, 0.0343, 0.2307, 0.107, 0.9371, 0.7282, 0.6736, 0.2076, 0.0991, 0.8601, 0.6118, 0.4578, 0.2787, 0.4349, 0.8452, 0.3591, 0.8005, 0.3297, 0.6573, 0.591, 0.6822, 0.2518, 0.6538, 0.6176, 0.9352, 0.8758, 0.4037, 0.7785, 0.7201, 0.4327, 0.1664, 0.9889, 0.4662, 0.9246, 0.0998, 0.9905, 0.978, 0.405, 0.206, 0.1661, 0.8647, 0.1496, 0.6509, 0.7509, 0.0974, 0.2403, 0.0641, 0.8365, 0.0142, 0.3892, 0.794, 0.9198, 0.027, 0.3786, 0.8792, 0.6103, 0.2488, 0.5838, 0.2196, 0.9787, 0.3474, 0.1726, 0.8073, 0.7203, 0.2355, 0.057, 0.244, 0.0731, 0.2281, 0.0484, 0.5085, 0.1538, 0.9677, 0.6539, 0.8041, 0.9386, 0.9208, 0.0653, 0.4476, 0.3843, 0.7323};
        int start = 10;
        int end = 18;
        double v = solution.maxProbability(20, edges, succProb, start, end);

        System.out.println(v);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            // 队列转边
            List<List<Pair<Integer, Double>>> edgeList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                edgeList.add(i, new ArrayList<>());
            }

            for (int i = 0; i < edges.length; i++) {
                edgeList.get(edges[i][0]).add(new Pair<>(edges[i][1], succProb[i]));
                edgeList.get(edges[i][1]).add(new Pair<>(edges[i][0], succProb[i]));
            }


//            Utils.printDrawMapDistance(times);

            double[] dijkstra = dijkstra(edgeList, start_node, end_node);

//            Utils.printTable(dijkstra);

            return dijkstra[end_node];
        }

        private double[] dijkstra(List<List<Pair<Integer, Double>>> edges, int startNode, int end) {
            // 存储到起点的距离
            double[] dist = new double[edges.size()];
            // 初始化为无穷远(不可达)
            Arrays.fill(dist, 0);
            dist[startNode] = 1.0;
            boolean[] visited = new boolean[edges.size()];


//            Queue<Pair<Integer, Double>> queue = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));
            Queue<Pair<Integer, Double>> queue = new PriorityQueue<>(Comparator.comparingDouble(v -> -dist[v.getKey()]));
            // 使用贪心算法, 每次找距离最近的点
            queue.add(new Pair<>(startNode, 1.0));


            while (!queue.isEmpty()) {
                Pair<Integer, Double> current = queue.poll();
                int currentNode = current.getKey();
                if (visited[currentNode]) {
                    continue;
                }

                System.out.print(currentNode + ",");
//                if (currentNode == end) {
//                    System.out.println(dist[currentNode]);
//                }

                visited[currentNode] = true;
                for (Pair<Integer, Double> nextNode : edges.get(currentNode)) {
                    if (visited[nextNode.getKey()]) {
                        continue;
                    }

                    // 如果距离更小, 则更新数据
                    if (dist[currentNode] * nextNode.getValue() > dist[nextNode.getKey()]) {
                        dist[nextNode.getKey()] = dist[currentNode] * nextNode.getValue();
                        queue.add(new Pair<>(nextNode.getKey(), dist[nextNode.getKey()]));
                    }

                }
                System.out.print("");

            }
//            Utils.printTable(dist);
            return dist;
        }
    }

//    public class Edge {
//        int target;
//        double weight;
//
//        Edge(int target, double weight) {
//            this.target = target;
//            this.weight = weight;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}
