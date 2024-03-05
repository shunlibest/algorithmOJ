package com.图;

import java.util.Arrays;

public class Code1976_到达目的地的方案数 {

    public static void main(String[] args) {
        int[][] array = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
        int i = new Code1976_到达目的地的方案数().countPaths(7, array);
        System.out.println(i);
    }


    public int countPaths(int n, int[][] roads) {
        // 使用邻接矩阵标示图
        long[][] matrix = new long[n][n];
        for (int[] road : roads) {
            matrix[road[0]][road[1]] = road[2];
            matrix[road[1]][road[0]] = road[2];
        }

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        long[] minDistance = new long[n];
        Arrays.fill(minDistance, Long.MAX_VALUE);

        // 统计到原点的方法次数
        long[] countPath = new long[n];

        minDistance[0] = 1;
        countPath[0] = 1;

        for (int i = 0; i < n; i++) {
            int minDistanceIndex = findMinDistanceIndex(visited, minDistance);
            // 访问改点
            visited[minDistanceIndex] = true;

            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    continue;
                }
                long nextPointDistance = matrix[minDistanceIndex][j];
                if (nextPointDistance == 0) {
                    // 不可达
                    continue;
                }

                if (minDistance[minDistanceIndex] + nextPointDistance < minDistance[j]) {
                    // 更新minDistance[j]
                    minDistance[j] = minDistance[minDistanceIndex] + nextPointDistance;
                    countPath[j] = countPath[minDistanceIndex];
                } else if (minDistance[minDistanceIndex] + nextPointDistance == minDistance[j]) {
                    //相等的情况
                    countPath[j] = countPath[j] + countPath[minDistanceIndex];
                }

                countPath[j] = (countPath[j] % (10_0000_0007));
            }
        }
        return (int) (countPath[n - 1] % (10_0000_0007));
    }

    private int findMinDistanceIndex(boolean[] visited, long[] minDistance) {
        int minIndex = -1;
        long minDis = Long.MAX_VALUE;
        for (int i = 0; i < minDistance.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (minDistance[i] < minDis) {
                minDis = minDistance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
