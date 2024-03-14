package com.动态规划;

public class Code198_打家劫舍 {
    public static void main(String[] args) {
        int[] array = {0};
        int rob = new Code198_打家劫舍().rob(array);
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length <= 1) {
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], (dp[i - 2] + nums[i]));
        }
        return dp[dp.length - 1];
    }
}
