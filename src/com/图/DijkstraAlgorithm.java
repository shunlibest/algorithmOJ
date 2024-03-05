package com.图;

import java.util.Arrays;

public class DijkstraAlgorithm {

    // 一个非常大的数，用于初始化最短路径估计值
    private static final int INF = Integer.MAX_VALUE;

    // 迪杰斯特拉算法
    public static void dijkstra(int[][] graph, int src) {
        int vertices = graph.length;
        int[] dist = new int[vertices]; // 存储最短路径长度
        Arrays.fill(dist, INF); // 将所有顶点的最短路径估计值设置为无限大
        dist[src] = 0; // 设置源点的距离为0

        boolean[] visited = new boolean[vertices]; // 标记顶点是否已经被访问过

        for (int i = 0; i < vertices - 1; i++) {
            // 查找未访问顶点中距离最短的顶点
            int u = findMinDistanceVertex(dist, visited);
            visited[u] = true; // 标记该顶点已访问

            // 更新邻接顶点的最短路径
            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // 打印最短路径结果
        printSolution(dist);
    }

    // 查找未访问顶点中距离最短的顶点
    public static int findMinDistanceVertex(int[] dist, boolean[] visited) {
        int minDistance = INF;
        int minDistanceVertex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] < minDistance) {
                minDistance = dist[v];
                minDistanceVertex = v;
            }
        }
        return minDistanceVertex;
    }

    // 打印最短路径结果
    public static void printSolution(int[] dist) {
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + "\t\t" + (dist[i] == INF ? "INF" : dist[i]));
        }
    }

    public static void main(String[] args) {
        // 创建图的邻接矩阵表示
        int graph[][] = new int[][]{
                {0, 1, 4, 0},
                {1, 0, 2, 5},
                {4, 2, 0, 1},
                {0, 5, 1, 0}
        };
        // 执行迪杰斯特拉算法
        dijkstra(graph, 0); // 以顶点0为源点
    }
}
