package com.图;

import java.util.Arrays;

public class Dij {

    public static void main(String[] args) {
        // 创建图的邻接矩阵表示
        int graph[][] = new int[][]{
                {0, 1, 4, 0},
                {1, 0, 2, 5},
                {4, 2, 0, 4},
                {0, 5, 4, 0}
        };
        // 执行迪杰斯特拉算法
        dij(graph); // 以顶点0为源点
    }

    private static void dij(int[][] matrix) {
        // 集合1:已经访问的节点, 也就是可以100%保证, 里面的点距离起点的最小距离不会再发生变动的点.
        boolean[] visited = new boolean[matrix.length];

        // 集合2: 当前根据已知条件(已遍历的点), 可以求出距离起点的距离, 但此处的距离, 可能会发生变动.
        int[] nodeDistance = new int[matrix.length];

        // 初始化, 当前未开始遍历任何一个节点, 所以根据已知条件, 可以得出, 任何一个节点都无法到达起点. 可以设置为无限远
        Arrays.fill(nodeDistance, Integer.MAX_VALUE);

        // 默认从起点开始[0], 因此自己到自己的距离是0, 这个0也是能100%确定的最小距离, 因此可以确定为已访问(也可以不加)
        nodeDistance[0] = 0;

        // 下面正式开始, 每个节点都要遍历一次, 因此要遍历N次
        for (int i = 0; i < matrix.length; i++) {
            // 找出当前要访问的节点, 从距离起点最近的节点中选出来, 此节点需要重来没有访问过
            int minDistanceIndex = findMinDistance(visited, nodeDistance);

            // 开始访问此节点
            visited[minDistanceIndex] = true;

            for (int j = 0; j < matrix.length; j++) {
                // 开始更新nodeDistance

                // 已经访问过的点, 无需访问
                if (visited[j]) {
                    continue;
                }
                // 不可达的点
                int nextDis = matrix[minDistanceIndex][j];
                if (nextDis == 0) {
                    continue;
                }

                // 如果下一个点距离 + 当前点距离原点的距离 < 不访问当前点时, 下一个点距离原点的距离, 则更新最短距离
                if (nextDis + nodeDistance[minDistanceIndex] < nodeDistance[j]) {
                    nodeDistance[j] = nextDis + nodeDistance[minDistanceIndex];
                }

            }
        }


        System.out.println(nodeDistance[nodeDistance.length - 1]);

    }

    private static int findMinDistance(boolean[] visited, int[] nodeDistance) {
        int minIndex = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < nodeDistance.length; i++) {
            // 已经访问过的节点, 不会再访问了
            if (visited[i]) {
                continue;
            }
            if (nodeDistance[i] < minDistance) {
                minIndex = i;
                minDistance = nodeDistance[i];
            }
        }
        return minIndex;
    }
}
