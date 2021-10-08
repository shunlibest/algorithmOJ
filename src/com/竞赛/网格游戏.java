package com.竞赛;

import java.util.Arrays;

//https://leetcode-cn.com/contest/weekly-contest-260/problems/maximum-difference-between-increasing-elements/
public class 网格游戏 {


    public static void main(String[] args) {

        int[][] input = new int[][]{{2, 5, 4},
                {1, 5, 1}};


        long xxx = gridGame(input);


        System.out.println(xxx);
    }

    public static long gridGame(int[][] grid) {
        int[] topSum = new int[grid[0].length];
        int[] bottomSum = new int[grid[0].length];

        topSum[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            topSum[i] = topSum[i - 1] + grid[0][i];
        }

        bottomSum[bottomSum.length - 1] = grid[1][bottomSum.length - 1];
        for (int i = bottomSum.length - 2; i >= 0; i--) {
            bottomSum[i] = bottomSum[i + 1] + grid[1][i];
        }

        System.out.println(Arrays.toString(topSum));
        System.out.println(Arrays.toString(bottomSum));

        long maxSum = 0;
        int maxSumIndex = 0;
//        for (int i = 0; i < topSum.length; i++) {
//            if (topSum[i]+bottomSum[i]>sum)
//        }

        return 0;
    }
}
