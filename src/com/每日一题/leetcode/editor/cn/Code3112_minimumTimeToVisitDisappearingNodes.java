package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.*;

/**
 * [每日一题] 2024-08-29 11:38:39
 * 题目名称: 访问消失节点的最少时间
 * 题目类型:
 * 思考:
 */


public class Code3112_minimumTimeToVisitDisappearingNodes {
    public static void main(String[] args) {
        Solution solution = new Code3112_minimumTimeToVisitDisappearingNodes().new Solution();
        int[][] times = Utils.convertStringTo2DArray("[[0,1,2],[1,2,1],[0,2,4]]");

        int[] disappear = {1, 1, 5};
//        int i = solution.networkDelayTime(times, 3, 1);
//        System.out.println(i);
        int[] ints = solution.minimumTime(3, times, disappear);

        Utils.printTable(ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        class Edge {
            int node;
            int length;

            Edge(int node, int length) {
                this.node = node;
                this.length = length;
            }
        }

        class State implements Comparable<State> {
            int node;
            int time;

            State(int node, int time) {
                this.node = node;
                this.time = time;
            }

            public int compareTo(State other) {
                return Integer.compare(this.time, other.time);
            }
        }

        public  int[] minimumTime(int n, int[][] edges, int[] disappear) {
            List<List<Edge>> graph = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int length = edge[2];
                graph.get(u).add(new Edge(v, length));
                graph.get(v).add(new Edge(u, length));
            }
            int[] minTime = new int[n];

            // PriorityQueue using Comparator comparing minTime
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(v -> minTime[v]));
            boolean[] visited = new boolean[n];

            Arrays.fill(minTime, Integer.MAX_VALUE);
            minTime[0] = 0;

            pq.offer(0);

            while (!pq.isEmpty()) {
                int currentNode = pq.poll();
                int currentTime = minTime[currentNode];

                if (visited[currentNode]) {
                    continue;
                }

                visited[currentNode] = true;

                for (Edge edge : graph.get(currentNode)) {
                    int nextNode = edge.node;
                    int arrivalTime = currentTime + edge.length;

                    if (!visited[nextNode] && arrivalTime < disappear[nextNode] && arrivalTime < minTime[nextNode]) {
                        minTime[nextNode] = arrivalTime;
                        pq.offer(nextNode);
                    }
                }
            }

            int[] answer = new int[n];
            for (int i = 0; i < n; i++) {
                answer[i] = minTime[i] == Integer.MAX_VALUE ? -1 : minTime[i];
            }

            return answer;
        }


        private int[] dijkstra(List<List<Edge>> graph, int n, int[] disappear) {
            int[] minTime = new int[n];
            boolean[] visited = new boolean[n];

            PriorityQueue<Integer> pq =  new PriorityQueue<>(Comparator.comparingInt(v -> minTime[v]));

            Arrays.fill(minTime, Integer.MAX_VALUE);
            minTime[0] = 0;

            pq.offer(0);

            while (!pq.isEmpty()) {
                int current = pq.poll();
                int currentNode = current;
                int currentTime = minTime[currentNode];

                if (visited[currentNode]) {
                    continue;
                }

                visited[currentNode] = true;

                for (Edge edge : graph.get(currentNode)) {
                    int nextNode = edge.node;
                    int arrivalTime = currentTime + edge.length;

                    if (!visited[nextNode] && arrivalTime < disappear[nextNode] && arrivalTime < minTime[nextNode]) {
                        minTime[nextNode] = arrivalTime;
                        pq.offer(nextNode);
                    }
                }
            }
            return minTime;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
