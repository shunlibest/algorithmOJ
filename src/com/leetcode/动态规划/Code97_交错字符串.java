package com.leetcode.动态规划;

public class Code97_交错字符串 {

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "";
        String s3 = "a";
        boolean interleave = isInterleave(s1, s2, s3);
        System.out.println(interleave);
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < s1.length()+1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0]) {
                dp[i][0] = true;
            } else {
                dp[i][0] = false;
            }
        }

        for (int i = 1; i < s2.length()+1; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1]) {
                dp[0][i] = true;
            } else {
                dp[0][i] = false;
            }
        }

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if ((s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
