package com.动态规划;

import java.util.Arrays;

public class Code2617_网格图中最少访问的格子数 {
    public static void main(String[] args) {
        int[][] array = {{0, 1, 0}};
        int i = new Code2617_网格图中最少访问的格子数().minimumVisitedCells(array);
        System.out.println(i);
    }

    public int minimumVisitedCells(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                int rightMaxStep = grid[i][j] + j;
                for (int step = j + 1; step <= rightMaxStep && step < grid[0].length; step++) {
                    dp[i][step] = Math.min(dp[i][step], dp[i][j] + 1);
                }

                int bottomMaxStep = grid[i][j] + i;
                for (int step = i + 1; step <= bottomMaxStep && step < grid.length; step++) {
                    dp[step][j] = Math.min(dp[step][j], dp[i][j] + 1);
                }

                if ( dp[grid.length - 1][dp[0].length - 1] == 1){
                    return 1;
                }
            }
        }
        int res = dp[grid.length - 1][dp[0].length - 1];

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
