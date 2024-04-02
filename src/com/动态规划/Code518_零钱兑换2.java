package com.动态规划;

import java.util.Arrays;

public class Code518_零钱兑换2 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int change = new Code518_零钱兑换2().change(5, coins);
        System.out.println(change);
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 1; i < dp.length; i++) {
                if (i - coin >= 0 && dp[i - coin] != 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[dp.length - 1];
    }
}
