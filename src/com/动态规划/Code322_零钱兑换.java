package com.动态规划;

public class Code322_零钱兑换 {

    public static void main(String[] args) {
        int[] coins = {1};
        int amount = 0;
        int i = new Code322_零钱兑换().coinChange(coins, amount);
        System.out.println(i);
    }


    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int money : coins) {
                if (i - money < 0 || dp[i - money] == -1) {
                    continue;
                }
                min = Math.min(min, dp[i - money]);
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            }else {
                dp[i] = min + 1;
            }
        }
        return dp[dp.length - 1];
    }
}
