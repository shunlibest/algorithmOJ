package com.leetcode.动态规划;

public class Code45_跳跃游戏2 {

    public static void main(String[] args) {
        int[] array = new int[]{0};
        int jump = jump(array);
        System.out.println(jump);

    }


    public static int jump(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int minJump = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {

                if (nums[j] + j >= i) {
                    minJump = Math.min(minJump, dp[j]);
                }

            }
            dp[i] = minJump + 1;
        }
        return dp[nums.length - 1];
    }

}


