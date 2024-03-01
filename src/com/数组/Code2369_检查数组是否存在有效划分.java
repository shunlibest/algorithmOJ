package com.数组;

public class Code2369_检查数组是否存在有效划分 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2};
        boolean b = new Code2369_检查数组是否存在有效划分().validPartition(nums);
        System.out.println(b);
    }

    public boolean validPartition(int[] nums) {
        boolean[][] dp = new boolean[nums.length][6];
        dp[0][1] = true;
        dp[0][2] = true;
        dp[0][4] = true;
        for (int i = 1; i < nums.length; i++) {

            if (dp[i - 1][1] && nums[i] == nums[i - 1]) {
                dp[i][0] = true;
            }
            if (dp[i - 1][2] && nums[i] == nums[i - 1]) {
                dp[i][3] = true;
            }
            if (dp[i - 1][3] && nums[i] == nums[i - 1]) {
                dp[i][0] = true;
            }

            if (dp[i - 1][4] && nums[i] == nums[i - 1] + 1) {
                dp[i][5] = true;
            }
            if (dp[i - 1][5] && nums[i] == nums[i - 1] + 1) {
                dp[i][0] = true;
            }

            if (dp[i - 1][0]) {
                dp[i][1] = true;
                dp[i][2] = true;
                dp[i][4] = true;
            }
        }

        return dp[dp.length - 1][0];
    }


}
