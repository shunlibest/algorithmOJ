package com.hanshunli;

public class Main {

    public static void main(String[] args) {
        int count = count2(6);
        System.out.println(count);


    }

    private static int count(int step) {
        if (step == 1 || step == 0) {
            return 1;
        }
        if (step == 2) {
            return 2;
        }
        int sum = count(step - 1) + count(step - 2) + count(step - 3);
        return sum;
    }

    private static int count2(int step) {
        int[] dp = new int[step];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < step; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[step-1];
    }
}
