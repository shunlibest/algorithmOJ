package com.动态规划;

import java.util.Arrays;

public class Code2312_卖木头块 {
    public static void main(String[] args) {
//        int[][] prices = {{3, 2, 10}, {1, 4, 20}, {4, 1, 3}};
//        long l = new Code2312_卖木头块().sellingWood(4, 6, prices);

        int[][] prices = {{2,3,15},{5,2,10},{1,3,27},{1,2,23},{5,1,11},{4,7,23}};
        long l = new Code2312_卖木头块().sellingWood(5, 9, prices);
//        int[][] prices = {{4, 1, 18}, {4, 2, 5}, {1, 1, 20}, {3, 1, 21}};
//        long l = new Code2312_卖木头块().sellingWood(4, 2, prices);

        System.out.println(l);
    }

    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long maxValue = 0;
                for (int[] price : prices) {
                    if (i - price[0] < -1 || j - price[1] < -1) {
                        continue;
                    }
                    long left = 0;
                    if (i - price[0] >= 0) {
                        left = dp[i - price[0]][j];
                    }

                    long top = 0;
                    if (j - price[1] >= 0) {
                        top = dp[i][j - price[1]];
                    }

                    long startValue = 0;
                    if (i - price[0] >= 0 && j - price[1] >= 0) {
                        startValue = dp[i - price[0]][j - price[1]];
                    }
                    long max = left + top + price[2] - startValue;
                    maxValue = Math.max(maxValue, max);
                }
                dp[i][j] = maxValue;
            }
        }
        for (long[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }

        return dp[m - 1][n - 1];
    }
}
