package com.动态规划;

public class Code279_完全平方数 {
    public static void main(String[] args) {
        int i = new Code279_完全平方数().numSquares(13);
        System.out.println(i);
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;


        for (int i = 2; i < n + 1; i++) {
            int minTimes = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                minTimes = Math.min(minTimes, dp[i - j * j]);
            }

            dp[i] = minTimes + 1;
        }

        return dp[dp.length - 1];
    }
}
