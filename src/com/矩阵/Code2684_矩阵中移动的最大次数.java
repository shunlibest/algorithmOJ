package com.矩阵;

import java.util.Arrays;

public class Code2684_矩阵中移动的最大次数 {

    public static void main(String[] args) {
        int[][] array = {{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}};
        int i = new Code2684_矩阵中移动的最大次数().maxMoves(array);
        System.out.println(i);

    }

    public int maxMoves(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int maxValue = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int max = 0;
                if (i - 1 >= 0 && j - 1 >= 0 && grid[i][j] > grid[i - 1][j - 1]) {
                    max = Math.max(max, dp[i - 1][j - 1] + 1);
                }
                if (j - 1 >= 0 && grid[i][j] > grid[i][j - 1]) {
                    max = Math.max(max, dp[i][j - 1] + 1);
                }
                if (i - 1 >= 0 && grid[i][j] > grid[i - 1][j]) {
                    max = Math.max(max, dp[i - 1][j] + 1);
                }

                dp[i][j] = max;
                maxValue = Math.max(maxValue, max);
            }
        }
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }

        return maxValue;
    }
}
